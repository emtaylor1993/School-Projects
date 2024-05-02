#include <stdio.h>

int main() {
    unsigned int i;
    unsigned char *ch;

    printf("Size of unsigned int %ld\n", sizeof(unsigned int));
    printf("Size of unsigned char %ld\n", sizeof(unsigned char));

    i = 0x543210ab;
    printf("i = %08x\n", i);

    ch = (unsigned char *) &i;
    printf("Byte: %02x\n", *ch);
    printf("Byte: %02x\n", * (unsigned char *) &i);
    printf("Byte: %d\n", * (unsigned char *) &i);

    return 0;
}
