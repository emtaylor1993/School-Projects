#include <stdio.h>
#include "histgen.h"
#include "adtutil.h"

int main(void) {
	histgen_type *hist;
	int bins[] = {1, 2, 3, 4, 5, 6};
	int num_bins = 3;
	int w = 1;
	int h = 1;
	int stride = 4;
	int retVal = 0;

	printf("\nTesting the \"histgen_set_height\" function...\n");

	hist = histgen_new(bins, num_bins, w, h, stride);	

	printf("Value of height before calling: %d.\n", retVal);
	
	if (hist != NULL) {	
		DLC_VMETHOD_CALL_X(histgen, set_height, hist, h);
		retVal = DLC_VMETHOD_CALL(histgen, get_height, hist);
		printf("Method call complete...\n");
		printf("Value of height after calling: %d.\n", retVal);
	} else {
		DLC_VMETHOD_CALL_X(histgen, set_height, hist, h);
		retVal = DLC_VMETHOD_CALL(histgen, get_height, hist);
		printf("Method call complete...\n");
		printf("Value of height after calling: %d.\n", retVal);
	}
	
	if (retVal == 1) {
		printf("Test 04: Set Height passed!\n");
	} else {
		printf("Test 04: Set Height failed.\n");
	}

	printf("\n");

	return 0;
}
