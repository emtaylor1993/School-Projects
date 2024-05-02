#include <stdio.h>

int main() {
    int *p; 
    *p = 200;  /* What is p pointing to?  THIS IS WRONG */
    printf("The value is %d\n", *p);
    return 0;
}