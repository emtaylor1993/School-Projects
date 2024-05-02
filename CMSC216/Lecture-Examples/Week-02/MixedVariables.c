#include <stdio.h>

int main() {
    unsigned char a;
    char b, c;

    b = 'b', c = 'c';
    a = b + c;
    printf("Unsigned sum result: %d\n", a); 
    b = b + c;
    printf("Signed sum result: %d\n", b); 

    return 0;
}
