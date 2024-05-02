/*
 * We can have alternatives by provided several clauses to a predicate.
 * enjoyable(bike_ride). processed by first checking whether bike_ride is
 * free a query that fails. Therefore first clause of enjoyable will fail.
 * We try second clause.   
 */

enjoyable(X) :- free(X), onweekends(X).
enjoyable(X) :- lowcost(X), onweekends(X).
enjoyable(playing_tetris).

free(park).
onweekends(park).
onweekends(bike_ride).
lowcost(bike_ride).
