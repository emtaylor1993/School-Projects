/* Recursion #2 */

gossip_reach(boss).

gossip_reach(Person):- 
       tells(Person,NextPerson),
       gossip_reach(NextPerson).


tells(rose,peter).
tells(peter,john).
tells(john,boss).
tells(tom,sarah).
tells(sarah,kyle).
