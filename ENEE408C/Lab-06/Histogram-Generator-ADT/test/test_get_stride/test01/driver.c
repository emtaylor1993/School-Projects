#include <stdio.h>
#include "histgen.h"
#include "adtutil.h"

int main(void) {
	histgen_type *hist;
	int bins[] = {1, 2, 3, 4, 5, 6, 7, 8};
	int num_bins = 4;
	int w = 4;
	int h = 1;
	int stride = 8;
	int retVal;

	printf("\nTesting the \"histgen_get_stride\" function...\n");

	hist = histgen_new(bins, num_bins, w, h, stride);

	retVal = DLC_VMETHOD_CALL(histgen, get_stride, hist);

	printf("Method call complete...\n");

	if (retVal == 8) {
		printf("\nThe value returned was: %d\n", retVal);
		printf("Test 01: Get Stride passed!\n");
	} else {
		printf("\nThe value returned was: %d\n", retVal);
		printf("Test 01: Get_Stride failed.\n");
	}

	printf("\n");
	
	return 0;
}


