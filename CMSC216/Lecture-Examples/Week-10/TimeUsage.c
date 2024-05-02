#include <sys/time.h>
#include "resource.h"
#include <unistd.h>
#include <malloc.h>
#include <stdio.h>

struct timeval tv_delta(struct timeval start, struct timeval end) {
    struct timeval delta = end;
    delta.tv_sec -= start.tv_sec;
    delta.tv_usec -= start.tv_usec;
    if (delta.tv_usec < 0) {
        delta.tv_usec += 1000000;
        delta.tv_sec--;
    }
    return delta;
}

int main() {
    struct rusage start_ru, end_ru;
    struct timeval start_wall, end_wall;
    struct timeval diff_ru, diff_wall;
    int n = 10000, i, j, *p;

    gettimeofday(&start_wall, NULL);
    getrusage(RUSAGE_SELF, &start_ru);

    printf("About to sleep for 4 seconds\n");
    sleep(4);
    for (i = 0; i < n; i++){
        p = calloc(n,sizeof(int));
        for (j = 0; j < n; j++){
        p[j] = j*i;
        }
        free(p);
    }
    printf("Done with %d\n",n);

    gettimeofday(&end_wall, NULL);
    getrusage(RUSAGE_SELF, &end_ru);

    diff_ru = tv_delta(start_ru.ru_utime,end_ru.ru_utime);
    diff_wall = tv_delta( start_wall,end_wall);

    printf("Usertime: %ld.%06ld\n", diff_ru.tv_sec, diff_ru.tv_usec);
    printf("Walltime: %ld.%06ld\n", diff_wall.tv_sec, diff_wall.tv_usec);

    return 0;
}
