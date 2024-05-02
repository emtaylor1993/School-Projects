#include "hype.h"

extern unsigned int interrupt_core(unsigned int);
extern void init_video_code(void);

unsigned char init_kernel[50] = "Kernel: Core 0 Started!"
unsigned char init_core1[50] = "Kernel: Core 1 Started!"

void kernel() {
	unsigned int then, now, delta;
	
	init_video_code();
	#include "initf.auto"
	
	print_text(start_kernel);
	
	then = now_usec();
	while (1) {
		now = now_usec();
		delta = usec_diff(now, then);
		if (delta > 2 * ONE_SEC) {
			then = now;
			print_text(init_core1);
			interrupt_core(1);
			while (1)
				continue;
		}
	}
}