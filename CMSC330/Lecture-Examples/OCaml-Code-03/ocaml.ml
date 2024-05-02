(* returns the length of l *)
let rec length l =
   match l with
      [] -> 0
    | (_::t) -> 1 + (length t)
;;

(* returns the sum of all elements in l *)
let rec sum l =
   match l with
      [] -> 0
    | (h::t) -> h + (sum t)
;;

(* is there an element that equals x in l? *)
let rec contain (x,l) =
   match l with
      [] -> false
    | (h::t) -> (h = x) or (contain (x,t))
;;

(* count number of occurrences of x in l *)
let rec count (x,l) =
   match l with
      [] -> 0
    | (h::t) ->
         if (x = h) then 1 + (count (x,t))
         else (count (x,t))
;;

(* get the last element of l *)
let rec last l =
   match l with
      [x] -> x
    | (_::t) -> (last t)
;;

(* replace all occurrences of x with y in l *)
let rec replace (x,y,l) =
   match l with
      [] -> []
    | (h::t) ->
         if (h = x) then (y::(replace (x,y,t)))
         else (h::(replace (x,y,t)))
;;

(* add two numbers - tuple version *)
let add (a,b) = a + b;;

(* add two numbers - curried version *)
let add2 a b = a + b;;

(* reverse a list -- DOESN'T WORK!!! *)
let rec reverse l = match l with
    [] -> []
  | h::t -> (reverse t)::h
;;

(* reverse a list w/ helper function -- WORKS!!! *)
let reverse l = 
    let rec reverse_helper l r = match l with
        [] -> r
      | h::t -> (reverse_helper t (h::r))
    in (reverse_helper l [])
;;

(* Input: Tuple of two lists l1 and l2
   Output: Tuple of two lists l1' and l2',
    where l1=l1' and l2=l2' except for the first
    element, which is exchanged between l1' and l2'.
    Notice that, if l1=[] or l2=[], then it just
    returns (l1,l2)*)

let exchangeFirst (l1,l2) =
   match l1 with
      [] -> (l1,l2)
    | h1::t1 -> match l2 with
         [] -> (l1,l2)
       | h2::t2 -> ((h2::t1), (h1::t2))
;;

let exchangeFirst2 (l1,l2) =
   match (l1,l2) with
      ([],_) | (_,[]) -> (l1,l2)
    | ((h1::t1),(h2::t2)) -> ((h2::t1), (h1::t2))
;;

(* returns a list with the elements of l at even indices,
   considering the first element index 1 *)
let rec even l =
   match l with
      [] -> []
    | [_] -> []
    | (_::e::t) -> e::(even t)
;;

(* same as above, for odd indices *)
let rec odd l =
   match l with
      [] -> []
    | [x] -> [x]
    | (o::_::t) -> o::(odd t)
;;

(* is n even? *)
let rec even n =
   if (n=0) then true
   else odd (n-1)
   
(* is n odd? *)
and odd n =
   if (n=0) then false
   else even (n-1)
;;
