#include <stdio.h>

int main() {
    enum Suit {
        SPADES = 20, HEARTS, DIAMONDS, CLUBS
    };

    enum Suit s1, s2;
    s1 = SPADES;
    s2 = CLUBS;

    if (s1 < s2) {
        printf("Spades are first\n");
    } else {
        printf("Clubs are first\n");
    }
    
    printf("%d\n", s1);
    printf("%d\n", s2);

    s1 = SPADES + 10;

    printf("%d\n", s1);

    return 0;
}