/*
 * 1. Exercise #1
      a. Run, don't provide input, and suspend (CTRL-Z)
 *    b. See process status by using ps -fu <userid>
      c. Bring to foreground by using fg
 * 2. Exercise #2
 *    a. Run and don't provide input
 *    b. See process status by using ps -fu <userid>
 *    c. kill process
 */
#include <stdio.h> 

int main() {
    int x;
    scanf("%d", &x);

    printf("%d", x);

    return 0;
}