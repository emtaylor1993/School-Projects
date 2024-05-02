#include <stdio.h>
#include "histgen.h"
#include "adtutil.h"

int main(void) {
	histgen_type *hist;
	int bins[] = {1, 2, 3, 4};
	int num_bins = 4;
	int w = 4;
	int h = 1;
	int stride = 8;
	int retVal;

	printf("\nTesting the \"histgen_get_width\" function...\n");

	hist = histgen_new(bins, num_bins, w, h, stride);
	
	DLC_VMETHOD_CALL_X(histgen, set_width, hist, 3);
	retVal = DLC_VMETHOD_CALL(histgen, get_width, hist);

	printf("Method call complete...\n");

	if (retVal == 3) {
		printf("\nThe value returned was: %d\n", retVal);
		printf("Test 01: Get Width passed!\n");
	} else {
		printf("\nThe value returned was: %d\n", retVal);
		printf("Test 01: Get_Width failed.\n");
	}

	printf("\n");
	
	return 0;
}


