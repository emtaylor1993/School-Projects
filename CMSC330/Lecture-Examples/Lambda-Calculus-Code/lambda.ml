(* Lambda calculus encodings. See lectures slides for more explanation. *)

(* ================================================== *)
(* Booleans *)

type 'a mybool = 'a -> 'a -> 'a 
(* NB: OCaml forces the first two arguments to have the same type, but the lambda calculus would not/does not require it *)

let mytrue : 'a mybool = fun x -> fun y -> x
let myfalse : 'a mybool = fun x -> fun y -> y
let myif (a:'a mybool) (b:'a) (c:'a) : 'a = a b c
let mynot (b:'a mybool) : 'a mybool = fun x -> fun y -> b y x
let myand a b = fun x -> fun y -> b (a x y) y
let myor a b = fun x -> fun y -> b x (a x y)
;;

(* Examples *)
myif (mytrue) 1 2;; (* 1 *)
myif (myfalse) 1 2;; (* 2 *)
myif (mynot myfalse) 1 2;; (* 1 *)
myif (myand myfalse (myor mytrue myfalse)) 1 2;; (* 2 *)
myif (myand mytrue (myor mytrue myfalse)) 1 2;; (* 1 *)
myif (myor mytrue (mynot (myor mytrue myfalse))) 1 2;; (* 1 *)

(* ================================================== *)
(* Pairs *)

type 'a mypair = 'a mybool -> 'a
(* NB: Because we are building on OCaml booleans, both elements of the pair must have the same type. In the lambda calculus proper this is not required *)

let pairof (a:'a) (b:'a) : 'a mypair = fun x -> x a b
let fst (p:'a mypair) : 'a = p mytrue
let snd (p:'a mypair) : 'a = p myfalse
;;

(* Examples *)
fst (pairof 1 2);; (* 1 *)
snd (pairof 1 2);; (* 2 *)
fst (myif mytrue (pairof 1 2) (pairof 2 3));; (* 1 *)
fst (myif myfalse (pairof 1 2) (pairof 2 3));; (* 2 *)

(* ================================================== *)
(* Church numerals (natural numbers *)

type 'a mynat = ('a -> 'a) -> 'a -> 'a

let zero : 'a mynat = fun f -> fun x -> x
let one : 'a mynat = fun f -> fun x -> f x
let two : 'a mynat = fun f -> fun x -> f (f x)
let three : 'a mynat = fun f -> fun x -> f (f (f x))

let iszero n = n (fun x -> myfalse) mytrue

let succ (n:'a mynat) : 'a mynat = fun f -> fun x -> f (n f x)

let to_i (n:'a mynat) : int = n (fun x -> x+1) 0
let rec to_n (i:int) : 'a mynat = 
  match i with
      0 -> zero
    | _ -> succ (to_n (i-1))

let add m n = fun f -> fun x -> m f (n f x)
let add' m n = m succ n (* another way of implementing addition *)
let mult m n = fun f -> fun x -> m (n f) x
let mult' m n = m (add n) zero (* another way of implementing multiplication *)
let exp m n = n m (* exponentiation: returns  n^m. Step through its execution to see why! *)
;;

(* Examples *)
to_i (zero);; (* 0 *)
to_i (succ one);; (* 2 *)
to_i (add two (add two one));; (* 5 *)
to_i (mult two two);; (* 4 *)
to_i (mult (to_n 2) (to_n 10));; (* 20 *)
to_i (exp (to_n 10) two);; (* 100 *)
myif (iszero zero) 1 2;; (* 1 *)
myif (iszero (mult two zero)) 1 2;; (* 1 *)
myif (iszero (add zero one)) 1 2;; (* 2 *)

(* ================================================== *)
(* Fixpoints / Y combinator *)

(* Code taken from http://rosettacode.org/wiki/Y_combinator *)
(* For a long-winded explanation, see http://rosettacode.org/wiki/Y_combinator *)

type 'a mu = Roll of ('a mu -> 'a);;  (* this is needed to treat the same value as both having type 'a and type 'a -> 'b *)
let unroll (Roll x) = x;; 
 
let fix = fun f -> (fun x a -> f (unroll x x) a) (Roll (fun x a -> f (unroll x x) a));;
 
(* val unroll : 'a mu -> 'a mu -> 'a = <fun>
  val fix : (('a -> 'b) -> 'a -> 'b) -> 'a -> 'b = <fun>
*)

(* Examples *)

let fac f n = match n with
    0 -> 1
  | n -> n * f (n-1)
 
let fib f n = match n with
    0 -> 0
  | 1 -> 1
  | n -> f (n-1) + f (n-2)
  
fix fac 5;; (* 120 *)
fix fib 8;; (* 21 *)
