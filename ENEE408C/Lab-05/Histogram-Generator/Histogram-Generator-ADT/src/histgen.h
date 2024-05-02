#ifndef histgen_h
#define histgen_h

/*****************************************************************************
This is the interface for a histogram generator ADT, which is derived
from the array list ADT.
*****************************************************************************/

/*****************************************************************************
ADT type definitions.
*****************************************************************************/

struct histgen_class_struct;
typedef struct histgen_class_struct histgen_class_type;

struct histgen_struct;
typedef struct histgen_struct histgen_type;

/*****************************************************************************
Type definitions for public methods that are introduced in this class.
*****************************************************************************/
typedef void (*histgen_set_bins_ftype)(histgen_type *histgen, int *bins, int num_bins);
typedef int (*histgen_validate_bins_ftype)(histgen_type *histgen, int min, int max);
typedef void (*histgen_print_bins_ftype)(histgen_type *histgen);
typedef void (*histgen_compute_ftype)(histgen_type *histgen, int *input, int *output);
typedef void (*histgen_free_ftype)(histgen_type *histgen);

/*****************************************************************************
Structure definition for the class structure for this ADT.
*****************************************************************************/

struct histgen_class_struct {
	/* Methods */
	#include "histgen_methods.h" 
};

/*****************************************************************************
Partial structure definition for an instance of this ADT.
This part of the structure is declared here so that the client can have
access to the methods through the class field.
*****************************************************************************/

struct _histgen_start {
	/* Pointer to class methods. */
	histgen_class_type *class;

#include "histgen_fields.h"
};
typedef struct _histgen_start histgen_start_type;

/*****************************************************************************
ADT Constructors.
*****************************************************************************/
histgen_type *histgen_new(int *bins, int num_bins, int w, int h, int stride);

#endif


