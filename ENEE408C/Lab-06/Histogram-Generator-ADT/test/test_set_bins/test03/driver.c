#include <stdio.h>
#include <string.h>
#include "histgen.h"
#include "adtutil.h"

int main(void) {
	histgen_type *hist;
	int bins[] = {1, 2, 3, 4, 5, 10, 11, 15};
	int num_bins = 4;
	int w = 1;
	int h = 1;
	int stride = 2;

	printf("\nTesting the \"histgen_set_bins\" function...\n");
	printf("\nBins to be set: {1, 2, 3, 4, 5 10, 11, 15}\n");

	hist = histgen_new(bins, num_bins, w, h, stride);
	
	DLC_VMETHOD_CALL_X(histgen, set_bins, hist, bins, num_bins);
	printf("\nMethod call complete...\n");
	printf("\nPrinting the bins...\n");	
	DLC_VMETHOD_CALL(histgen, print_bins, hist);

	printf("\n");

	return 0;
}
