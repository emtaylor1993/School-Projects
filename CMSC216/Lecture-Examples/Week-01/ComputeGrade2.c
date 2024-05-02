#include <stdio.h>

char letterGrade(float score);  /* prototype */

int main() {
    /* providing values for s1 and s2 */
    /* to see what happens when not enough */
    /* values are provided by user */
    float s1 = 77, s2 = 88, avg;
    int valuesRead;

    printf("Enter two scores using <score1> and <score2> format: ");
    valuesRead = scanf("%f and %f", &s1, &s2);
    printf("The number of values read is %d\n", valuesRead);

    avg = (s1 + s2) / 2;
    printf("Average for %f and %f is %.2f\n", s1, s2, avg);

    printf("Your letter grade is %c\n", letterGrade(avg));

    return 0;
}

char letterGrade(float score) {
    if (score >= 90)
        return 'A';
    else if (score >= 80)
        return 'B';
    else
        return 'F';
}
