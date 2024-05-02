#include <stdio.h>
#include <string.h>
#include "histgen.h"
#include "adtutil.h"

int main(void) {
	histgen_type *hist;
	int bins[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	int num_bins = 5;
	int w = 1;
	int h = 1;
	int stride = 2;

	printf("\nTesting the \"histgen_set_bins\" function...\n");
	printf("\nBins to be set: {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}\n");

	hist = histgen_new(bins, num_bins, w, h, stride);
	
	DLC_VMETHOD_CALL_X(histgen, set_bins, hist, bins, num_bins);
	printf("\nMethod call complete...\n");
	printf("\nPrinting the bins...\n");	
	DLC_VMETHOD_CALL(histgen, print_bins, hist);

	printf("\n");

	return 0;
}
