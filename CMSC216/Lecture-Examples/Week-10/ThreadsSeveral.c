#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <time.h>
#include <unistd.h>

#define THREAD_CT 2

void *print_stuff(void *ptr) {
    int i, id = *(int *) ptr;
    for (i = 0; i < 5; i++) {
        printf("Thread %d, loop %d\n", id, i);
        sleep(rand() % 2);  /* sleep 0 or 1 seconds */
    }
    printf("Thread %d exiting\n", id);

    return NULL;
}

int main() {
    pthread_t tids[THREAD_CT];
    int i, ids[THREAD_CT];

    for (i = 0; i < THREAD_CT; i++) {
        ids[i] = i + 1;
        pthread_create(&tids[i], NULL, print_stuff, &ids[i]);
        printf("Thread 0 created thread %d\n", i + 1);
    }

    for (i = 0; i < THREAD_CT; i++) {
        pthread_join(tids[i], NULL);
        printf("Thread 0 reaped thread %d\n", i + 1);
    }

    return 0;
}
