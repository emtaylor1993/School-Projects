//
// time library
//

#include "time.h"

unsigned int gettime() {
	unsigned int time = GET32(0x40000010);
	return time;
}

unsigned int timediff(unsigned int now, unsigned int then) {	
	unsigned int difference = now - then;
	return difference;
}

void wait( unsigned int time) {
	// your code goes here
}
