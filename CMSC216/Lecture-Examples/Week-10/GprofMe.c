/* compile with: gcc -pg gprof-me.c -o gprof-me */
/* run: ./gprof-me */
/* then: gprof gprof-me | less */

#include <time.h>
#include <stdio.h>

void burn_cpu_cycles_one_function() {
    volatile int i,j,k;
    printf("before clock: %ld or %5.3f seconds\n", clock(), (double)clock() / CLOCKS_PER_SEC);

    for(i = 0; i < 1000000; i++) {
        for(k = 0; k < 100; k++) {
            j = i*i*k;
        }
    };
    printf("%d\n", j);
    printf("after clock: %ld or %5.3f seconds\n", clock(), (double)clock() / CLOCKS_PER_SEC);
}

int mini_burn(int i) {
    int j,k;
    for(k = 0; k < 100; k++) {
        j = i * i * k;
    }
    return j;
}

void burn_cpu_cycles_repeated_func() {
    volatile int i, j;
    printf("before clock: %ld or %5.3f seconds\n", clock(), (double)clock() / CLOCKS_PER_SEC);

    for(i = 0; i < 1000000; i++) {
        j = mini_burn(i);
    };
    
    printf("%d\n", j);
    printf("after clock: %ld or %5.3f seconds\n", clock(), (double)clock() / CLOCKS_PER_SEC);
}

int main() {
    burn_cpu_cycles_one_function();
    burn_cpu_cycles_repeated_func();
}
