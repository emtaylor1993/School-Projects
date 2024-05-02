#include <stdio.h>
#include "histgen.h"
#include "adtutil.h"

int main(void) {
	histgen_type *hist;
	int first_bins[] = {1, 2, 3, 4, 5, 6, 7, 8};
	int second_bins[] = {8, 7, 6, 5, 4, 3, 2, 1};
	int num_bins = 2;
	int w = 2;
	int h = 1;
	int stride = 4;
	int retVal = 0;

	printf("\nTesting the \"histgen_switch_bins\" function...\n");

	hist = histgen_new(first_bins, num_bins, w, h, stride);
	DLC_VMETHOD_CALL_X(histgen, set_bins, hist, first_bins, num_bins);
	DLC_VMETHOD_CALL_X(histgen, set_bins, hist, second_bins, num_bins);
	retVal = DLC_VMETHOD_CALL(histgen, switch_bins, hist);
	
	printf("\nMethod call complete...\n");

	if (retVal == 1) {
		printf("\nSwitch Bins passed.\n");
	} else {
		printf("\nSwitch Bins failed.\n");
	}

	printf("\n");

	return 0;
}
