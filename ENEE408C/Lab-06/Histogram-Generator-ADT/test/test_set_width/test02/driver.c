#include <stdio.h>
#include "histgen.h"
#include "adtutil.h"

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
Test begins here.
****************************************************************************/

int main(void) {
	histgen_type *hist;
	int bins[] = {1, 2, 3, 4, 5, 6, 7, 8};
	int num_bins = 4;
	int old_w = 2;
	int new_w = -4;
	int h = 1;
	int stride = 8;

	printf("\nTesting the \"histgen_set_width\" function...\n");

	hist = histgen_new(bins, num_bins, old_w, h, stride);	

	printf("Value of width before calling: %d.\n", hist->w);	
	DLC_VMETHOD_CALL_X(histgen, set_width, hist, new_w);
	printf("Method call complete...\n");
	printf("Value of width after calling: %d.\n", hist->w);

	if (hist->w == 4) {
		printf("Test 02: Set Width passed!\n");
	} else {
		printf("Test 02: Set Width failed.\n");
	}

	printf("\n");

	return 0;
}
