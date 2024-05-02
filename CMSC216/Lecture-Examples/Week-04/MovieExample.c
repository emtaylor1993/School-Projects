#include <stdio.h>
#include <string.h>

#define MAX_STR_LEN 80

typedef struct movie {
    char name[MAX_STR_LEN + 1];
    int year;
    float earnings;
} Movie;

Movie init(const char p_name[], int p_year, float p_earnings) {
    struct movie newone;

    strcpy(newone.name, p_name);
    newone.year = p_year;
    newone.earnings = p_earnings;

    return newone;  /* Notice we return a copy */
}

void modify(Movie m) {
    strcpy(m.name, "MODIFY");
    m.year = 1900;
    m.earnings = 50;
}

void modify_two(Movie *p) {
    strcpy(p->name, "MODIFY");
    p->year = 2011;
    p->earnings = 100;
}

void print_movie(Movie m) {
    printf("Name: %s,", m.name);
    printf(" Year: %d, ", m.year);
    printf(" BoxOffice: %.2f\n", m.earnings);
}

int equals(Movie m1, Movie m2) {
    if (strcmp(m1.name, m2.name) == 0)
        if (m1.year == m2.year)
            if (m1.earnings == m2.earnings)
            return 1;

    return 0;
}

int main() {
    struct movie m1;  /* Are m1 and m2 of the same type? */
    Movie m2, m3;
    Movie *ptr;

    printf("\n***** Initializing structures *****\n");
    m1 = init("Alienators", 1990, 6.0);
    m2 = init("Jaws Jr", 1985, 9.0);
    print_movie(m1);
    print_movie(m2);

    printf("\n***** Assignment/Comparison *****\n");
    m3 = m1; /* What kind of copying is taking place? */  
    if (equals(m1, m3)) {
        printf("Movies are the same.\n");
    } else {
        printf("Movies are different.\n");
    }

    printf("\n***** Modifying structure??? *****\n");
    printf("Before modify method call.\n");
    print_movie(m1);
    modify(m1);
    printf("After modify method call.\n");
    print_movie(m1);

    printf("\n***** Modifying structure (Second Attempt)  *****\n");
    printf("Before modify method call.\n");
    print_movie(m1);
    ptr = &m1;
    modify_two(ptr);
    printf("After modify method call.\n");
    print_movie(m1);

    return 0;
}
