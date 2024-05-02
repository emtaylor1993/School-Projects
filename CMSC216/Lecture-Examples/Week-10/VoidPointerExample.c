#include <stdio.h>

typedef struct {
    int x, y;
} Point;

enum Possible_Types { MY_POINT, MY_INT, MY_DOUBLE };

void process_data(void *data, int type) {
    Point *point_ptr;
    int *int_ptr;
    double *double_ptr;

    switch(type) {
        case MY_POINT:
            point_ptr = (Point *)data;
            printf("[%d, %d]\n", point_ptr->x, point_ptr->y);
            break;
        case MY_INT:
            int_ptr = (int *)data;       
            printf("%d\n", *int_ptr); 
            break;
        case MY_DOUBLE:
            double_ptr = (double *)data;       
            printf("%f\n", *double_ptr); 
            break;

        default: 
            printf("Invalid type\n");
    }
}

int main() {
    Point pt = {10, 20};
    int int_value = 700;
    double double_value = 3.14;

    process_data(&pt, MY_POINT);
    process_data(&int_value, MY_INT);
    process_data(&double_value, MY_DOUBLE);

    return 0;
}
