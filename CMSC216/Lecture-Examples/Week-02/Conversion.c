#include <stdio.h>

int main() {
    int x = 2000000000;

    printf("%d\n", x);
    printf("%d\n", x * 3);
    printf("%ld\n", x * 3L);

    return 0;
}