#include <stdio.h>
#include <unistd.h>

int main() {
    printf("PID = %d\n", getpid());
    execlp("sleep", "blargh", "60", NULL);

    return 1;
}
