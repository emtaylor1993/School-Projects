#include <stdio.h>
#include <string.h>
#include "histgen.h"
#include "adtutil.h"

int main(void) {
	histgen_type *hist;
	int bins[] = {0, 2, 3, 4};
	int num_bins = 2;
	int w = 1;
	int h = 1;
	int stride = 2;
	int max = 4;
	int min = 1;
	int retVal;

	printf("\nTesting the \"histgen_set_bins\" function...\n");
	printf("\nBins to be set: {0, 2, 3, 4}\n");

	hist = histgen_new(bins, num_bins, w, h, stride);
	
	DLC_VMETHOD_CALL_X(histgen, set_bins, hist, bins, num_bins);
	printf("\nMethod call complete...\n");
	printf("\nPrinting the bins...\n");	
	DLC_VMETHOD_CALL(histgen, print_bins, hist);
	retVal = DLC_VMETHOD_CALL_X(histgen, validate_bins, hist, min, max);

	if (retVal == 1) {
		printf("\nThese bins are valid.\n");
	} else {
		printf("\nThese bins are not valid.\n");
	}
	
	printf("\n");

	return 0;
}
