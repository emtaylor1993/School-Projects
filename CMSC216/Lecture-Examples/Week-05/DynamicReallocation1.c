/**
 * Try to provide the following input values:
 * 4,5,100,10000.
 */

#include <stdio.h>
#include <stdlib.h>

#define LENGTH 5

void printArray(int *a, int length) {
    int idx;

    printf("Array Values: ");
    for (idx = 0; idx < length; idx++) {
        printf("%d ", a[idx]);
    } 
    printf("\n");
}

int main() {
    int *originalArray = NULL, *bigger = NULL, idx;
    int newLength;

    /* Creating array and initializing with 10, 11, ... */
    if (!(originalArray = calloc(LENGTH,sizeof(int)))) {
        exit(EXIT_FAILURE);
    }
    for (idx = 0; idx < LENGTH; idx++) {
        originalArray[idx] = idx + 10;
    }
    printArray(originalArray, LENGTH);

    /* Increasing length based on provided value */
    printf("Enter new length (current value is %d): ", LENGTH);
    scanf("%d", &newLength);
    bigger = realloc(originalArray, newLength * sizeof(int));
    if (bigger == NULL) {
        exit(EXIT_FAILURE);
    }
    if (bigger == originalArray) {
        printf("New pointer SAME as original one\n");
    } else {
        printf("New pointer DIFFERENT than original one\n");
    }   
    printArray(bigger, newLength);

    free(bigger);

    return EXIT_SUCCESS;
}