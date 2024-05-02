#include <stdio.h>
#include <string.h>

#define MAX_LENGTH 80

void get_account(char account_str[], const char *course) {
    static int id = 1;
    sprintf(account_str, "%s_%d_umcp_at_cp", course, id);
    id++;
}

int main() {
    int number_of_accounts, i;
    char account_str[MAX_LENGTH + 1];
    const char *course = "cmsc216";

    printf("Enter number of accounts: ");    
    scanf("%d", &number_of_accounts);  

    for (i = 1; i <= number_of_accounts; i++) { 
        get_account(account_str, course);
        printf("%s\n", account_str);
    }

    return 0;
}