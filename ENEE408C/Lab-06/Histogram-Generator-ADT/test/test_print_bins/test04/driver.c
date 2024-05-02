#include <stdio.h>
#include "histgen.h"
#include "adtutil.h"

int main(void) {
	histgen_type *hist;
	int bins[] = {1, 3, 2, 5};
	int num_bins = 2;
	int w = 2;
	int h = 2;
	int stride = 4;
	int min = 1;
	int max = 5;
	int retVal;

	printf("\nTesting the \"histgen_print_bins\" function...\n");

	printf("\nBins to be printed: {1, 3, 2, 5}, min = 1, max = 5\n");

	hist = histgen_new(bins, num_bins, w, h, stride);
	retVal = DLC_VMETHOD_CALL_X(histgen, validate_bins, hist, min, max);
	DLC_VMETHOD_CALL(histgen, print_bins, hist);

	printf("\nMethod call complete...\n");

	printf("\nPrint Bins passed.\n\n");
	
	if (retVal != 1) {
		printf("Validate Bins failed.\n\n");
	} else {
		printf("Validate Bins passed.\n\n");
	}

	return 0;
}
