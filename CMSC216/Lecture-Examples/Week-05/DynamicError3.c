/* 
 * Run the program with the values 10 through 14
 * and check the output.  What is causing the error?
 *
 */
#include <stdio.h>
#include <stdlib.h>
#define SIZE 5

int main() {
    int *p1 = calloc(SIZE, sizeof(int));
    int *begin = p1; /* Storing beginning of memory area */
    int target, i;

    for (i = 0; i < SIZE; i++, p1++) { /* Initializing array */
        *p1 = 10 + i;
    }

    p1 = begin; /* p1 is back pointing to the beginning */
    printf("Input value to find: ");
    scanf("%d", &target);
    for (i = 0; i < SIZE; i++) { /* looking for a value */
        printf("%d ", begin[i]);
        if (begin[i] == target) {
            p1 = &begin[i]; /* found value, storing reference to it */
        }
    }
    printf(": Value referred to by p1 %d\n", *p1);
    free(p1); /* Should we be doing free(p1) or free(begin)? */

    return 0;
}