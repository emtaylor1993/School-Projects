#include <stdio.h>

int main() {
    int age = 18;
    float salary = 100.50;
    char gender = 'F';
    const char *address = "AV Williams Bld";
    const char *address2 = "AV Williams Bld%d";

    printf("Age:%d, Salary: %f, Gender: %c\n", age, salary, gender);
    printf("Address: %s\n", address);
    printf(address); /* valid, don't do it */
    printf(address2);

    return 0;
}