#include <sys/wait.h>
#include <stdio.h>
#include <sysexits.h>
#include <stdlib.h>
#include <err.h>
#include <unistd.h>
#include <sys/types.h>

int main() {
    pid_t child_pid;

    if ((child_pid = fork()) < 0) {
        err(EX_OSERR, "fork error");
    }
    if (child_pid) { /* parent code */
        wait(NULL);
        printf("Parent pid = %d; my child had pid = %d\n", getpid(), child_pid);
    } else { /* child code */
        printf("PID %d replacing myself\n", getpid());
        execlp("ls", "ls", "-l", NULL);
        err(EX_OSERR, "exec error");  /* why no if statement? */
    }

    return 0;
}
