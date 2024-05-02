#include <stdio.h>
#include "histgen.h"
#include "adtutil.h"

int main(void) {
	histgen_type *hist;
	int bins[] = {1, 2, 3, 4, 5, 6, 7, 8};
	int num_bins = 4;
	int w = 4;
	int h = 1;
	int stride = 8;
	int count = 0;
	int retVal;
	int output[4];
	int correct_output[4] = {1, 2, 3, 4};
	int index;

	printf("\nTesting the \"histgen_get_width\" function...\n");

	hist = histgen_new(bins, num_bins, w, h, stride);

	for (index = 0; index < 4; index++) {
		DLC_VMETHOD_CALL_X(histgen, set_width, hist, index + 1);
		retVal = DLC_VMETHOD_CALL(histgen, get_width, hist);
		output[index] = retVal;
		printf("Method call complete...\n");
	}
	
	for (index = 0; index < 4; index++) {
		if (output[index] == correct_output[index]) {
			printf("Passed iteration %d!\n", index + 1);
			count++;
		} else {
			printf("Failed iteration %d.\n", index + 1);
		}
	}

	if (count == 4) {
		printf("Test 04: Get Width passed!\n");
	} else {
		printf("Test 04: Get Width failed.\n");
		printf("You only passed %d iterations out of 4.\n", count);
	}
	
	printf("\n");
	
	return 0;
}


