/* Notice that pressing tap will give you multiple */
/* answers.  Try son(X,Y).                         */

female(alice).
male(bob).
male(charlie).
father(bob, charlie).
mother(alice, charlie).
% "X is a son of Y"
son(X, Y) :- father(Y, X), male(X).
son(X, Y) :- mother(Y, X), male(X).
