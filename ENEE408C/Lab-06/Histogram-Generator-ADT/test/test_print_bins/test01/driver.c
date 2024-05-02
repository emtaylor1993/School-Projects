#include <stdio.h>
#include "histgen.h"
#include "adtutil.h"

int main(void) {
	histgen_type *hist;
	int bins[] = {1, 2, 3, 4, 5, 6, 7, 8};
	int num_bins = 4;
	int w = 2;
	int h = 2;
	int stride = 4;

	printf("\nTesting the \"histgen_print_bins\" function...\n");

	printf("\nBins to be printed: {1, 2, 3, 4, 5, 6, 7, 8}\n");

	hist = histgen_new(bins, num_bins, w, h, stride);
	
	DLC_VMETHOD_CALL(histgen, print_bins, hist);

	printf("\nMethod call complete...\n");

	printf("\nPrint Bins passed.\n\n");

	return 0;
}
