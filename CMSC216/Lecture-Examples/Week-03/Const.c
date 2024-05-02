#include <stdio.h>

void processDataConst(const int *p) {
    /* *p = 100; */ /* Not possible  */
    printf("data constant value %d\n", *p);
    p = NULL; /* No problem */
}

void processPtrConst(int * const p) {
    *p *= 2;
    printf("ptr constant %d\n", *p);
    /* p = NULL; Problem */
}

int main () {
    int i = 4;
    processDataConst(&i);
    processPtrConst(&i);

    return 0;
}
