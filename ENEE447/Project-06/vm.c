#include "hype.h"

//
// Your task: map it so that led.c works ... 
// it is currently using these two sets of addresses:
//
// #define GPFSEL3 0x3F20000C
// #define GPFSEL4 0x3F200010
// #define GPSET1  0x3F200020
// #define GPCLR1  0x3F20002C
//
// #define V_GPFSEL3 0x0020000C
// #define V_GPFSEL4 0x00200010
// #define V_GPSET1  0x00200020
// #define V_GPCLR1  0x0020002C
//
// ... and only the ones that go to 0x3F2xxxxx work. The "V_" addresses
// do not currently work ... they are going to "virtual" locations that
// end up having nothing to do with the GPIOs.
//
// You are to use virtual memory to map the following:
//
//	0x002xxxxx -> 0x3F2xxxxx
//	0x3F2xxxxx -> 0x3F2xxxxx
//
// and you'll also want to map this, so that your code & data still work:
//
//	0x000xxxxx -> 0x000xxxxx
//

#define	PT_START	0x00100000
#define PT_STOP		0x00101000
#define NUM_MASK	0xFFF00000

unsigned int *pagetable;

// sets up a mapping in the page table between the VPN and PFN, which are
// represented by the vaddr and paddr values.
// note that io addresses need to have different information in the PTE
void map(unsigned int vaddr, unsigned int paddr, int io_addr) {
	unsigned int pt_entry = 0;
	unsigned int vpn = vaddr & NUM_MASK;
	unsigned int pfn = vaddr & NUM_MASK;
	pt_entry |= pfn;
	pt_entry |= 2;
	pt_entry |= 0xC00;
	pagetable[vpn >> 20] = pt_entry;
}

// turns on the system
void enable_vm() {
	unsigned int ttcbr_control = readTTCBR();
	unsigned int sctlr_control = readSCTLR();
	map(0x3F200000, 0x3F200000, 1);
	map(0x00200000, 0x00200000, 1);
	map(0x40000000, 0x40000000, 0);
	map(0x00000000, 0x00000000, 0);
	sctlr_control |= 1;
	writeTTBCR(0);
	writeTTBR0(PT_START);
	writeDACR(0xFFFFFFFF);
	writeSCTLR(sctlr_control);
}

// first set everything to zeroes
void initialize_table() {
	int table_index;
	for (table_index = 0; table_index < 4096; table_index++) {
		pagetable[table_index] = 0;
	}
}

// this is actually run by core0 at startup
void _init_vm() {
	pagetable = (unsigned int *)PT_START;
	initialize_table();
}