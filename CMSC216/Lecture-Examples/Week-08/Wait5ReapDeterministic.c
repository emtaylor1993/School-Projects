/**
 * The parent will wait for each child, in
 * the same order in which they were created.
 */
#include <sys/wait.h>
#include <sysexits.h>
#include <stdlib.h>
#include <err.h>
#include <unistd.h>
#include <sys/types.h>
#include <stdio.h>
#include <errno.h>

#define MAX_CHILDREN  12

int main() {
    pid_t all_pids[MAX_CHILDREN], child_pid;
    int idx, status;

    /* Creating children processes */
    printf("\n\n**** Forking processes ****\n\n");
    for (idx = 0; idx < MAX_CHILDREN; idx++) {
        if ((all_pids[idx] = fork()) < 0) {
            err(EX_OSERR, "fork error while creating children");
        } 
        if (all_pids[idx] == 0) { /* child code */
            printf("I am child %d with pid %d and ppid %d\n", idx, getpid(), getppid());
            sleep(rand() % 10); /* simulates task child is completing */
        exit(idx); 
        } else { /* parent code */
            printf("*** Parent (pid %d) has created child %d with pid %d\n", getpid(), idx, all_pids[idx]);
        }
    }

    printf("\n\n**** Reaping processes ****\n\n");
    idx = 0;
    while ((child_pid = waitpid(all_pids[idx++], &status, 0)) > 0) {
        if (WIFEXITED(status)) {
            printf("child with pid %d has finished with exit status %d\n", child_pid, WEXITSTATUS(status));
        } else {
            printf("child with pid %d terminated abnormally\n", child_pid);
        }
    }
    printf("\n\n**** Done reaping processes ****\n\n");

    if (errno != ECHILD) {
        printf("waitpid error");
        exit(-1);
    }

    exit(0);
}
