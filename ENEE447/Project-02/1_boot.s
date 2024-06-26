.equ    FIQSTACK3 , 21504
.equ    IRQSTACK3 , 22528
.equ    KSTACK3   , 38912
.equ    USTACK3   , 71680
.equ    FIQSTACK2 , 21248
.equ    IRQSTACK2 , 22272
.equ    KSTACK2   , 34816
.equ    USTACK2   , 63488
.equ    FIQSTACK1 , 20992
.equ    IRQSTACK1 , 22016
.equ    KSTACK1   , 30720
.equ    USTACK1   , 55296
.equ    FIQSTACK0 , 20736
.equ    IRQSTACK0 , 21760
.equ    KSTACK0   , 26624
.equ    USTACK0   , 47104
.equ	USR_mode,	0x10
.equ	FIQ_mode,	0x11
.equ	IRQ_mode,	0x12
.equ	SVC_mode,	0x13
.equ	HYP_mode,	0x1A
.equ	SYS_mode,	0x1F
.equ	No_Int,		0xC0

.globl _start
_start:
	@ jump table:
	b reset				@ RESET handler				- runs in SVC mode
	b hang				@ UNDEFINED INSTR handler	- runs in UND mode
	b swi_handler		@ SWI (TRAP) handler		- runs in SVC mode
	b hang				@ PREFETCH ABORT handler	- runs in ABT mode
	b hang				@ DATA ABORT handler		- runs in ABT mode
	b hang				@ HYP MODE handler			- runs in HYP mode
	b irq_handler		@ IRQ INTERRUPT handler		- runs in IRQ mode
	b hang				@ FIQ INTERRUPT handler		- runs in FIQ mode
 
reset:

	mrc p15, 0, r0, c1, c0, 0 @ Read System Control Register
@	orr r0, r0, #(1<<2)       @ dcache enable
	orr r0, r0, #(1<<12)      @ icache enable
	and r0, r0, #0xFFFFDFFF   @ turn on vector table at 0x0000000 (bit 12)
	mcr p15, 0, r0, c1, c0, 0 @ Write System Control Register

@ check core ID
	mrc     p15, 0, r0, c0, c0, 5
	ubfx    r0, r0, #0, #2
	cmp     r0, #0					@ is it core 0?
	beq     core0

	@ it is not core0, so do things that are appropriate for SVC level as opposed to HYP
	@ like set up separate stacks for each core, etc.

	mrc     p15, 0, r0, c0, c0, 5
	ubfx    r0, r0, #0, #2
	cmp     r0, #1					@ is it core 1?
	beq     core1
	cmp     r0, #2					@ is it core 2?
	beq     hang
	cmp     r0, #3					@ is it core 3?
	beq     hang

	@ CPU ID is not 0..3 - huh?
	b hang

@ SWI (TRAP) INTERRUPT HANDLER
@ Most of this came from the PDF file on the course website
swi_handler:
	push 	{r0-r12}
	mov		r2, # No_Int | SVC_mode
	msr 	cpsr_c, r2
	bl		blink_green
	mrs		r1, cpsr
	bic		r1, r1,#0xC0
	msr		cpsr_c, r1
	pop		{r0-r12}
	movs	pc, lr

@ IRQ INTERRUPT HANDLER
@ Most of thiscame from the PDF file on the course website
irq_handler:
	push	{r0-r12}
	mov		r2, # No_Int | IRQ_mode
	msr		cpsr_c,	r2
	bl		blink_red
	mov		r0, #1
	bl		clear_interrupt
	mrs		r1, cpsr
	bic		r1, r1, #0x80
	msr		cpsr_c, r1
	pop		{r0-r12}
	subs	pc, r14, #4	
	
core1:
	mov 	r2, # No_Int | IRQ_mode
	msr		cpsr_c, r2
	mov		sp, # IRQSTACK1
	mov 	r2, # No_Int | FIQ_mode
	msr		cpsr_c, r2
	mov		sp, # FIQSTACK1
	mov 	r2, # No_Int | SVC_mode
	msr		cpsr_c, r2
	mov		sp, # KSTACK1

	bl		enable_irq

	mov 	r2, # USR_mode
	msr		cpsr_c, r2
	mov		sp, # USTACK1
	bl		userspace

hang: b hang

core0:
	mov 	r2, # No_Int | IRQ_mode
	msr		cpsr_c, r2
	mov		sp, # IRQSTACK0

	mov 	r2, # No_Int | FIQ_mode
	msr		cpsr_c, r2
	mov		sp, # FIQSTACK0

	mov 	r2, # No_Int | HYP_mode
	msr		cpsr_c, r2
	mov		sp, # KSTACK0

	bl		kernel
	b hang
