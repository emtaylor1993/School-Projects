(* Defining and calling functions *)

let next x = x + 1;;        (* defining *)
next 3;;                    (* calling on one argument *)

let plus x y = x + y;;
plus 3 4;;                  (* also calling on one argument; more later *)

(* let there be... local variables *)
let area r =
    let pi = 3.14 in
    pi *. r *. r;;          

area (1.0);;

(* let there be.. even more local variables *)
let area d =
    let pi = 3.14 in
    let r = d /. 2.0 in
    pi *. r *. r           (* another 'let' comes so OCaml infers the ;; *)

let ad = area(2.0);;

(* More ways to define functions *)

let next = fun x -> x + 1;;

let plus = fun x y -> x + y;;  (* what does that type mean? *)

(* 
 * val plus : int -> int -> int = <fun>
 *    is the same as
 * val plus : int -> (int -> int) = fun
 *     x -> y : "Function that takes a value of type x and returns a value of type y"
 *     plus is "a function that takes as input an int and returns a function..."
 *)

(* So we could rewrite this *)

let plus = fun x -> (fun y -> x + y);;
