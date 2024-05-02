#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

/* same as 0666, but a bit more symbolic */
#define DEF_MODE (S_IRUSR | S_IWUSR | S_IRGRP | S_IWGRP | S_IROTH | S_IWOTH)

int main() {
    int fd;

    if ((fd = open("missing-file.txt", O_RDONLY)) < 0)
        perror("can't open missing-file.txt for read");
    else
        close(fd);

    fd = open("File.txt", O_WRONLY|O_TRUNC|O_CREAT, DEF_MODE);
    if (fd < 0)
        perror("can't open File.txt");
    else
        close(fd);

    fd = open("NewFile.txt", O_WRONLY|O_APPEND|O_CREAT, DEF_MODE);
    if (fd < 0)
        perror("can't open NewFile.txt for write");
    else
        close(fd);

    return 0;
}
