#include <stdio.h>
#include <time.h>
#include <unistd.h>
 
int main(void) {
    time_t start, end;
    /* struct tm *ts; */
    char *passed_time;

    /* Get the current time */
    start = time(NULL);
    passed_time = ctime(&start);
    printf("ctime: %s", passed_time);

    printf("About to sleep for 10 seconds\n");
    sleep(10);
    end = time(NULL);
    passed_time = ctime(&end);
    printf("ctime after sleeping: %s\n", passed_time);
    printf("time difference (seconds) %f\n", difftime(end, start));

    return 0;
}
