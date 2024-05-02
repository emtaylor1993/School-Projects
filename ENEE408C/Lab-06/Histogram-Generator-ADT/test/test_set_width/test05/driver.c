#include <stdio.h>
#include "histgen.h"
#include "adtutil.h"

int main(void) {
	histgen_type *hist;
	int bins[] = {1, 2, 3, 4, 5, 6};
	int num_bins = 3;
	int w = 1;
	int h = 1;
	int stride = 4;
	int retVal = 0;

	printf("\nTesting the \"histgen_set_width\" function...\n");

	hist = histgen_new((int *)bins, num_bins, w, h, stride);	

	printf("Value of width before calling: %d.\n", retVal);

	w = 5;
		
	DLC_VMETHOD_CALL_X(histgen, set_width, hist, w);
	retVal = DLC_VMETHOD_CALL(histgen, get_width, hist);
	printf("Method call complete...\n");
	printf("Value of width after calling: %d.\n", retVal);
	
	if (retVal == 4) {
		printf("Test 05: Set Width passed!\n");
	} else {
		printf("Test 05: Set Width failed.\n");
	}

	printf("\n");

	return 0;
}
