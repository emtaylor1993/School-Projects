#include <stdio.h>

/* Next TWO are not the same */
#define INT_PTR_DEFINE int *

typedef int * INT_PTR_TYPEDEF;

int main() {
    INT_PTR_TYPEDEF xPtr, y;  /* try with INT_PTR_TYPEDEF */
    int x = 200; 

    xPtr = &x;
    printf("x value via pointer %d\n", *xPtr);
    y = &x;  /* PROBLEM: y is NOT a pointer variable when using #define */
             /* y is a pointer variable when using typedef */

    return 0;
}