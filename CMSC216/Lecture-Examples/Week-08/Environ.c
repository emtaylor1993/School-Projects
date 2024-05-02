#include <stdio.h>
#include <unistd.h>

extern char **environ;
int main() {
    int idx = 0;
    char *temp = environ[idx++];

    while (temp != NULL) {
        printf("%s\n", temp);

        temp = environ[idx++];
    }

    return 0;
}