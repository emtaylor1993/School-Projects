#include <stdio.h>

int main() {
    int i;

    i = 1, 2, 3, 4;
    printf("%d\n", i);

    i = (1, 2, 3, 4);
    printf("%d\n", i);

    return 0;
}