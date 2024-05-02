#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <err.h>
#include <sysexits.h>

#define LENGTH 9

int main() {
    int fd;
    char buf[LENGTH]; 

    fd = open("Message.txt", O_RDONLY);
    if (fd < 0) {
        err(EX_OSERR,"Cannot open file");
    } else {
        int i;
        read(fd, buf, LENGTH);
        for (i = 0; i < LENGTH; i++) {
            printf("%c", buf[i]);
        }
    }

    if (close(fd) == -1) {
        err(EX_OSERR, "Closing file failed");
    } 

    return 0;
}
