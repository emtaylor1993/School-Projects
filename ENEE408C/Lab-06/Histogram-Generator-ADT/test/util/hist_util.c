#include <stdio.h>
#include <stdlib.h>
#include "histgen.h"
#include "hist_util.h"

/* This function will print out a histogram by printing the ranges of the bins
and the number of each observations in each range. */
void hist_util_print_histogram(int *histogram, int *bins, int num_bins) {
	int index = 0;
	
	/* Print the histogram. */
	for (index = 0; index < num_bins; index++) {
		fprintf(stdout, "[%d - %d]:\t\t%d\n", bins[2 * index], bins[2 * index + 1], histogram[index]);
	}
}

