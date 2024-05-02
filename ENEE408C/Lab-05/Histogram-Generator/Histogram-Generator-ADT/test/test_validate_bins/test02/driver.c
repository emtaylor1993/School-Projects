#include <stdio.h>

#include "histgen.h"
#include "adtutil.h"

int main(void) {
	histgen_type *hist;
	int retVal;
	int bins[] = {0, 10, 2, 3};
	int num_bins = 2;
	int w = 1;
	int h = 1;
	int stride = 1;

	printf("Validating bins...\n");

	hist = histgen_new(bins, num_bins, w, h, stride);
	retVal = DLC_VMETHOD_CALL_X(histgen, validate_bins, hist, 0, 3);

	printf("Validate complete.\n");
	printf("Value returned: %d\n", retVal);
	
	if (retVal == 1) {
		printf("Test 02: Validation passed!\n");
	} else {
		printf("Test 02: Validation failed.\n");
	}

	return 0;
}
