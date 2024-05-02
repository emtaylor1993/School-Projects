#ifndef _list_h
#define _list_h

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

/*******************************************************************************
Interface for the list ADT. This is an abstract ADT.
*******************************************************************************/

/*******************************************************************************
ADT type definitions.
*******************************************************************************/

struct list_class_struct;
typedef struct list_class_struct list_class_type;

struct list_struct;
typedef struct list_struct list_type;

/*******************************************************************************
Type definitions for public methods. These type definitions are for
specific kinds of function pointer types.

The format is:

typedef <return_type> (*<method_type_name>)(arg types);

The naming convention for <method_type_name> is:

<adt_name>_<method_name>_ftype
*******************************************************************************/

/* Given an index, return the item in the list at that index. 
   Assume that list items are indexed starting at zero. 
   Return NULL if the index is out of bounds.
*/ 
typedef void* (*list_get_ftype)(list_type *list, int index);

/* Insert a new element at the end of the list. */
typedef void (*list_insert_ftype)(list_type *list, void *data);

/* Return the number of elements in the list. */
typedef int (*list_length_ftype)(list_type *list);

/* Display to standard output the descriptor for this list. */
typedef void (*list_show_list_desc_ftype)(list_type *list);

/* Display to standard output the element descriptor for this list. */
typedef void (*list_show_elem_desc_ftype)(list_type *list);

/*******************************************************************************
Structure definition for the list class structure.
This structure needs to be in the header file so that clients
can access the methods.
*******************************************************************************/

struct list_class_struct {
/* Methods */
#include "list_methods.h"
};

/*******************************************************************************
Partial structure definition for an instance of this ADT.
This part of the structure is declared here so that the client can have 
access to the methods through the class field.
*******************************************************************************/

struct _list_start {
    /* Pointer to class structure */
    list_class_type *class;
};
typedef struct _list_start list_start_type;

/*******************************************************************************
Methods that are implemented in this list and available for use
by derived classes.
*******************************************************************************/

/*******************************************************************************
Display to standard output the descriptor for this list. The descriptor text is
surrounded by "---" on each side in the output display.
*******************************************************************************/
void list_show_list_desc(list_type *list);

/*******************************************************************************
Display to standard output the element descriptor for this list.  The
descriptor text is surrounded by "//" on each side in the output display.
*******************************************************************************/
void list_show_elem_desc(list_type *list);

/*******************************************************************************
Constructor.
*******************************************************************************/

/* The list ADT is an abstract ADT. There is no constructor. */

#endif
