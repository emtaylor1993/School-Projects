#include <stdio.h>
#include "histgen.h"
#include "adtutil.h"
#include "hist_util.h"

void hist_util_print_histogram(int *histogram, int *bins, int num_bins);

void hist_util_print_histogram(int *histogram, int *bins, int num_bins) {
	int index;

	/* Print the histogram itself. */
	for (index = 0; index < num_bins; index++) {
		if (index == 0) {
			fprintf(stdout, "[%d - %d]:\t%d\n", bins[2 * index], bins[2 * index + 1], histogram[index]);
		} else {
			fprintf(stdout, "[%d - %d]:\t%d\n", bins[2 * index], bins[2 * index + 1], histogram[index]);
		}
	}
}

int main(void) {
	histgen_type *hist;
	int bins[] = {1, 2, 3, 4};
	int num_bins = 2;
	int w = 4;
	int h = 1;
	int stride = 1;
	int input[] = {1, 1, 1, 1};
	int output[]= {0, 0};

	printf("\nPreparing to print histogram...\n");

	hist = histgen_new(bins, num_bins, w, h, stride);

	printf("\nComputing:\n");
	DLC_VMETHOD_CALL_X(histgen, compute, hist, input, output);

	printf("\nCompute complete.\n\n");
	
	printf("Printing histogram:\n\n");

	hist_util_print_histogram(output, bins, num_bins);
	printf("\n");

	return 0;
}
