/*******************************************************************************
@ddblock_begin copyright

Copyright (c) 1999-2014
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
#include "adtutil.h"
#include "../../../util/testutils.c"

#define ARRAY_LENGTH 10
int main(void) {

    array_list_type *list;
    int length = 0;
    char* string1 = "This is a string.\n"; 
    int array1[ARRAY_LENGTH] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}; 
    char* string2 = NULL; 
    int* array2 = NULL; 
    int i = 0; 

    list = array_list_new();
    length = DLC_VMETHOD_CALL(list, length, list);
    printf("length before: %d\n", length);
    DLC_VMETHOD_CALL_X(list, insert, list, string1);
    DLC_VMETHOD_CALL_X(list, insert, list, array1);

    length = DLC_VMETHOD_CALL(list, length, list);
    printf("length after: %d\n", length);

    printf("displaying the list ...\n");

    array2 = (int*)DLC_VMETHOD_CALL_X(list, get, list, 0); 

    printf("index %d: ", 0); 
    for (i = 0; i < ARRAY_LENGTH; i++) {
        printf("%d, ", array2[i]); 
    }
    printf("\n"); 

    string2 = (char*)DLC_VMETHOD_CALL_X(list, get, list, 1); 
    printf("Index %d: %s", 1, string2); 
    
    printf("... finished displaying the list. \n");
    
    return 0;
}


