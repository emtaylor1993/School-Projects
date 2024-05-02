#include <sys/wait.h>
#include <sysexits.h>
#include <stdlib.h>
#include <err.h>
#include <unistd.h>
#include <sys/types.h>
#include <stdio.h>

int main() {
    pid_t child_pid;

    if ((child_pid = fork()) < 0) {
        err(EX_OSERR, "fork error");
    }
    if (child_pid) { /* parent code */
        int status;
        pid_t returned_value;

        returned_value = wait(&status);  /* nothing happens until child exits */
        printf("Exit Status\n");
        printf("WIFEXITED %d\n", WIFEXITED(status));
        printf("WEXITSTATUS %d\n", WEXITSTATUS(status));
        printf("WTERMSIG %d\n", WTERMSIG(status));
        if (child_pid != returned_value) {
            printf("Parent (PID: %d) has executed wait and it failed with status %d\n", getpid(), status);
        } else {
            printf("Parent (PID: %d) has executed wait successfully with status %d\n", getpid(), status);
        }
        exit(8);
    } else { /* child code */
        printf("Child (PID: %d) with Parent (PID: %d) finished executing.\n", getpid(), getppid());
        exit(9);
    }
}
