#include <stdio.h>
#include "histgen.h"
#include "adtutil.h"

int main(void) {
	histgen_type *hist;
	int bins[] = {1, 2, 3, 4};
	int num_bins = 2;
	int w = 4;
	int h = 1;
	int stride = 4;
	int input[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
	int output[] = {0};
	
	printf("\nTesting the \"histgen_compute\" method...\n");
	
	hist = histgen_new(bins, num_bins, w, h, stride);

	DLC_VMETHOD_CALL_X(histgen, compute, hist, input, output);
	printf("\nTest Compute Passed!\n");
	printf("\n");

	return 0;
}
