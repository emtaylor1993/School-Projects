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
	int max_bin_count = 10;

	printf("\nTesting the \"histgen_get_max_bin_count\" function...\n");

	hist = histgen_new(bins, num_bins, w, h, stride);
	DLC_VMETHOD_CALL_X(histgen, set_max_bin_count, hist, max_bin_count);
	DLC_VMETHOD_CALL_X(histgen, set_max_bin_count, hist, 11);
	retVal = DLC_VMETHOD_CALL(histgen, get_max_bin_count, hist);

	if (retVal == 11) {
		printf("Test 04: Get Max Bin Count passed!\n");
	} else {
		printf("Test 04: Get Max Bin Count failed.\n");
	}
	
	printf("\n");
	
	return 0;
}


