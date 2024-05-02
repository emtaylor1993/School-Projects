#include <stdio.h>
#include "histgen.h"
#include "adtutil.h"

int main(void) {
	histgen_type *hist;
	int first_bins[] = {1, 2, 3, 4};
	int second_bins[] = {5, 4, 2, 1};
	int num_bins = 2;
	int w = 2;
	int h = 1;
	int stride = 4;
	int retVal = 0;
	int retVal2 = 0;
	int max = 5;
	int min = 1;

	printf("\nTesting the \"histgen_switch_bins\" function...\n");

	hist = histgen_new(first_bins, num_bins, w, h, stride);
	DLC_VMETHOD_CALL_X(histgen, set_bins, hist, first_bins, num_bins);
	DLC_VMETHOD_CALL_X(histgen, set_bins, hist, second_bins, num_bins);
	retVal = DLC_VMETHOD_CALL(histgen, switch_bins, hist);
	retVal2 = DLC_VMETHOD_CALL_X(histgen, validate_bins, hist, min, max);

	printf("\nMethod call complete...\n");

	if (retVal == 1 && retVal2 == 0) {
		printf("\nSwitch Bins passed.\n");
	} else {
		printf("\nSwitch Bins failed.\n");
	}

	printf("\n");

	return 0;
}
