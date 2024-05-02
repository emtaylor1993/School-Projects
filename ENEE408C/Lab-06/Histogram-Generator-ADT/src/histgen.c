#include <stdio.h>
#include <stdlib.h>
#include "histgen.h"
#include "array_list.h"
#include "adtutil.h"

/*****************************************************************************
Structure definition for this ADT.
*****************************************************************************/

struct histgen_struct {
	/* Pointer to class methods. */
	histgen_class_type *class;

/* The class fields for this instance. */
#include "histgen_fields.h"
};

struct histgen_bin_bounds {
	int upper;
	int lower;
};

/*****************************************************************************
Structure variable that stores the methods in this class. The class field
for instance of this class point to this structure.
*****************************************************************************/
histgen_class_type histgen_class;

/*****************************************************************************
Prototypes for functions that define or override methods inherited from
the base class.
*****************************************************************************/

/* These prototypes are from Lab05. */
histgen_type *histgen_new(int *bins, int num_bins, int w, int h, int stride);
void histgen_set_bins(histgen_type *histgen, int *bins, int num_bins);
int histgen_validate_bins(histgen_type *histgen, int min, int max);
void histgen_print_bins(histgen_type *histgen);
void histgen_compute(histgen_type *histgen, int *input, int *output);
void histgen_free(histgen_type *histgen);

/* These prototypes are from Lab06. */
void histgen_set_width(histgen_type *histgen, int w);
int histgen_get_width(histgen_type *histgen);
void histgen_set_height(histgen_type *histgen, int h);
int histgen_get_height(histgen_type *histgen);
void histgen_set_stride(histgen_type *histgen, int stride);
int histgen_get_stride(histgen_type *histgen);
int histgen_switch_bins(histgen_type *histgen);
int histgen_get_max_bin_count(histgen_type *histgen);
void histgen_set_max_bin_count(histgen_type *histgen, int max_bin_count);

/*****************************************************************************
Constructor.
*****************************************************************************/

/* Allocate a new histogram generator, and initialize the generator
with the given parameters. */
histgen_type *histgen_new(int *bins, int num_bins, int w, int h, int stride) {
	int index;
	histgen_type *p = NULL;
	histgen_bin_bounds_type *bounds = NULL;

	p = (histgen_type *)malloc(sizeof(histgen_type));
	if (p == NULL) {
		return NULL;
	}
	
	p->class = &histgen_class;

	p->bin_list = array_list_new();
	for (index = num_bins - 1; index >= 0; index--) {
		bounds = (histgen_bin_bounds_type *)malloc(sizeof(histgen_bin_bounds_type));
		bounds->upper = bins[2 * index + 1];
		bounds->lower = bins[2 * index];
		DLC_VMETHOD_CALL_X(list, insert, p->bin_list, bounds);
	} 
	p->previous_bin_list = NULL;
	p->w = w;
	p->h = h;
	p->max_bin_count = HISTGEN_MAX_BIN_COUNT_DEF;
	p->stride = stride;

	/* Setting up the methods. */
	p->class->set_bins = (histgen_set_bins_ftype)histgen_set_bins;
	p->class->validate_bins = (histgen_validate_bins_ftype)histgen_validate_bins;
	p->class->print_bins = (histgen_print_bins_ftype)histgen_print_bins;
	p->class->compute = (histgen_compute_ftype)histgen_compute;
	p->class->free = (histgen_free_ftype)histgen_free;
	p->class->set_width = (histgen_set_width_ftype)histgen_set_width;
	p->class->get_width = (histgen_get_width_ftype)histgen_get_width;
	p->class->set_height = (histgen_set_height_ftype)histgen_set_height;
	p->class->get_height = (histgen_get_height_ftype)histgen_get_height;
	p->class->set_stride = (histgen_set_stride_ftype)histgen_set_stride;
	p->class->get_stride = (histgen_get_stride_ftype)histgen_get_stride;
	p->class->switch_bins = (histgen_switch_bins_ftype)histgen_switch_bins;
	p->class->get_max_bin_count = (histgen_get_max_bin_count_ftype)histgen_get_max_bin_count;
	p->class->set_max_bin_count = (histgen_set_max_bin_count_ftype)histgen_set_max_bin_count;

	return p;
}

/******************************************************************************
Public methods.
******************************************************************************/

