(* Tuples *)

(* OCaml functions take only _one argument_! *)

let plus (x,y) = x+y;;

(* is actually... *)

let plus t = 
    match t with
    (x,y) -> x + y;;

plus (3,4);;

(* What it took was a "tuple" *)

(* Constructing tuples *)

let t = (1,2,3,4,5)
let u = (1, 2.0, "heterogeneous!", ["but lists"; "are homogeneous"])

let list_of_tuples = [(1,1); (2,3); (5,8); (13,21)];;

(* What are the types of the following? *)

(1,2)
(1,2,3)
(1, 2, "hi")
([1;2], [])

(* Lists of tuples; which of these does OCaml accept? *)

[(1,1); (2,3); (5,8); (13,21)]
[(1.0, 2.0); (1, 2)]
[(1,2); (1,2,3)]

[(1); 2]

(* Some examples *)

let sum ((a, b), c) = (a+c, b+c);;
sum( (1,2), 3);;


let f ls = 
    match ls with x::(_::y) -> (x,y);;

(* What does this return: *)
f [1;2;3;4];;

(* More examples *)

let rec zip ls ls' =
    match (ls, ls') with
    ([], []) -> []
  | (h1::t1, h2::t2) -> (h1,h2)::(zip t1 t2)
  | (_,_) -> failwith "not the same length";;

(*
 * What will the type of this be?
 * What can we infer about the types of ls and ls'?
 *)

zip ["a1"; "a2"] ["b1"; "b2"];;
zip [10; 20] ["b1"; "b2"];;
