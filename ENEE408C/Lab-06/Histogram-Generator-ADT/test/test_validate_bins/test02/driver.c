#include <stdio.h>
#include "histgen.h"
#include "list.h"
#include "array_list.h"
#include "adtutil.h"

int main(void) {
	histgen_type *hist;
	int bins[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
	int num_bins = 8;
	int w = 4;
	int h = 1;
	int stride = 8;
	int retVal;
	int min = 1;
	int max = 16;

	printf("\nTesting the \"histgen_validate_bins\" function...\n");

	hist = histgen_new(bins, num_bins, w, h, stride);

	printf("\nBins to be validated: {1-16}, min: 1, max: 16\n");
	retVal = DLC_VMETHOD_CALL_X(histgen, validate_bins, hist, min, max);
	printf("\nMethod call complete...\n");
	DLC_VMETHOD_CALL(histgen, print_bins, hist);

	if (retVal == 1) {
		printf("\nValidate Bins passed!.\n");
	} else {
		printf("\nValidate Bins failed.\n");
	}
	
	printf("\n");

	return 0;
}
