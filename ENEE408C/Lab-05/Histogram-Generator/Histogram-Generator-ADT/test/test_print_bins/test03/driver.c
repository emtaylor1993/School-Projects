#include <stdio.h>
#include "histgen.h"
#include "adtutil.h"

int main(void) {
	histgen_type *hist;
	int bins[] = {1, 2, 3, 4, 5, 6, 7, 8};
	int num_bins = 4;
	int w = 1;
	int h = 1;
	int stride = 1;

	printf("\nPreparing to print bins...\n\n");

	hist = histgen_new(bins, num_bins, w, h, stride);

	printf("Array of bins:\n");
	DLC_VMETHOD_CALL(histgen, print_bins, hist);

	printf("\nPrint complete.\n\n");

	return 0;
} 
