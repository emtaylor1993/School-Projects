#include <stdio.h>
#include "histgen.h"
#include "adtutil.h"

int main(void) {
	histgen_type *hist;
	int bins[] = {1, 2, 3, 4};
	int num_bins = 2;
	int w = 6;
	int h = 1;
	int stride = 1;
	int input[] = {1, 1, 3, 5, 5, 6};
	int output[] = {0, 0}; /* Initialize with number of 0's = to num_bins. */

	printf("\nPreparing to compute...\n\n");

	hist = histgen_new(bins, num_bins, w, h, stride);

	printf("Array of bins:\n");
	DLC_VMETHOD_CALL(histgen, print_bins, hist);

	printf("\nComputing:\n");
	DLC_VMETHOD_CALL_X(histgen, compute, hist, input, output);

	printf("\nCompute complete.\n\n");

	return 0;
}
