#include <pthread.h>
#include <stdio.h>
#include <pthread.h>
#include <semaphore.h>

#define LOOPS 10000000

static int count = 0;
static sem_t mutex;

void *counter(void *args) {
    int i;
    for (i = 0; i < LOOPS; i++) {
        sem_wait(&mutex);
        count++;
        sem_post(&mutex);
    }
    printf("Executed %d times\n", i);

    return NULL;
}

int main() {
    pthread_t tids[2];

    sem_init(&mutex, 0, 1);
    pthread_create(&tids[0], NULL, counter, NULL);
    pthread_create(&tids[1], NULL, counter, NULL);
    pthread_join(tids[0], NULL);
    pthread_join(tids[1], NULL);
    printf("Count: %d\n", count);

    return 0;
}
