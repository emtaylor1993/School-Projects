/*
 * You can control debugging activity as
 * follows:
 * Activating debugging --> #define MY_DEBUG 1  
 * Deactivating debugging I -->  #define MY_DEBUG 0 
 * You can also enable debugging in the command as follows:
 *
 */

#include <stdio.h>

int main(){
    int a = 20;
    int b = 3;

    int c = a * b; 
#if MY_DEBUG
    printf("(Debugging) Value of a is %d\n", a);
    printf("(Debugging) Value of b is %d\n", b);
    printf("(Debugging) Value of c is %d\n", c);
#else
    printf("Result: %d\n", c);
#endif

    return 0;
}
