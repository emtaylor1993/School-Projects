#include <sys/wait.h>
#include <stdio.h>
#include <sysexits.h>
#include <stdlib.h>
#include <err.h>
#include <unistd.h>
#include <sys/types.h>

extern char **environ;
int main() {
    const char * const argv[] = { "ls", "-F", NULL }; 
    pid_t child_pid;

    if ((child_pid = fork()) < 0) {
        err(EX_OSERR, "fork error");
    }
    if (child_pid) { /* parent code */
        wait(NULL); /* waiting for child to finish */
        printf("Parent pid = %d; my child had pid = %d\n", getpid(), child_pid);
    }
    else { /* child code */
        printf("PID %d replacing myself\n", getpid());
        execve("/bin/ls", (char * const *)argv, environ);
        err(EX_OSERR, "exec error");  /* why no if statement? */
    }

    return 0;
}
