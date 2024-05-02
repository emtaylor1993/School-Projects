/*
 * Lists: start and end with square bracket and items separated by commas.
 * To split list use |: 
 * Example: [cat,dog,bird] = [H|T].
 * Let's try:  data([cat,dog,bird], X, Y). data([cat], X, Y).  data([], X, Y). 
 */

data([H|T], H, T).