#include <sys/types.h>
#include <sys/stat.h>
#include <sys/wait.h>
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <err.h>
#include <sysexits.h>

int main() {
    int pipe_fd[2]; /* pipe */
    char buf[BUFSIZ];  /* BUFSIZ is defined in stdio.h */
    pid_t child_pid;

    /* Creating pipe */
    if (pipe(pipe_fd) < 0) {
        err(EX_OSERR, "pipe error");   
    }
    if ((child_pid = fork()) < 0) { 
        err(EX_OSERR, "fork error");
    }

    if (child_pid) { /* parent code */
        close(pipe_fd[1]);     /* closing write end */
        read(pipe_fd[0], buf, BUFSIZ);
        printf("Message from child: %s\n", buf);
        close(pipe_fd[0]);    /* closing read end */
        wait(NULL);  /* reaping */
    } else { /* child code */
        char msg[] = "Hi there!";
        close(pipe_fd[0]);   /* closing read end */
        write(pipe_fd[1], msg, sizeof(msg));
        close(pipe_fd[1]);   /* closing write end */
    }

    return 0;
}
