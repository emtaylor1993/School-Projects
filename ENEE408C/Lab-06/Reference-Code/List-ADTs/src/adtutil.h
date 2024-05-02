#ifndef _adtutil_h
#define _adtutil_h

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
adtutil: Module for utilities pertaining to implementation
of abstract data types (ADTs).
*******************************************************************************/

/*******************************************************************************
Call a virtual method associated with a given base class type (T), object
(instance) I, and method name M. Here T is the base class that contains the
method directly in its ADT structure.

Use of this macro depends on the naming convention that the
"instance start" structure type is called T_start_type, and
the ADT type is called T_type.

As an example, suppose that (1) "listptr" is a pointer to an array list
instance, where the array list class is derived from a base class called
"list"; (2) the method "length" is defined in the base class (list); and (3) we
want to make the following method call:

length = ((list_start_type *)list_ptr)->length((list_type*)list_ptr);

This can be achieved by:

length = DLC_VMETHOD_CALL(list, length, list_ptr);
*******************************************************************************/
#define DLC_VMETHOD_CALL(T, M, I) (((T ## _start_type*)I)->class->M((T ## _type*)I))

/*******************************************************************************
The following macro can be used if the method to be called takes
one or more additional arguments in addition to the instance pointer.
The arguments are the same as those in the cousin method
DLC_VMETHOD_CALL, except that one or more additional arguments
can be added. Note that at least one additional argument needs to
be provided --- i.e., this macro should be called with at least
four arguments, whereas DLC_VMETHOD_CALL should be called with exactly
three arguments.

Use of this macro depends on the naming convention that the
"instance start" structure type is called T_start_type, and
the ADT type is called T_type.

For example, consider the following usage:

e = DLC_VMETHOD_CALL_X(list, get, list_ptr, i);

This is equivalent to

e = ((list_type_start)list_ptr)->get((list_type*)list_ptr, i);

Here, "list" can point to an instance of any class that is derived
from list_type.
*******************************************************************************/
#define DLC_VMETHOD_CALL_X(T, M, I, ...) (((T ## _start_type*)I)->class->M((T ## _type*)I, __VA_ARGS__))

#endif
