#include <stdio.h>

int main() {
    int j, k, limit = 5;

    for (j = 0, k = 10; j <= limit; j++, k += 10) {
        printf("j-->%d,  k-->%d\n", j, k);
    }

    return 0;
}
