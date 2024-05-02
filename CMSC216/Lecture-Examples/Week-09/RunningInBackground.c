/*
 * Illustrates what happens when program in background finishes.
 * To run: a.out < longTime &
 *         a.out < shortTime &
 */
#include <stdio.h>
#include <unistd.h>

int main() {
    unsigned seconds;

    printf("Enter time: ");
    scanf("%u", &seconds);
    sleep(seconds);

    printf("The wait is over :)\n");

    return 0;
}
