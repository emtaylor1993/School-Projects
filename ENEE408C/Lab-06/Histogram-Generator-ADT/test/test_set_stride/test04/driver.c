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

	printf("\nTesting the \"histgen_set_stride\" function...\n");

	hist = histgen_new((int *)bins, num_bins, w, h, stride);	

	printf("Value of stride before calling: %d.\n", retVal);
	
	if (hist != NULL) {	
		DLC_VMETHOD_CALL_X(histgen, set_stride, hist, stride);
		retVal = DLC_VMETHOD_CALL(histgen, get_stride, hist);
		printf("Method call complete...\n");
		printf("Value of stride after calling: %d.\n", retVal);
	} else {
		DLC_VMETHOD_CALL_X(histgen, set_stride, hist, stride);
		retVal = DLC_VMETHOD_CALL(histgen, get_stride, hist);
		printf("Method call complete...\n");
		printf("Value of stride after calling: %d.\n", retVal);
	}
	
	if (retVal == 4) {
		printf("Test 04: Set Stride passed!\n");
	} else {
		printf("Test 04: Set Stride failed.\n");
	}

	printf("\n");

	return 0;
}
