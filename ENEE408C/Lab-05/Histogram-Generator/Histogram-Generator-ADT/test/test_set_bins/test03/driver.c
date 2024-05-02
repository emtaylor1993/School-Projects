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
	int initial_bins[] = {1, 1, 1, 1};
	int retVal;
	int bins[] = {0, 1, 3, 4};
	int num_bins = 2;
	int w = 1;
	int h = 1;
	int stride = 1;
	int max = 4;
	int min = 0;

	printf("\nPreparing to set bins...\n");
	
	hist = histgen_new(initial_bins, 2, w, h, stride);

	printf("Array of bins before calling set_bins:\n");
	DLC_VMETHOD_CALL(histgen, print_bins, hist);
	DLC_VMETHOD_CALL_X(histgen, set_bins, hist, bins, num_bins);
	printf("\nArray of bins after calling set_bins:\n");
	DLC_VMETHOD_CALL(histgen, print_bins, hist);
	retVal = DLC_VMETHOD_CALL_X(histgen, validate_bins, hist, min, max);

	printf("\nSet complete.\n");

	if (retVal == 1) {
		printf("Test 03: Set Bins passed!\n\n");
	} else {
		printf("Test 03: Set Bins passed, but validate fails.\n\n");
	}

	return 0;
}
