#include <stdio.h>
#include <stdlib.h>

/* Return the nth Fibonacci number 
 * (fib(0) = fib(1) = 1)
 */
unsigned long fib(unsigned int n) {
    if (n == 0 || n == 1)
        return 1;
    return fib(n-1) + fib(n-2);
}

int main(int argc, char *argv[]) {
    int num;
    if (argc != 2) {
        printf("Usage: a.out <number>\n");
        exit(1);
    }
    num = atoi(argv[1]);
    printf("%lu\n", fib(num));

    return 0;
}
