#ifndef _array_list_h
#define _array_list_h

/*******************************************************************************
@ddblock_begin copyright

Copyright (c) 1997-2015
Maryland DSPCAD Research Group, The University of Maryland at College Park 

Permission is hereby granted, without written agreement and without
license or royalty fees, to use, copy, modify, and distribute this
software and its documentation for any purpose, provided that the above
copyright notice and the following two paragraphs appear in all copies
of this software.

IN NO EVENT SHALL THE UNIVERSITY OF MARYLAND BE LIABLE TO ANY PARTY
FOR DIRECT, INDIRECT, SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES
ARISING OUT OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF
THE UNIVERSITY OF MARYLAND HAS BEEN ADVISED OF THE POSSIBILITY OF
SUCH DAMAGE.

THE UNIVERSITY OF MARYLAND SPECIFICALLY DISCLAIMS ANY WARRANTIES,
INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE SOFTWARE
PROVIDED HEREUNDER IS ON AN "AS IS" BASIS, AND THE UNIVERSITY OF
MARYLAND HAS NO OBLIGATION TO PROVIDE MAINTENANCE, SUPPORT, UPDATES,
ENHANCEMENTS, OR MODIFICATIONS.

@ddblock_end copyright
*******************************************************************************/

#include "list.h"

/*******************************************************************************
This is the interface for an array list ADT, which is derived
from the list ADT.
*******************************************************************************/

/*******************************************************************************
ADT type definitions.
*******************************************************************************/

struct array_list_class_struct;
typedef struct array_list_class_struct array_list_class_type;

struct array_list_struct;
typedef struct array_list_struct array_list_type;

/*******************************************************************************
Type definitions for new public methods that are introduced
by this derived class (i.e., that are not inherited from
base class methods). These are type definitions for
specific kinds of function pointer types.
The format is:

typedef <return_type> (*<function_name>)(arg types);
*******************************************************************************/

/*******************************************************************************
Deallocate the storage associated with the given array list.
Results are unpredictable if the specified "list" argument does not
point to a "live" (allocated but not yet freed) array list.
*******************************************************************************/
typedef void (*array_list_free_ftype)(array_list_type *list);

/*******************************************************************************
Structure definition for the class structure for this ADT.
*******************************************************************************/

struct array_list_class_struct {
/* Methods */
#include "array_list_methods.h"
};

/*******************************************************************************
Partial structure definition for an instance of this ADT.
This part of the structure is declared here so that the client can have 
access to the methods through the class field.
*******************************************************************************/

struct _array_list_start {
    /* Pointer to class structure */
    array_list_class_type *class;
};
typedef struct _array_list_start array_list_start_type;

/*******************************************************************************
ADT Constructors. 
*******************************************************************************/

/*******************************************************************************
Allocate a new array list and initialize it to be empty.  Return NULL if there
is not enough memory available to satisfy the allocation request. This is a
simple version of the constructor with no arguments. The list and element
descriptors are each set to "no-desc", which represents "no descriptor
available".
*******************************************************************************/
array_list_type *array_list_new(void);

/*******************************************************************************
Allocate a new array list and initialize it to be empty.  Return NULL if there
is not enough memory available to satisfy the allocation request. Use the given
strings to set the list and element descriptors.
*******************************************************************************/
array_list_type *array_list_new_desc(char *list_descriptor, 
        char *elem_descriptor);

#endif
