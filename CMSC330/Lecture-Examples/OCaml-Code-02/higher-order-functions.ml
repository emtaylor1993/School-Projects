(* Functional programming => Functions are higher-order entities *)

let rec map fn ls = 
    match ls with
    [] -> []
  | h::t -> (fn h) :: (map fn t);;     (* What will the type be? *)

let double x = 2*x;;
map double [1;2;3];;

let cons x ls = x::ls;;

map (cons 0) [[1;2]; [3;4]];;

let rec fold fn a ls =
    match ls with
    [] -> a
  | h::t -> fold fn (fn a h) t;;       (* What will the type be? *)
    
let add a x = a+x;;
fold add 0 [1;2;3];;

(* fold and map are fundamental; many functions can be built using them *)

(* Let's try reversing a list using fold:
    * what method would you need? 
    * What is the accumulator?
*)

let reverse ls = 
    let prepend a x = x :: a in
    fold prepend [] ls;;

reverse [1;2;3;4];;
