#include <stdio.h>
#include <stdlib.h>

#define MAX_FILENAME_LEN 20
#define MAX_STUDENTS_NAME_LEN 20
#define MAX_LINE_LEN (MAX_STUDENTS_NAME_LEN + 60)
int main() {
    FILE *input_stream;
    char filename[MAX_FILENAME_LEN + 1]; 
    char students_name[MAX_STUDENTS_NAME_LEN + 1];   
    char line[MAX_LINE_LEN + 1];
    int id;

    printf("Input file name (e.g., Employee.txt): ");
    scanf("%s", filename);
    if (!(input_stream = fopen(filename, "r"))) {
        perror("error opening file");
        exit(EXIT_FAILURE);
    } else {
        while (fgets(line, MAX_LINE_LEN + 1, input_stream) != NULL) {
            sscanf(line, "%s %d", students_name, &id);
            printf("Name: %s, Id: %d\n", students_name, id);
        } 
    }
    fclose(input_stream);

    return EXIT_SUCCESS;
}