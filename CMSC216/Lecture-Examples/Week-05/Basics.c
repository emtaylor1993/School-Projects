#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>

int main(){
    int *ip, i, arrayLength = 3;

    /* Allocating space for an integer */
    ip = malloc(sizeof (int)); /* notice casting is not necessary */
    if (ip == NULL) {
        exit(EXIT_FAILURE);
    }
    *ip = 104;
    printf("Value assigned is %d\n", *ip);
    free(ip); /* deallocating memory */



    /* Allocating space for array */
    ip = malloc(sizeof (int) * arrayLength);
    if (ip == NULL) {
        exit(EXIT_FAILURE);
    }
    for (i = 0; i < arrayLength; i++){
        ip[i] = i * 3;
    }
    for (i = 0; i < arrayLength; i++){
        printf("%d ",ip[i]); /* notice using array indexing */
    }
    printf("\n");
    free(ip); /* deallocating memory */
        


    /* Allocating another array */
    ip = calloc(arrayLength, sizeof (int));
    if (ip == NULL) {
        exit(EXIT_FAILURE);
    }
    for (i = 0; i < arrayLength; i++){
        ip[i] = i * 4;
    }
    for (i = 0; i < arrayLength; i++){
        printf("%d ",ip[i]); /* notice using array indexing */
    }
    printf("\n");
    free(ip); /* deallocating memory */

    return EXIT_SUCCESS;
}