/* Set the bins of the given histogram generator. */
void histgen_set_bins(histgen_type *histgen, int *bins, int num_bins) {
	int index;
	histgen_bin_bounds_type *bounds = NULL;

	if (histgen->previous_bin_list != NULL) {
		DLC_VMETHOD_CALL(array_list, free, histgen->previous_bin_list);
	}	

	histgen->previous_bin_list = histgen->bin_list;
	histgen->bin_list = array_list_new();
	
	for (index = num_bins - 1; index >= 0; index--) {
		bounds = (histgen_bin_bounds_type *)malloc(sizeof(histgen_bin_bounds_type));
		bounds->upper = bins[2 * index + 1];
		bounds->lower = bins[2 * index];
		DLC_VMETHOD_CALL_X(list, insert, histgen->bin_list, bounds);
	}
}

/* Return true (nonzero) if the bins are non-overlapping and cover
the whole range of values from min to max (inclusive) without any gaps. */
int histgen_validate_bins(histgen_type *histgen, int min, int max) {
	int length = DLC_VMETHOD_CALL(list, length, histgen->bin_list);
	histgen_bin_bounds_type *lower_bound = (int *)DLC_VMETHOD_CALL_X(list, get, histgen->bin_list, 0);
	histgen_bin_bounds_type *upper_bound = (int *)DLC_VMETHOD_CALL_X(list, get, histgen->bin_list, length - 1);	
	histgen_bin_bounds_type *temp1 = NULL;
	histgen_bin_bounds_type *temp2 = NULL;
	int index = 0;

	/* Checking if the max_bin_count exceeds 16. */	
	if (histgen->max_bin_count > HISTGEN_MAX_BIN_COUNT_DEF) {
		fprintf(stderr, "The maximum bin count cannot exceed %d.\n", HISTGEN_MAX_BIN_COUNT_DEF);
		return 0;
	}

	/* Checking if the first element of the bins list is actually the minimum. */
	if (lower_bound->lower != min) {
		fprintf(stderr, "The first element of the bins list is not the min.\n");
		return 0;
	}

	/* Checking if the final element of the bins list is actually the maximum. */
	if (upper_bound->upper != max) {
		fprintf(stderr, "The final element of the bins list is not the max.\n");
		return 0;
	}

	/* Loop through the bounds structure and make sure it is sorted in order. */
	for (index = 0; index < length; index++) {
		temp1 = (int *)DLC_VMETHOD_CALL_X(list, get, histgen->bin_list, index);
		if (temp1->lower >= temp1->upper)	{
			fprintf(stderr, "The list of bins is not sorted from least to greatest.\n");
			return 0;
		}
	}
	
	/* Loop through the bounds structure and make sure there are no gaps. */
	for (index = 1; index < length; index++) {
		temp1 = (int *)DLC_VMETHOD_CALL_X(list, get, histgen->bin_list, index - 1);
		temp2 = (int *)DLC_VMETHOD_CALL_X(list, get, histgen->bin_list, index);
		if (temp2->lower != temp1->upper + 1) {
			fprintf(stderr, "There is a gap somewhere in the bins list.\n");
			return 0;
		}
	}
	
	return 1;
}

/* Print the array of bins associated with the given histogram generator.
The results will be displayed by showing which bin we are in and how many
observations that are in each bin. */
void histgen_print_bins(histgen_type *histgen) {
	int length = DLC_VMETHOD_CALL(list, length, histgen->bin_list);
	int index = 0;
	histgen_bin_bounds_type *temp = NULL;

	/* Loop through the bounds structure and print each instance. */
	for (index = 0; index < length; index++) {
		temp = (int *)DLC_VMETHOD_CALL_X(list, get, histgen->bin_list, index);
		printf("[%d - %d]\n", temp->lower, temp->upper);
	}
}

/* Compute the histogram for the given observations (input), and
produce the result in the given result array (output). It is the
client's responsibility to allocate and free storage as appropriate
for the observations (input) and the result (output) arrays. */
void histgen_compute(histgen_type *histgen, int *input, int *output) {
	int w = histgen->w;
	int h = histgen->h;
	int stride = histgen->stride;
	int length = DLC_VMETHOD_CALL(list, length, histgen->bin_list);
	int *tile;
	int index1 = 0;
	int index2 = 0;
	int tile_index = 0;
	int bin_index = 0;
	histgen_bin_bounds_type *temp = NULL;

	tile = malloc((w * h) * sizeof(int));

	/* Fill the tile up with the input values. */
	for (index1 = 0; index1 < h; index1++) {
		for (index2 = 0; index2 < w; index2++) {
			tile[tile_index] = input[(index1 * stride) + index2];
			tile_index++;
		}
	}

	/* Check each element of the tile against the upper and lower bounds. */
	for (bin_index = 0; bin_index < length; bin_index++) {
		temp = (int *)DLC_VMETHOD_CALL_X(list, get, histgen->bin_list, bin_index);
		for (tile_index = 0; tile_index < w * h; tile_index++) {
			if (tile[tile_index] >= temp->lower && tile[tile_index] <= temp->upper) {
				output[bin_index]++;
			}
		}	
	}
}

