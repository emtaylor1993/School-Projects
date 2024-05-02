#include <stdio.h>

char letterGrade(float score) {
    if (score >= 90)
        return 'A';
    else if (score >= 80)
        return 'B';
    else
        return 'F';
}

int main() {
    float s1, s2, avg;

    printf("Enter first score: ");
    scanf("%f", &s1);

    printf("Enter second score: ");
    scanf("%f", &s2);

    avg = (s1 + s2) / 2;
    printf("Average for %f and %f is %f\n", s1, s2, avg);
    printf("Your letter grade is %c\n", letterGrade(avg));

    return 0;
}