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
	int max_bin_count = -3;
	
	printf("\nTesting the \"histgen_get_max_bin_count\" function...\n");

	hist = histgen_new(bins, num_bins, w, h, stride);
	
	DLC_VMETHOD_CALL_X(histgen, set_max_bin_count, hist, max_bin_count);
	retVal = DLC_VMETHOD_CALL(histgen, get_max_bin_count, hist);

	printf("Method call complete...\n");

	if (retVal == 3) {
		printf("\nThe value returned was: %d\n", retVal);
		printf("Test 02: Get Max Bin Count passed!\n");
	} else {
		printf("\nThe value returned was: %d\n", retVal);
		printf("Test 02: Get_Max Bin Count failed.\n");
	}

	printf("\n");
	
	return 0;
}


