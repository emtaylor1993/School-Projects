/***************************************************************/
/* SIGCHLD --> signal sent to parent process whenever a child  */
/*             terminates or stops                             */
/* SIGINT --> signal sent by parent to terminate the child     */
/* SIGKILL --> terminates process and it cannot be ignored     */
/* SIGTERM --> terminates process. It can be blocked, handled  */
/*             and ignored                                     */
/*                                                             */
/* This example illustrates how we can use WTERMSIG(status)    */
/* to find out which signal terminated the child               */ 
/***************************************************************/

#include <stdio.h>
#include <sys/types.h>
#include <signal.h>
#include <sys/wait.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>

void sigchld_handler(int signal_number) {
    printf("My child has terminated (parent pid %d)\n", getpid());
}

void terminate_example() {
    int answer, seconds = 2, status, signal_used;
    pid_t child_pid;

    printf("Parent Pid %d\n", getpid());
    signal(SIGCHLD, sigchld_handler);

    child_pid = fork();
    if (child_pid) { /* parent code */
        printf("Enter 0 to terminate using SIGKILL (otherwise using SIGTERM)\n");
        fflush(stdout);
        scanf("%d", &answer);

        if (answer == 0) {
            signal_used = SIGKILL;
        } else {
            signal_used = SIGTERM;
        }

        kill(child_pid, signal_used); /* sending signal to child */

        wait(&status); /* reaping */
        printf("Signal that caused child to terminate is: %d\n", WTERMSIG(status));
    } else { /* child code */
        while(1) {
            printf("I am the child with id %d\n", getpid());

            sleep(seconds);
        }
    }
}

int main()  {
    terminate_example(); 

    return 0;
}
