#include <stdio.h>
#include <signal.h>
#include <unistd.h>

void sigalrm_handler(int sig) {
    printf("hey, are you still there?\n");
    fflush(stdout);
}

void alarm_example(void) {
    int number_of_seconds = 2;
    signal(SIGALRM, sigalrm_handler);
    alarm(number_of_seconds);  
    printf("Waiting for alarm signal\n");  
    pause(); /* waits for signal */

    printf("After first alarm\n");
    signal(SIGALRM, sigalrm_handler); /* We need it as handler was */
                                        /* reset to default */
    alarm(number_of_seconds);  
    printf("Waiting for alarm signal\n");  
    pause();
    printf("After second alarm\n");
}

int main()  {
    alarm_example(); 

    return 0;
}
