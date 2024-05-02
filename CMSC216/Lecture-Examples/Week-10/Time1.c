#include <stdio.h>
#include <time.h>
 
/*
 * The result should look something like
 * Sun 2012-07-29 14:55:51 EDT
 *
 */
 
int main(void) {
    time_t now;
    struct tm *ts;
    char buf[81];

    /* Get the current time */
    now = time(NULL);

    /* Format and print the time "ddd yyyy-mm-dd hh:mm:ss zzz" */
    ts = localtime(&now);
    strftime(buf, sizeof(buf), "%a %Y-%m-%d %H:%M:%S %Z", ts);
    printf("%s\n", buf);

    return 0;
}
