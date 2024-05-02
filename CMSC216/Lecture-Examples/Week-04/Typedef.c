#include <stdio.h>

typedef double Dollars;

int main() {
    Dollars x = 20.0;   
    double y;

    printf("%.2f\n", x);
    y = 30;
    x = y;
    printf("%.2f\n", x);

    return 0;
}
