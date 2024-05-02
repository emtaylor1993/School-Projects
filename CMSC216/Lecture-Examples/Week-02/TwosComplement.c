#include <stdio.h>

int main() {
    signed int negative_one = -1;

    printf("size of negative_one %ld\n", sizeof(negative_one)); 
    printf("-1 in hexadecimal: 0x%08x\n", negative_one); 

    signed int positive_one = 1;

    printf("size of positive_one %ld\n", sizeof(positive_one)); 
    printf("1 in hexadecimal: 0x%08x\n", positive_one); 

    return 0;
}
