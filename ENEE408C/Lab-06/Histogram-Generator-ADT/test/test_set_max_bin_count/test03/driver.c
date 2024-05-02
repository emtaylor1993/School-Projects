#include <stdio.h>
#include "histgen.h"
#include "adtutil.h"

int main(void) {
	histgen_type *hist;
	int bins[] = {1, 2, 3, 4};
	int num_bins = 2;
	int w = 1;
	int h = 2;
	int stride = 4;
	int retVal = 0;
	int max_bin_count = -7;

	printf("\nTesting the \"histgen_set_max_bin_count\" function...\n");

	hist = histgen_new(bins, num_bins, w, h, stride);	

	printf("Value of max bin count before calling: %d.\n", retVal);	
	DLC_VMETHOD_CALL_X(histgen, set_max_bin_count, hist, max_bin_count);
	retVal = DLC_VMETHOD_CALL(histgen, get_max_bin_count, hist);
	printf("Method call complete...\n");
	printf("Value of max bin count after calling: %d.\n", retVal);
	
	if (retVal == 7) {
		printf("Test 03: Set Max Bin Count passed!\n");
	} else {
		printf("Test 03: Set Max Bin Count failed.\n");
	}

	printf("\n");

	return 0;
}
