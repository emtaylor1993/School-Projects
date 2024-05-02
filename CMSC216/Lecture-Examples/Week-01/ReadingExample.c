#include <stdio.h>

int main() {
    char gender = 'N';
    int age = -1;   

    printf("Enter gender(M/F) and age: ");
    scanf("%c%d", &gender, &age);
    printf("Gender: %c, Age: %d\n", gender, age);

    return 0;
}
