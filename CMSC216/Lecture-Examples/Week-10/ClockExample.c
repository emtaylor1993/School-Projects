#include <stdio.h>
#include <malloc.h>
#include <time.h>
     
int main(){
    int n = 10000, i, j, *p;
    clock_t start, end;
    double ticks_used, cpu_time_used;
        
    start = clock();
    for (i = 0; i < n; i++){
        p = calloc(n,sizeof(int));
        for (j = 0; j < n; j++){
            p[j] = j*i;
        }
        free(p);
    }
    printf("Done with %d\n",n);
    end = clock();

    ticks_used = ((double) (end - start));
    cpu_time_used = ticks_used / CLOCKS_PER_SEC;

    printf("ticks used = %f\n", ticks_used);
    printf("time used = %f\n", cpu_time_used);

    return 0;
}
