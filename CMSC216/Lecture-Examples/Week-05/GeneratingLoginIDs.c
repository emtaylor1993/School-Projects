#include <stdio.h>
#include <string.h>

#define MAX_LENGTH 80
#define MAX_LIST_LENGTH 50

void generate_id_list(char list[][MAX_LENGTH + 1], int number_of_ids) {
    char login_id[MAX_LENGTH + 1];
    int idx = 0;
    while (idx <= number_of_ids) {
        sprintf(login_id, "cmsc%dumcp", idx + 1);
        strcpy(list[idx++], login_id);
    }
}

int main() {
    int number_of_ids, idx;
    char list[MAX_LIST_LENGTH][MAX_LENGTH + 1];

    printf("Enter number of ids: ");    
    scanf("%d", &number_of_ids);  
    generate_id_list(list, number_of_ids);

    for (idx = 0; idx < number_of_ids; idx++) {
        printf("%s\n", list[idx]);
    }

    return 0;
}