/* Release the memory allocated for the given histogram generator.
Memory associated with the "bins" array is not released here. Memory
management for the "bins" array is the client's responsibility. */
void histgen_free(histgen_type *histgen) {
	if (histgen->previous_bin_list != NULL) {
		DLC_VMETHOD_CALL(array_list, free, histgen->previous_bin_list);
	}
	DLC_VMETHOD_CALL(array_list, free, histgen->bin_list);
	free(histgen);
}

/* Set the width of the given histogram generator. */
void histgen_set_width(histgen_type *histgen, int w) {
	
	/* We cannot have a negative width, therefore, if we are
	given one, we will make it a positive integer. */
	if (w < 0) {
		fprintf(stderr, "Error: Width should be greater than 0.\n");
		w = w * -1;
	}
	
	/* We cannot have a width that is wider than the stride
	of the given histogram. */
	if (w > histgen->stride) {
		fprintf(stderr, "Error: Width should be smaller than stride.\n");
		w = histgen->stride;
	}
	
	histgen->w = w;
}

/* Returns the width of the given histogram generator. */
int histgen_get_width(histgen_type *histgen) {
	
	/* If the histgen_type is NULL, we cannot retrieve a width. */
	if (histgen == NULL) {
		fprintf(stderr, "Error: Our histgen_type is NULL.\n");
		return -1;
	}	

	return histgen->w;
}

/* Set the height of the given histogram generator. */
void histgen_set_height(histgen_type *histgen, int h) {
	
	/* We cannot have a negative height, therefore, if we are
	given one, we will make it a positive integer. */
	if (h < 0) {
		fprintf(stderr, "Error: Height should be greater than 0.\n");
		h = h * -1;
	}

	histgen->h = h;
}

/* Returns the height of the given histogram generator. */
int histgen_get_height(histgen_type *histgen) {
	
	/* If the histgen_type is NULL, we cannot retrieve a height. */
	if (histgen == NULL) {
		fprintf(stderr, "Error: Our histgen_type is NULL.\n");
		return -1;
	}

	return histgen->h;
}

/* Set the stride of the given histogram generator. */
void histgen_set_stride(histgen_type *histgen, int stride) {
	
	/* We cannot have a negative stride, therefore, if we are 
	given one, we will make it a positive integer. */
	if (stride < 0) {
		fprintf(stderr, "Error: Stride should be greater than 0.\n");
		stride = stride * -1;
	}

	/* We cannot have a stride that is smaller than the width
	of the given histogram. */
	if (stride < histgen->w) {
		fprintf(stderr, "Error: Stride should be bigger than width.\n");
		stride = histgen->w;
	}

	histgen->stride = stride;
}

/* Returns the stride of the given histogram generator. */
int histgen_get_stride(histgen_type *histgen) {
	
	/* If the histgen_type is NULL, we cannot retrieve a stride. */
	if (histgen == NULL) {
		fprintf(stderr, "Error: Our histgen_type is NULL.\n");
		return -1;
	}

	return histgen->stride;
}

/* Swaps the current (bin_list) and previous (previous_bin_list) and
return true (1) if the switch was successful and false(0) otherwise. */
int histgen_switch_bins(histgen_type *histgen) {
	
	/* Making copies of the bin_list and previous_bin_list. */
	array_list_type *temp_bin_list = histgen->bin_list;
	array_list_type *temp_previous_bin_list = histgen->previous_bin_list;

	/* Checking if the previous bin list is NULL. If it is, fail, if not, swap. */
	if (histgen->previous_bin_list == NULL) {
		return 0;
	} else {
		histgen->bin_list = temp_previous_bin_list;
		histgen->previous_bin_list = temp_bin_list;	
		return 1;
	}
}

/* Returns the maximum bin count of the given histogram generator. */
int histgen_get_max_bin_count(histgen_type *histgen) {
	return histgen->max_bin_count;
}

/* Sets the maximum bin count of the given histogram generator. */
void histgen_set_max_bin_count(histgen_type *histgen, int max_bin_count) {
	
	/* Checking whether the user entered a negative value for the count. */
	if (max_bin_count < 0) {
		fprintf(stderr, "The bin count must be greater than 0.\n");
		max_bin_count = max_bin_count * -1;
	}

	histgen->max_bin_count = max_bin_count;
}

