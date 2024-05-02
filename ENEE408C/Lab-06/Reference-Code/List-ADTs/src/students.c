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

#include <string.h>
#include <stdio.h>
#include <stdlib.h>

#include "adtutil.h"
#include "array_list.h"    
#include "students.h"    

student newStudent(char *lastName, int id, float gpa, char *major) {
    student temp;

    strcpy(temp.lastName, lastName);  /* safer to use strncpy */
    temp.id = id;
    temp.gpa = gpa;
    strcpy(temp.major, major);  /* safer to use strncpy */
    return temp;
}

void printStudents(array_list_type *students) {
  student *s = NULL;
  int i = 0;
  int length = 0;

  length = DLC_VMETHOD_CALL(list, length, students);

  for (i = 0; i < length; i++) {
      s = DLC_VMETHOD_CALL_X(list, get, students, i); 
      printf("%s %d %s %f\n", s->lastName, s->id, s->major, s->gpa);
  }
}

void createStudent(array_list_type *students, char *name, int id, float gpa,
        char *major) {

    student *temp = malloc(sizeof(student));
    *temp = newStudent(name, id, gpa, major);
    DLC_VMETHOD_CALL_X(list, insert, students, temp); 
} /* createStudent */ 


