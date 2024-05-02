#include <stdio.h>
#include <stdlib.h>

#define SIZE 5
#define BIG_SIZE 1000

void printArray(const char *name, int *arr, int size) {
    int i;

    printf("Values of array \"%s\":\n", name);
    for (i = 0; i < size; i++) {
        printf(" %d ", arr[i]);
        if (!((i + 1) % 10)) {
            printf("\n");
        }
    }
    printf("\n");
}

int main() {
    int *arr1 = calloc(SIZE, sizeof(int));
    int *arr2 = calloc(SIZE, sizeof(int));
    int *newArr;
    int i, seed;

    printf("Type the seed: ");
    scanf("%d", &seed);
    srand(seed);
    for (i = 0; i < SIZE; i++) {
        arr1[i] = rand() % 10;
        arr2[i] = rand() % 10 + 10;
    }
    printArray("arr1", arr1, SIZE);
    printArray("arr2", arr2, SIZE);

    /* Changing size of arr1 */
    newArr = realloc(arr1, BIG_SIZE);
    printf("arr1 at %p, arr2 at %p\nnewArr at %p\n",
            (void *) arr1, (void *) arr2, (void *) newArr);
    printArray("newArr", newArr, BIG_SIZE);

    return 0;
}
