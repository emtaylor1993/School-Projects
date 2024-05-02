#include <stdio.h>

int main() {
    unsigned int a = 16;  /* not hex */
    unsigned int c = 0x55555555; 

    printf("Shifting 0x%08x (Decimal %d) \n", a, a);
    printf("a << 1: 0x%08x (Decimal %d) \n", a << 1, a << 1);
    printf("a << 2: 0x%08x (Decimal %d) \n", a << 2, a << 2);
    printf("a >> 1: 0x%08x (Decimal %d) \n", a >> 1, a >> 1);
    printf("a >> 2: 0x%08x (Decimal %d) \n", a >> 2, a >> 2);
    printf("a after shifting 0x%08x (Decimal %d) \n", a, a);

    printf("*****\n");
    printf("Shifting 0x%08x\n", c);
    printf("c << 2: 0x%08x\n", c << 2);
    printf("c >> 3: 0x%08x\n", c >> 3);
    printf("c after shifting: 0x%08x\n\n", c);

    return 0;
}