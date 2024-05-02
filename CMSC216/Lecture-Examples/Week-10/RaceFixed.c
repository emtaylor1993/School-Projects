#include <pthread.h>
#include <stdio.h>
#include <malloc.h>

#define NUM_THREADS 4

typedef struct{
    int x, y;
}Point;

void *print_point(void *arg) {
    Point p = * (Point *) arg;
    free(arg);
    printf("(%d, %d)\n", p.x, p.y);

    return NULL;
}

int main() {
    pthread_t tids[NUM_THREADS];
    int i;
    Point *pt_ptr;

    for (i = 0; i < NUM_THREADS; i++) {
        pt_ptr = malloc(sizeof(*pt_ptr));
        pt_ptr->x = i;
        pt_ptr->y = 3 * i + 2;
        pthread_create(&tids[i], NULL, print_point, pt_ptr);
    }

    for (i = 0; i < NUM_THREADS; i++)
        pthread_join(tids[i], NULL);

    return 0;
}
