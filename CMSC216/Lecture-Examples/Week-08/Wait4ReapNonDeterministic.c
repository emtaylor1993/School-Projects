/**
 * The parent will wait for each child, but
 * the order in which the output will appear
 * is non-deterministic. 

 * Reaping children in no particular order. 
 * pid = -1 parameter below defines wait set to
 * be all parent's processes. options = 0
 * makes waitpid suspend execution of calling 
 * process until a child in wait set terminates
 * pid != -1 defines the wait set to be the child
 * process with the specified pid 
 *
 * After all children have been reaped, next call to 
 * waitpid returns -1 and sets errno to ECHILD 
 *
 * Initially try 2 as MAX_CHILDREN.  To see output
 * different order in reaping try 12 as MAX_CHILDREN
 *
*/

#include <sys/wait.h>
#include <sysexits.h>
#include <stdlib.h>
#include <err.h>
#include <unistd.h>
#include <sys/types.h>
#include <stdio.h>
#include <errno.h>

#define MAX_CHILDREN 12

int main() {
    pid_t child_pid, pid;
    int idx, status, options; 

    /* Creating children processes */
    printf("\n\n**** Forking processes ****\n\n");
    for (idx = 0; idx < MAX_CHILDREN; idx++) {
        if ((child_pid = fork()) < 0) {
            err(EX_OSERR, "fork error while creating children");
        } 
        if (child_pid == 0) { /* child code */
            printf("I am child %d with pid %d and ppid %d\n", idx, getpid(), getppid());
            sleep(rand() % 10); /* simulates task child is completing */
        exit(idx); /* exiting with child number */
        } else { /* parent code */
            printf("*** Parent (pid %d) has created child #%d with pid %d\n", getpid(), idx, child_pid);
        }
    }

    pid = -1;
    options = 0; 
    printf("\n\n**** Reaping processes ****\n\n");
    while ((child_pid = waitpid(pid, &status, options)) > 0) {
        if (WIFEXITED(status)) {
        printf("child with pid %d has finished with exit status %d\n", child_pid, WEXITSTATUS(status));
        } else {
        printf("child with pid %d terminated abnormally\n", child_pid);
        }
    }
    printf("\n\n**** Done reaping processes ****\n");

    if (errno != ECHILD) {
        printf("waitpid error");
        exit(-1);
    }

    exit(0);
}
