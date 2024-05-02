#include <stdio.h>
#include "histgen.h"
#include "adtutil.h"

int main(void) {
	histgen_type *hist;
	int bins[] = {1, 2, 3, 4, 5, 6, 7, 8};
	int num_bins = 4;
	int w = 1;
	int h = 1;
	int stride = 8;
	int count = 0;
	int retVal;
	int output[4];
	int correct_output[4] = {1, 2, 3, 4};
	int index;

	printf("\nTesting the \"histgen_get_stride\" function...\n");

	hist = histgen_new(bins, num_bins, w, h, stride);

	for (index = 1; index < 5; index++) {
		DLC_VMETHOD_CALL_X(histgen, set_stride, hist, index);
		retVal = DLC_VMETHOD_CALL(histgen, get_stride, hist);
		output[index - 1] = retVal;
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
		printf("Test 04: Get Stride passed!\n");
	} else {
		printf("Test 04: Get Stride failed.\n");
		printf("You only passed %d iterations out of 4.\n", count);
	}
	
	printf("\n");
	
	return 0;
}


