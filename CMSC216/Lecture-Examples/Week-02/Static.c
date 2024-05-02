#include <stdio.h>

void compute(int x) {
    static int times = 0;

    printf("x value is %d\n", x);
    printf("Times: %d\n", ++times);
}

int main() {
    compute(10);
    compute(11);
    compute(12);

    return 0;
}