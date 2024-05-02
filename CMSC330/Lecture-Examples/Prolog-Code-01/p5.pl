/*
 * 1. So far: facts and how to query them.
 * 2. Rules -> allow us to make conditional statements.
      Format: Head :- Body
 * 3. Rules have clauses that provide different choices about
      how to perform inference.
   4. Below rule can be read as: "For a given X, X is mortal if X is human" or 
      "To prove goal that X is mortal, prove subgoal that X is human"
   5. Let's try: mortal(napoleon). mortal(X).
   6. trace.  Let's you step through goal's execution
   7. notrace. to turn it off
 */

mortal(X) :- human(X).
human(napoleon).
