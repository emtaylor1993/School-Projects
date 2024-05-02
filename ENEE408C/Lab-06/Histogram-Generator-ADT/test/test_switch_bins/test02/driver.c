#include <stdio.h>
#include "histgen.h"
#include "adtutil.h"

int main(void) {
	histgen_type *hist;
	int first_bins[] = {1, 2, 3, 4};
	int num_bins = 2;
	int w = 2;
	int h = 1;
	int stride = 4;
	int retVal = 0;

	printf("\nTesting the \"histgen_switch_bins\" function...\n");

	hist = histgen_new(first_bins, num_bins, w, h, stride);
	retVal = DLC_VMETHOD_CALL(histgen, switch_bins, hist);

	printf("\nMethod call complete...\n");

	if (retVal == 0) {
		printf("\nSwitch Bins passed.\n");
	} else {
		printf("\nSwitch Bins failed.\n");
	}

	printf("\n");

	return 0;
}
