#include <stdio.h>

int main() {
    char mascot[] = "terps";
    char city[13] = "College Park"; /* Why 13? */
    char state[20] = "Maryland"; 
    char zipCode[6] = {'2','0','7', '4', '2', '\0'}; 
    int idx;

    printf("Mascot: %s\n", mascot);
    printf("City: %s\n", city);
    printf("Printing state character by character: ");
    for (idx = 0; idx < 8; idx++) { 
        printf("%c", state[idx]);
    }
    printf("\n");
    printf("Zipcode: %s\n", zipCode);

    return 0;
}
