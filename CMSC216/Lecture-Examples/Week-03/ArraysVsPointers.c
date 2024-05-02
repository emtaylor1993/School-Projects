#include <stdio.h>

void print_array(int *p, int size) {  /* int *p could have been written as int p[] */
    int idx = 0;
    for (idx = 0; idx < size; idx++) {
        printf("%d\n", p[idx]);
    }

    /* p = NULL; What happens if we try this assignment */
    printf("In print_array function size of array using sizeof: %ld\n", sizeof(p));
}

int main() {
    int data[] = {10, 20, 30, 40, 50, 60};

    print_array(data, 3);
    /* data = NULL;  What happens if we try this assignment */

    printf("Size of data array using sizeof: %ld\n", sizeof(data));

    return 0;
}