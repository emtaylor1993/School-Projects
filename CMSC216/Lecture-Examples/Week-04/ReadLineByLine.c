#include <stdio.h>
#include <stdlib.h>

#define MAX_LEN 80

int main() {
    FILE *input;
    char buffer[MAX_LEN + 1], filename[MAX_LEN + 1];   

    printf("Input file name (e.g., Data.txt): ");
    scanf("%s", filename);
    if ((input = fopen(filename, "r")) == NULL) {
        perror("error opening file");
        exit(EXIT_FAILURE);
    } else {
        while (fgets(buffer, MAX_LEN + 1, input) != NULL) {
            printf("%s", buffer);
        } 
    }
    fclose(input);

    return EXIT_SUCCESS;
}
