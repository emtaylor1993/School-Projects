#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

struct point {
    int x, y;
};

static void *print_point(void *pointp);

int main() {
    pthread_t tid; /* thread id */
    struct point pt = {3, 5};

    if (pthread_create(&tid, NULL, print_point, &pt) != 0) {
        printf("pthread_create failed\n");
        exit(1);
    }

    /* reaps thread blocking until thread terminates */
    pthread_join(tid, NULL);

    printf("In main after thread finished\n");

    return 0;
}

/* code executed by the thread */
static void *print_point(void *pointp) {
    struct point arg = * (struct point *) pointp;
    printf("Point: (%d, %d)\n", arg.x, arg.y);

    return NULL;
}
