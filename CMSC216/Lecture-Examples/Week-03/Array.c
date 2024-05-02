#include <stdio.h>

int main() {
    int idx;

    int a[3] = {10, 20, 30};
    for (idx = 0; idx < 3; idx++) {
        printf("%d ", a[idx]);
    }
    printf("\n");


    /* No size specified */
    char b[] = {'A', 'B', 'C'};
    for (idx = 0; idx < 3; idx++) {
        printf("%c ", b[idx]);
    }
    printf("\n");


    /* Only one initializer value */ 
    float c[4] = {1.5};
    for (idx = 0; idx < 4; idx++) {
        printf("%f ", c[idx]);
    }
    printf("\n");

    return 0;
}
