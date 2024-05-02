#include <stdio.h>

#define VAL "My Name is Harry Potter"
#define SUM(a,b) ((a) + (b))
#define MIN(a, b) ((a < b) ? (a) : (b))

int main(){
    printf("%s\n",VAL);
    printf("sum(3,5) = %d\n", SUM(3,5));
    printf("sum(14,9) = %d\n", SUM(14,9));
    printf("min(3,5) = %d\n", MIN(3,5));
    printf("min(14,9) = %d\n", MIN(14,9));

    return 0;
}
