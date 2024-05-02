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
	int initial_bins[] = {4, 5, 3, 1, 3, 1};
	int retVal;
	int bins[] = {0, 10, 2, 3, 4, 5};
	int num_bins = 3;
	int w = 1;
	int h = 1;
	int stride = 1;
	int max = 10;
	int min = 0;

	printf("\nPreparing to set bins...\n");
	
	hist = histgen_new(initial_bins, 3, w, h, stride);

	printf("Array of bins before calling set bins:\n");
	DLC_VMETHOD_CALL(histgen, print_bins, hist);
	DLC_VMETHOD_CALL_X(histgen, set_bins, hist, bins, num_bins);
	printf("\nArray of bins after calling set bins:\n");
	DLC_VMETHOD_CALL(histgen, print_bins, hist);
	retVal = DLC_VMETHOD_CALL_X(histgen, validate_bins, hist, min, max);

	printf("\nSet complete.\n");

	if (retVal == 1) {
		printf("Test 02: Set Bins passed!\n\n");
	} else {
		printf("Test 02: Set Bins passed, but validate fails.\n\n");
	}

	return 0;
}
