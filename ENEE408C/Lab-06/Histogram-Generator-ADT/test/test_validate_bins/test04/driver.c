#include <stdio.h>
#include "histgen.h"
#include "list.h"
#include "array_list.h"
#include "adtutil.h"

int main(void) {
	histgen_type *hist;
	int bins[] = {0, 2, 3, 4};
	int num_bins = 2;
	int w = 4;
	int h = 1;
	int stride = 8;
	int retVal;
	int min = 1;
	int max = 4;

	printf("\nTesting the \"histgen_validate_bins\" function...\n");

	hist = histgen_new(bins, num_bins, w, h, stride);

	printf("\nBins to be validated: {0, 2, 3, 4}, min: 1, max: 4\n");
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
