#include <stdio.h>

int main() {
    int age = 18;
    float salary = 100.50;
    char gender = 'F';
    const char *address = "AV Williams Bld";

    printf("Age:%d, Salary: %f, Gender: %c\n", age, salary, gender);
    printf("Address: %s\n", address);

    return 0;
}