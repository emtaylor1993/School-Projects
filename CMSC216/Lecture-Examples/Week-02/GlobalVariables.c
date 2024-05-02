#include <stdio.h>

int yGlobal = 10;

void process() {
    yGlobal++;
}

int main() {
    printf("Value of y: %d\n", yGlobal);
    process();
    printf("Value of y: %d\n", yGlobal);

    return 0;
}
