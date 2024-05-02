#include <stdio.h>

#define MAX_LEN 80

int main() {
    char first_name[MAX_LEN + 1];
    char last_name[MAX_LEN + 1];

    printf("Enter your first name: ");
    scanf("%s", first_name);  
    printf("Name provided is %s\n", first_name);

    printf("Enter your last name: ");
    scanf("%s", last_name);  
    printf("Last name provided is %s\n", last_name); 

    return 0;
}