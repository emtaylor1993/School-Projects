#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

void *get_rand_num(void *args) {
    int *nump = malloc(sizeof(int));
    srand(pthread_self());
    *nump = rand();

    return nump;
}

int main() {
    pthread_t tid;
    void *ptr = NULL;

    pthread_create(&tid, NULL, get_rand_num, NULL);
    pthread_join(tid, &ptr);
    printf("Random number: %d\n", * (int *) ptr);

    free(ptr);
    return 0;
}
