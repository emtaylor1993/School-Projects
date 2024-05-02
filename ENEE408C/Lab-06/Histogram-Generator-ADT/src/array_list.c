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


#include <stdio.h>
#include <stdlib.h>
#include "array_list.h"

/***************************************************************************** 
This is a concrete list that uses an array to hold the list elements.
This implementation offers fast indexed lookup into a list, at the expense
of slower insertion into the list.
*****************************************************************************/ 

/******************************************************************************
Structure definition for this ADT. 
*******************************************************************************/

struct array_list_struct {
    /* Pointer to class methods. */
    array_list_class_type *class;

/* The class fields for this instance */
#include "array_list_fields.h"    
};

/*******************************************************************************
Structure variable that stores the methods in this class. The class field
for instances of this class point to this structure.
*******************************************************************************/
array_list_class_type array_list_class;

/*******************************************************************************
Prototypes for private static functions.
*******************************************************************************/

static void _extend(array_list_type *list);

/*******************************************************************************
Prototypes for functions that define or override methods inherited from
the base class.
*******************************************************************************/
void *array_list_get(array_list_type *list, int index);
void array_list_insert(array_list_type *list, void *data);
int array_list_length(array_list_type *list);

/*******************************************************************************
Prototypes for methods that are introduced in this derived class.
*******************************************************************************/
void array_list_free(array_list_type *list);

/*******************************************************************************
Constructors
*******************************************************************************/

array_list_type *array_list_new_desc(char *list_descriptor, 
    char *elem_descriptor) {
    array_list_type *p = NULL;

    p = array_list_new();

    p->list_descriptor = list_descriptor;
    p->element_descriptor = elem_descriptor;
    return p;
}

array_list_type *array_list_new(void) {
    array_list_type *p = NULL;

    p = (array_list_type *)malloc(sizeof(array_list_type));
    if (p == NULL) {
        return NULL;
    }

    p->class = &array_list_class;
    
    p->list_descriptor = "no-desc";
    p->element_descriptor = "no-desc";

    p->length = 0;
    p->elements = NULL;

    /* Set up overridden virtual methods that are inherited from the base class
    */
    p->class->get = (list_get_ftype)array_list_get;
    p->class->insert = (list_insert_ftype)array_list_insert;
    p->class->length = (list_length_ftype)array_list_length;

    /* Utilize methods defined by the base class to display descriptors. */
    p->class->show_list_desc = list_show_list_desc;
    p->class->show_elem_desc = list_show_elem_desc;

    p->class->free = (array_list_free_ftype)array_list_free;

    return p;
}

void array_list_free(array_list_type *list) {
    void **elements = NULL;
    
    elements = list->elements;
    if (elements != NULL) {
        free(elements);
    } 
    free(list);    
}

/*******************************************************************************
Public methods.
*******************************************************************************/

void *array_list_get(array_list_type *list, int index) {
    if ((index < 0) || (index >= list->length)) {
        return NULL;  
    }
    return list->elements[index];
}

void array_list_insert(array_list_type *list, void *data) {
    int i;

    _extend(list);
    for (i = list->length - 1; i >= 0; i--) {
        list->elements[i + 1] = list->elements[i];
    }
    list->elements[0] = data;
    (list->length)++;
}

int array_list_length(array_list_type *list) {
    return list->length;
}

/*******************************************************************************
Private static functions.
*******************************************************************************/

/* Extends the array for a given
   list so that it can hold one more element. The length of the list is not
   changed by this function.
*/
static void _extend(array_list_type *list) {
    if (list->elements == NULL) {
        list->elements = malloc(sizeof(void*));
    } else {
        list->elements = realloc(list->elements, 
                sizeof(void*) * (list->length + 1));
    }
    if (list->elements == NULL) {
        fprintf(stderr, "array_list: out of memory\n");
        exit(1); 
    }
}
