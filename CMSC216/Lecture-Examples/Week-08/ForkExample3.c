/********************************/
/* The program reads two        */
/* integer values.  The parent  */
/* will call even_odd on the    */
/* first value and the child    */
/* on the second.               */
/* Notice we need the exit(0)   */
/* in the process_values()      */
/* function, otherwise you will */
/* be printing "Done in Main"   */
/* twice. For this example you  */
/* don't want the child to      */
/* return to main().            */
/* ******************************/
#include <sysexits.h>
#include <stdlib.h>
#include <err.h>
#include <unistd.h>
#include <sys/types.h>
#include <stdio.h>

void process_values(int x, int y);

void even_odd(int a) {
    if (a % 2 == 0) {
        printf("%d is even\n", a);
    } else {
        printf("%d is odd\n", a);
    }
}

int main() {
    int x, y;

    printf("Enter two integer values: ");
    scanf("%d%d", &x, &y);

    process_values(x, y);

    printf("Done in Main\n");

    return 0;
}

void process_values(int x, int y) {
    pid_t child_pid;

    if ((child_pid = fork()) < 0) {
        err(EX_OSERR, "fork error");
    }

    if (child_pid != 0) { /* parent code */
        even_odd(x);
    } else { /* child code */
        even_odd(y);
        exit(0);  /* WHY WE NEED IT? Remove it and run */
    }
}
