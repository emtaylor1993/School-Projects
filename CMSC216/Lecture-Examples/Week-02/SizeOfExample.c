#include <stdio.h>

int abc() {
    printf("abc function called");
    return 1;
}

int main() {
    int i = 5;

    printf("initial value of i: %d\n", i); /* still 5 not 6 */
    printf("i (int) size: %ld\n", sizeof(i));
    printf("unsigned char size: %ld\n", sizeof(unsigned char));
    printf("i++ size: %ld\n", sizeof(i++)); /* increment will NOT take place */
    printf("final value of i: %d\n", i); /* still 5 not 6 */
    printf("sizeof(abc()): %ld\n", sizeof(abc())); /* no function call */

    return 0;
}