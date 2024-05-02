#include <stdio.h>
#include <sys/time.h>
#include <sys/resource.h>
#include <time.h>
#include <stdlib.h>

#define ROWS 10000
#define COLS ROWS

int arr[ROWS][COLS];

int main() {
    int i, j;
    unsigned long sum = 0;
    struct rusage usage1, usage2;
    time_t seconds;

    time(&seconds);
    srand((unsigned int)seconds);

    for (i = 0; i < ROWS; i++)
        for (j = 0; j < COLS; j++)
        arr[i][j] = rand();
    getrusage(RUSAGE_SELF, &usage1);
    for (i = 0; i < ROWS; i++)
        for (j = 0; j < COLS; j++)
        sum += arr[i][j];
    getrusage(RUSAGE_SELF, &usage2);
    printf("sum = %ld\n", sum);
    /* calculate user time, store in usage2 */
    printf("User time %d.%06ds\n", (int) usage2.ru_utime.tv_sec,
        (int) usage2.ru_utime.tv_usec);

    return 0;
}
