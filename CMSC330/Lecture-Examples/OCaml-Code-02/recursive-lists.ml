let rec max x =
  match x with
    | [] -> failwith "failure"
    | [y] -> y
    | (h::t) -> 
      let m = max t in
      if h > m then h else m

let rec length x =
  match x with
      [] -> 0
    | _::t -> 1+(length t)

let kind_of x =
  match x with
      [] -> "is empty"
    | [_;_;_] -> "has three strings"
    | _ -> "foo"

(* is equivalent to
*   if x = [] then "is empty"
*   else if 
*       (List.tl x) != [] &&
* 	 (List.tl (List.tl x)) != []  &&
* 	 (List.tl (List.tl (List.tl x))) = [] then
*     "has three strings"
*   else "foo"
*)
let rec sum (ls : int list) : int =
    match ls with
    []   -> 0
  | h::t -> h + (sum t);

let rec sum ls =
    match ls with
    [] -> 0
  | h::t -> h + (sum t);;

(* Reversing a list *)

(*
 * What we'd like to do is something like
 *        [] -> []
 *      | h::t -> (reverse t) :: h
 * But :: is of the type 'a -> 'a list -> 'a list
 *)

(* So we'll have to write our own function append: *)

let rec append_item ls elem =
    match ls with
    [] -> [elem]
  | h::t -> 
          let t' = append_item t elem in
          h :: t';;

append_item [1;2] 3;;        (* What is the trace of this? *)

(* A quick divergence: recall the '@' operator: let's write our own *)

let rec append_list ls ls' =
    match ls with
    [] -> ls'
  | h :: t -> h :: (append_list t ls');;

(* Now back to our 'reverse' function... *) 

let rec reverse ls =
    match ls with
    [] -> []
  | h::t -> (append_item (reverse t) h);;

(* Of course, we could have scoped append differently: *)

let rec reverse ls =
    let rec append_item ls elem =
        match ls with
          [] -> [elem]
        | h::t -> h :: (append_item t elem)
    in
    match ls with
    [] -> []
  | h::t -> (append_item (reverse t) h);;

(* Making recursion efficient *)

let rec fact n =
    match n with
    0 -> 1
  | k -> k * (fact (k-1));;

let rec fact n =
    let rec fact' a m =
        match m with
        0 -> a
      | k -> fact' (a*m) (m-1)

    in
    fact' 1 n;;

let rec mklist (n : int) : int list =
    if n = 0 then []
    else n :: (mklist (n-1));;

mklist 10;;         (* What will this return? *)
mklist 1000000;;    (* What will this return? *)

let mklist (n : int) : int list =
    let rec mklist_tail (m : int) (n : int) (a : int list) : int list =
        if m > n then a
        else (mklist_tail (m+1) n (m :: a))  (* => Tail recursion *)
    in
    mklist_tail 1 n [];;

mklist 1000000;;

(* Tail recursion means that, if we are making a recursive call, then that
 * is the last thing we are doing in the function.  More specifically,
 * the current function returns precisely what the recursive call
 * returns.  This way, we don't have to keep state in the current call,
 * so our stack doesn't overflow.
 *)
