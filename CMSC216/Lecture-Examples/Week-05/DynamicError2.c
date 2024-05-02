#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int x;
    int y;
} Point;

int main() {
    Point p = { 3, 4 }, *p1;
    p1 = &p;
    p1->x = 99;
    p1->x = 44;
    printf("p: %d, %d\n", p.x, p.y);
    printf("p1: %d, %d\n", p1->x, p1->y);

    free(p1); /* Is this OK??? */

    return 0;
}
