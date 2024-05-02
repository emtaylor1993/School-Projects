/* Recursion #1 */

is_bigger(X,Y) :- bigger(X,Y).
is_bigger(X,Y) :- bigger(X,Z), is_bigger(Z,Y).

bigger(horse,duck).
bigger(duck,fly).
