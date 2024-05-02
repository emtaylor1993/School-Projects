#include <stdio.h>
#include <stdlib.h>
#include "histgen.h"

/****************************************************************************
Structure definition for this ADT.
****************************************************************************/

struct histgen_struct {
	/* Pointer to class methods. */
	histgen_class_type *class;

/* The class fields for this instance. */
#include "histgen_fields.h"
};

/****************************************************************************
Structure variable that stores the methods in this class. The class field
for instances of this class point to this structure.
****************************************************************************/
histgen_class_type histgen_class;

/****************************************************************************
Prototypes for functions that define or override methods inherited from
the base class.
****************************************************************************/

histgen_type *histgen_new(int *bins, int num_bins, int w, int h, int stride);
void histgen_set_bins(histgen_type *histgen, int *bins, int num_bins);
int histgen_validate_bins(histgen_type *histgen, int min, int max);
void histgen_print_bins(histgen_type *histgen);
void histgen_compute(histgen_type *histgen, int *input, int *output);
void histgen_free(histgen_type *histgen);

/****************************************************************************
Constructor.
****************************************************************************/

/* Allocate a new histogram generator, and initialize the generator 
with the given parameters. */
histgen_type *histgen_new(int *bins, int num_bins, int w, int h, int stride) {
	histgen_type *p = NULL;
	
	p = (histgen_type *)malloc(sizeof(histgen_type));
	if (p == NULL) {
		return NULL;
	}

	p->class = &histgen_class;

	p->bins = bins;
	p->num_bins = num_bins;
	p->w = w;
	p->h = h;
	p->stride = stride;
	
	/* Setting up the methods. */
	p->class->set_bins = (histgen_set_bins_ftype)histgen_set_bins;
	p->class->validate_bins = (histgen_validate_bins_ftype)histgen_validate_bins;
	p->class->print_bins = (histgen_print_bins_ftype)histgen_print_bins;
	p->class->compute = (histgen_compute_ftype)histgen_compute;
	p->class->free = (histgen_free_ftype)histgen_free;	

	return p;
}

/****************************************************************************
Public methods.
****************************************************************************/

/* Set the bins of the given histogram generator. */
void histgen_set_bins(histgen_type *histgen, int *bins, int num_bins) {
	histgen->bins = bins;
	histgen->num_bins = num_bins;
}

/* Return true (nonzero) if the bins are non-overlapping and cover
the whole range of values from min to max (inclusive) without any gaps. */
int histgen_validate_bins(histgen_type *histgen, int min, int max) {
	int index;
	int n = histgen->num_bins * 2;

	/* Checking if the first element of the bins list is the min. */
	if (histgen->bins[0] != min) {
		fprintf(stderr, "The first element of the bins list is not the min.\n");
		return 0;
	}
	
	/* Checking if the final element of the bins list is the max. */
	if (histgen->bins[n - 1] != max) {
		fprintf(stderr, "The final element of the bins list is not the max.\n");
		return 0;
	}

	/* Checking if the bins list is sorted in the first place. */
	for (index = 0; index < n - 1; index++) {
		if (histgen->bins[index] > histgen->bins[index + 1]) {
			fprintf(stderr, "The list of bins is not sorted from least to greatest.\n");
			return 0;
		}
	}
	
	/* Checking for gaps in the list of bins. */
	for (index = 2; index < n - 1; index+=2) {
		if (histgen->bins[index] != histgen->bins[(index - 1)] + 1) {
			fprintf(stderr, "There is a gap somewhere in the list of bins.\n");
			return 0;
		}
	}

	return 1;
}

/* Print the array of bins associated with the given histogram generator. 
The results will be displayed by showing which bin we are in and how many
observations that are in each bin. */
void histgen_print_bins(histgen_type *histgen) {
	int index;
	int n = histgen->num_bins;

	/* Print the results of the bins. */
	for (index = 0; index < n; index++) {
		printf("[%d - %d]\n", histgen->bins[2 * index], histgen->bins[2 * index + 1]);
	}
}

/* Compute the histogram for the given observations (input), and 
produce the result in the given result array (output). It is the 
client's responsibility to allocate and free storage as appropriate
for the observations (input) and result (output) arrays. */
void histgen_compute(histgen_type *histgen, int *input, int *output) {
	int out_length = histgen->w * histgen->h;
	int n = histgen->num_bins;
	int index;
	int bin_index;
	
	for (bin_index = 0; bin_index < n; bin_index++) {
		for (index = 0; index < out_length; index++) {
			if (input[index] >= histgen->bins[2 * bin_index] && input[index] <= histgen->bins[2 * bin_index + 1]) {
				output[bin_index]++;
			} else {
				output[bin_index] += 0;
			}
		}
		printf("Bin %d: %d\n", bin_index + 1, output[bin_index]);
	}
}

/* Release the memory allocated for the given histogram generator.
Memory associated with the "bins" array is not released here. Memory
management for the "bins" array is the client's responsibility. */
void histgen_free(histgen_type *histgen) {
	free(histgen);
}
