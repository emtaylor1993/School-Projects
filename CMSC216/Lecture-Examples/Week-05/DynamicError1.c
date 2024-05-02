#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int x;
    int y;
} Point;

int main() {
    Point p = { 3, 4 }, *p1, *p2;
    p1 = malloc(sizeof(Point));  /* should check return value here */

    p1->x = 5;
    p1->y = 9;
    printf("p1's data before free:%d %d\n", p1->x, p1->y);
    free(p1);                    /* now p1 points to invalid memory */

    p2 = malloc(sizeof(Point));
    *p2 = p;
    p.x = 99;
    p.y = 44;
    printf("p's data: %d %d\n", p.x, p.y);
    printf("p2's data: %d %d\n", p2->x, p2->y);
    printf("p1's data: %d %d\n", p1->x, p1->y);  /* should not be using p1 */

    return 0;
}
