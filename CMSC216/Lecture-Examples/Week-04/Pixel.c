#include <stdio.h>

struct pixel {
    int x, y;
    char color;
};

int main() {
    struct pixel p1;

    p1.x = 1;
    p1.y = 2;
    p1.color = 'r';

    printf("pixel: x: %d, y: %d, color: %c\n", p1.x, p1.y, p1.color);

    return 0;
}
