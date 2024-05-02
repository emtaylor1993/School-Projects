%--------------------------------------------------------
% some family facts

female(alice).
male(bob).
male(charlie).
male(dennis).

father(bob, charlie).
father(dennis, bob).
mother(alice, charlie).

% some family rules

son(X, Y) :- father(Y, X), male(X).
son(X, Y) :- mother(Y, X), male(X).

%--------------------------------------------------------

blond(X) :-
	father(Father, X),
	blond(Father),         % father is blond
	mother(Mother, X),
	blond(Mother).         % mother is blond

%--------------------------------------------------------
% some Prolog clauses (facts)

bigger(horse, duck).
bigger(duck, gnat).

% some Prolog clauses (rules)

is_bigger(X,Y) :- bigger(X,Y).
is_bigger(X,Y) :- bigger(X,Z), is_bigger(Z,Y).

%--------------------------------------------------------
% Goal execution example

mortal(X) :- man(X).
man(socrates).
