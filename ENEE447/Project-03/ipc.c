/*
 * IPC
 */

#include "hype.h"

#define	VALIDBIT	0x80000000
#define	IDMASK		0x30000000
#define	MSGBITS		0x0FFFFFFF

/* set bits - write-only */
#define INT_SET_BASE			0x40000080

/* clear bits - read/write */
#define INT_CLR_BASE			0x400000C0

void interrupt_core(unsigned int core) {
	PUT32(INT_SET_BASE + ((core & 0xf) << 4), 0x1);
}

void clear_interrupt(unsigned int core) {
	PUT32(INT_CLR_BASE + ((core & 0xf) << 4), 0xFFFFFFFF);
}

//
// sets the top bit (bit 31) of the outgoing message 					(VALIDBIT)
// sets the sender ID, determined by calling cpu_id(), in bits 28-29	(IDMASK)
// puts the user's message into bits 0-27 								(MSGBITS)
// returns a Boolean 
// 0 - msg not delivered (if dest MBOX is full)		[kernel ignores this]
// 1 - otherwise
//
unsigned int send(unsigned int dest, unsigned int msg) {	
	int core = cpu_id();
	unsigned int clr_dest;

	// setting the top bit and sender ID
	msg |= 0x80000000;
	msg |= (core << 28);
	
	// choosing the read/clear mailbox based on dest
	if (dest == 0) {
		clr_dest = 0x400000C0;
	} else if (dest == 1) {
		clr_dest = 0x400000D0;
	} else if (dest == 2) {
		clr_dest = 0x400000E0;
	} else {
		return NACK;
	}
	
	// if that mailbox is clear, write to it's write mailbox
	if (!GET32(clr_dest)) {
		if (dest == 0) {
			interrupt_core(0);
			PUT32(0x40000080, msg);
			return 1;
		} else if (dest == 1) {
			PUT32(0x40000090, msg);
			return 1;
		} else if (dest == 2) {
			PUT32(0x400000A0, msg);
			return 1;
		} else {
			return NACK;
		}
	} else {
		return NACK;
	}
	
	return NACK;
}

//
// returns the message received in MBOX
// return NACK (zero) if a timeout occurs - i.e., if
// time expires and there is still no valid message to read
//
unsigned int recv(unsigned int timeout) {
	int core = cpu_id();
	unsigned int msg;
	
	// reading the read/clear mailbox based on the core
	while (timeout--) {
		if (core == 0) {
			msg = GET32(0x400000C0);
			clear_interrupt(0);
			PUT32(0x400000C0, 0);
			return msg;
		} else if (core == 1) {
			msg = GET32(0x400000D0);
		} else if (core == 2) {
			msg = GET32(0x400000E0);
		} else if (core == 3) {
			return NACK;
		}
	
		// returns the message data unless the timeout expires or and
		// there is not a valid message to return
		if (MSG_VALID(msg)) {
			return msg;
		}
	} 
	
	return NACK;
}

//
// this is what the kernel code can call instead of recv, because it has no 
// timeout, and you don't care if it returns a valid message or not
// ... if you think it's simpler, you can just have one recv() function 
// that both kernel and apps call ... for me, this was easier
//
unsigned int krecv() {
	unsigned int msg = GET32(0x400000C0);
	clear_interrupt(0);
	PUT32(0x400000C0, 0);
	return msg;
}

void _init_ipc() {
	unsigned int i;

	for (i=0; i < NUM_CORES; i++) {
		PUT32(0x400000C0, 0);
		PUT32(0x400000D0, 0);
		PUT32(0x400000E0, 0);
		PUT32(0x400000F0, 0);
	}

	#define INT_IRQ	0x0F
	#define INT_FIQ	0xF0
	#define INT_NONE 0

	// mailboxes & interrupts
	PUT32(0x40000050, INT_FIQ);		// mbox 0 interrupts by FIQ; note: IRQ used by timer
	PUT32(0x40000054, INT_NONE);	// mboxes 1..3 *do not* interrupt, for now
	PUT32(0x40000058, INT_NONE);
	PUT32(0x4000005C, INT_NONE);

	return;
}
