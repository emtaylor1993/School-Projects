//
// time.h
//
// information regarding the time library
//

#define	ONE_SECOND	(0x1 << 20)			// you define this however you want/need 0xdeadbeef

extern unsigned int gettime(void);
extern unsigned int timediff(unsigned int now, unsigned int then);
extern void wait(unsigned int time);