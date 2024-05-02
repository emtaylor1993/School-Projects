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

#include "array_list.h"
#include "students.h"
#include "adtutil.h"

int main(void) {
    array_list_type *studentList = NULL;  
    char *list_descriptor = "Students Database";
    char *element_descriptor = "Student Record";

    /* initialization of empty list */
    studentList = array_list_new_desc(list_descriptor, element_descriptor);

    createStudent(studentList, "Jones", 43891, 3.4, "ENEE");
    createStudent(studentList, "Smith", 56121, 3.7, "ENEE");
    createStudent(studentList, "Roberts", 33419, 3.1, "ENEE");
    createStudent(studentList, "Adams", 87112, 3.5, "ENEE");
    createStudent(studentList, "Thomas", 80102, 3.4, "ENEE");

    /* We are calling a method that is defined in the base class list_type */
    DLC_VMETHOD_CALL(list, show_list_desc, studentList);

    printStudents(studentList);

    return 0;
} 
