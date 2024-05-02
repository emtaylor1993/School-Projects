#include <stdio.h>
#include "histgen.h"
#include "adtutil.h"
#include "../../util/hist_util.c"

int main(void) {
	histgen_type *hist;
	int bins[] = {1, 2, 3, 9};
	int num_bins = 2;
	int w = 4;
	int h = 1;
	int stride = 4;
	int input[] = {1, 2, 5, 6, 3, 4, 7, 8, 9, 10, 11, 12};
	int output[] = {0};
	
	printf("\nTesting the \"histgen_util_print\" method...\n");
	
	hist = histgen_new(bins, num_bins, w, h, stride);

	DLC_VMETHOD_CALL_X(histgen, compute, hist, input, output);
	hist_util_print_histogram(output, bins, num_bins);
	
	printf("\nTest Hist Util Print Histogram Passed!\n\n");
	
	return 0;
}
