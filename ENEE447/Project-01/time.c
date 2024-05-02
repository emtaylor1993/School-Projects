//
// time library
//

#include "time.h"

// external function definitions
extern unsigned int GET32(unsigned int);
extern void PUT32(unsigned int, unsigned int);
extern void dummy (unsigned int);

unsigned int gettime() {
	unsigned int time_val = GET32(0x4000001C);
	return time_val;
}

unsigned int timediff(unsigned int now, unsigned int then) {
	unsigned int diff = now - then;
	
	if (now < then) {
		diff += 0xFFFFFFFF;
	}
	
	return diff;
}

void wait(unsigned int time){
	PUT32(0x40000008, 0x80000000);
	unsigned int then = gettime();
	unsigned int now;
	
	do {
		now = gettime();
	} while (timediff(now, then) < time);
}
