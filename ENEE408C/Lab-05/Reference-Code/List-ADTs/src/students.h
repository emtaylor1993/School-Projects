#ifndef _students_h
#define _students_h

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

#include "array_list.h"    

/* Structure for a student record. */
typedef struct student {
    char lastName[16];
    int id;
    float gpa;
    char major[5];
} student;

/* Return a record for a student that is initialized based on the given
student data. */
student newStudent(char *lastName, int id, float gpa, char *major);

/* Display the set of student records in the given list. */
void printStudents(array_list_type *students);

/* Allocate storage for and insert a new student into the given list. */
void createStudent(array_list_type *students, char *name, int id, float gpa,
        char *major); 

#endif
