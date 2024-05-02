(* Defining new types *)
type shape =
    Rect of float * float     (* width * length *)
  | Circle of float;;         (* radius *)

(* Constructing instances *) 

let r = Rect (3.0, 4.0);;
let c = Circle 1.0;;

(* Defining functions on types -- with pattern matching *)

let area (s : shape) : float =
    match s with
    Rect(w,l) -> w *. l
  | Circle r  -> let pi = 3.14 in r *. r *. pi;;

area r;;
area c;;

(* Another example: numbers [from Hickey] *)

type number =
    Integer of int
  | Real of float
  | Zero;;

let one = Integer 1;;
let zero = Zero;;
let one_point_o = Real 1.0;;

(* Something like 'Real 1' will fail -- Try it *)

let add_numbers (a : number) (b : number) : number =
    match a,b with
    Integer i, Integer j -> Integer(i + j)
  | Real r, Real q -> Real(r +. q)
  | Zero, n | n, Zero -> n
  | Integer i, Real r | Real r, Integer i ->
        Real ((float_of_int i) +. r);;

(* The "or"s were ok because 
 *      (1) they made the same bindings, and
 *      (2) the bindings had the same type
 * whether it matched Zero,n or n,Zero, n was still the only
 * binding being made, and it was being bound to a 'number'
 *)

let i = Integer 3;;
let r = Real 4.8;;
add_numbers i r;;

let plus_pi = add_numbers (Real 3.14159);;      (* What is the type? *)
plus_pi (Integer 2);;

(* Polymorphic data types *)

type 'a our_list =
    Nil
  | Cons of 'a * 'a our_list;;

let rec len = function
    Nil -> 0
  | Cons (_, t) -> 1 + (len t);;

len (Cons (10, Cons (20, Cons (30, Nil))));;

let rec our_list_of_list (ls : 'a list) : 'a our_list = 
    match ls with
    [] -> Nil
  | h::t -> Cons(h, (our_list_of_list t));;

let ol = our_list_of_list [1;2;3;4];;

(* Exercise: Make a tree -- see the slides (and [Hickey]) for more details *)
