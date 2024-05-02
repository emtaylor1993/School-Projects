#include <stdio.h>

int main() {
    int data[] = {10, 20, 30, 40};
    int *p1 = data;
    int *p2 = data + 3;
    int *p3 = data + 4;

    printf("%d %d\n", *p1, *p2);
    printf("Difference: %ld\n", p2 - p1);
    printf("Difference Two: %ld\n", p1 - p2);
    printf("Negative index: %d\n", data[-2]); /* BAD */

    printf("%p\n", (void *)p3);   

    return 0;
}
