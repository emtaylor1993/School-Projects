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
#include <stdlib.h> 

#include "array_list.h"
#include "adtutil.h"
#include "../../../util/testutils.c"

#define A_LARGE_NUMBER 10000

int main(void) {

    array_list_type *list;
    int length = 0;
    int* buffer = NULL; 
    long i = 0; 
    long error_count = 0; 
    int number = 0; 
    int *numberp = NULL;

    buffer = (int *) malloc(sizeof(int) * A_LARGE_NUMBER); 
    if (buffer == NULL) {
        fprintf(stderr, "Test: not enough memory.\n"); 
        exit(1); 
    }

    for(i = 0; i < A_LARGE_NUMBER; i++) {
        buffer[i] = i; 
    } 

    list = array_list_new();
    length = DLC_VMETHOD_CALL(list, length, list);
    printf("length before: %d\n", length);
    for(i = 0; i < A_LARGE_NUMBER; i++) {
        DLC_VMETHOD_CALL_X(list, insert, list, &(buffer[i]));
    }
    length = DLC_VMETHOD_CALL(list, length, list);
    printf("length after: %d\n", length);

    for(i = 0; i < A_LARGE_NUMBER; i++){
        numberp = (int *)DLC_VMETHOD_CALL_X(list, get, list, i);
        number = *numberp;
        if(number != A_LARGE_NUMBER - 1 - buffer[i]) {
            error_count++; 
        }
    }
    printf("Count of inconsistent list elements: %ld\n", error_count); 
    
    free(buffer);
 
    return 0;
}
