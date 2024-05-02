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

        printf("Parent waiting for child\n");
        wait(&status);  /* nothing happens until child exits */
        printf("Parent pid = %d; my child had pid = %d\n",
                getpid(), child_pid);
        printf("Child exited with status %d\n", status);
    }
    else { /* child code */
        sleep(4); /* simulating child's processing */
        printf("Child pid = %d; my parent has pid = %d\n",
                getpid(), getppid());
    }

    return 0;
}
