#include <stdio.h>
#include <unistd.h>   
#include <pthread.h>

#define NUM_THREADS 10

void *handler (void *ptr);
static pthread_mutex_t mutex; 

int counter;

int main() {
    int cnt, i[NUM_THREADS];
    pthread_t threads[NUM_THREADS];

    counter = 0; /* Initial value of shared variable */
    printf("Number of threads used %d\n", NUM_THREADS);
    for (cnt = 0; cnt < NUM_THREADS; cnt++)
        i[cnt] = cnt;

    /* Initializing semaphore */
    pthread_mutex_init(&mutex, NULL);

    /* Creating threads */
    for (cnt = 0; cnt < NUM_THREADS; cnt++)
        pthread_create (&threads[cnt], NULL, handler, (void *) &i[cnt]);

    /* Joining */
    for (cnt = 0; cnt < NUM_THREADS; cnt++)
        pthread_join(threads[cnt], NULL);

    printf("Final counter value %d\n", counter);

    /* Destroying semaphore */
    pthread_mutex_destroy(&mutex);

    return 0;
} 

void *handler (void *ptr) {
    int x = *((int *) ptr);

    printf("Thread %d about to increase value\n", x);
    pthread_mutex_lock(&mutex); 
    counter++;
    pthread_mutex_unlock(&mutex);
    printf("Thread %d done increasing value\n", x);

    return NULL;
}
