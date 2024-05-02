/*
 * Another tracing example.
 * Let's try: my_last(X, [1,2,3]).
 */

my_last(X, [X]).
my_last(X, [_|T]) :- my_last(X, T).
