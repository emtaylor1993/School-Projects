#include <stdio.h>
#include <time.h>
#include <unistd.h>
#include <stdlib.h>
 
/*
 * Execute "time a.out"
 */
int main() {
    long x = 10000000;

    while (x-- > 0) ;
    system("ls -l");

    printf("About to sleep for 10 seconds\n");
    sleep(10);
    printf("Done\n");

    return 0;
}
