#include <stdio.h>

void process(void *dataPtr, int type) {
    int a;
    double b;

    if (type == 1) {
        a = *((int *)dataPtr);
        printf("int value provided %d\n", a);
    } else if (type == 2) {
        b = *((float *)dataPtr);
        printf("float value provided %f\n", b);
    } else {
        printf("Invalid type provided\n");
    }
}

int main() {
    int x = 200; 
    float y = 4.4; 
    int *xPtr;
    void *vPtr;

    /* You can assign any address to a void pointer */
    vPtr = &y; /* assigning pointer to float */
    vPtr = &x; /* assigning pointer to int */

    /* We cannot dereference void ptr */
    /* *vPtr = 100; */

    *((int *)vPtr) = 400;
    printf("Value of x: %d\n", x);

    xPtr = (int *)vPtr;
    *xPtr = 600;
    printf("Value of x: %d\n", x);

    /* Void pointers allow us to pass any data */
    process(&x, 1);
    process(&y, 2);

    return 0;
}