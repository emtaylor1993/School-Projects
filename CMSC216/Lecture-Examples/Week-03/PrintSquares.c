#include <stdio.h>
#include <stdlib.h>

int main(int argc, char **argv) { /* notice definition of argv */
    int idx;

    if (argc != 2) {
        printf("Usage: %s <number>\n", argv[0]);
    } else {
        for (idx = 1; idx <= atoi(argv[1]); idx++) {  /* why using atoi? */
            printf("%d-->%d\n", idx, idx * idx);
        }
    }

    return 0;
}