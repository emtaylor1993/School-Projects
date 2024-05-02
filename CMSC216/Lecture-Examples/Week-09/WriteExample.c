#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <err.h>
#include <sysexits.h>
#include <string.h>

int main() {
    int fd;

    fd = open("Message.txt", O_WRONLY|O_TRUNC|O_CREAT);
    if (fd < 0) {
        err(EX_OSERR, "can't open Message.txt");
    } else {
        char msg[] = "Hi there!";
        write(fd, msg, strlen(msg));
    } 

    if (close(fd) == -1) {
        err(EX_OSERR, "closing file failed\n");
    } else {
        printf("File Message.txt has been created\n");
    }

    return 0;
}
