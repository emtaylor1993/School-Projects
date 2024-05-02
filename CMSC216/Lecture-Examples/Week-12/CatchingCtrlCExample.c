#include <stdio.h>
#include <sys/types.h>
#include <signal.h>
#include <sys/wait.h>
#include <unistd.h>
#include <stdlib.h>

void new_handler(int sig) {
    printf("\nIf you really want to quit, try ctrl-c again");
    fflush(stdout);
}

void catching_ctrl_c(void) {
    void (*old_handler)(int); /* function ptr */

    if ((old_handler = signal(SIGINT, new_handler)) == SIG_ERR)  {
        perror("Failed to set signal handler");   
        exit(EXIT_FAILURE);
    }

    printf("Waiting for a signal (try ctrl-c)");
    fflush(stdout);
    pause(); /* waits for signal */ 

    if (signal(SIGINT, old_handler) == SIG_ERR)  {
        perror("Failed to restore signal handler");   
    } else {
        printf("\nRestored\n");
        fflush(stdout);
    }

    pause(); /* waits for signal */
}

int main()  {
    catching_ctrl_c(); 

    return 0;
}
