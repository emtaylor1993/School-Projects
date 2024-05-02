(*----------------------------------------------------------

  arith : user-defined variant datatype for arithmetic expressions

*)

type arith =
     Unknown
   | Num of int
   | Var of char
   | Sum of arith * arith

(*----------------------------------------------------------
  function a_to_str : arith -> string. 

	converts arithmetic expression into a string 
*)

let rec a_to_str a = match a with
    Unknown -> "?"
  | Num n -> string_of_int n		(* from Pervasives *)
  | Var x -> Char.escaped x		(* from Char *)
  | Sum (a1,a2) -> "(" ^ (a_to_str a1) ^ " + " ^ (a_to_str a2) ^ ")"
;;

(*----------------------------------------------------------
  function value : arith -> arith

	finds value of arithmetic expression where possible

*)

let rec value a = match a with 
    Unknown -> Unknown
  | Num n -> Num n
  | Var x -> Unknown
  | Sum (a1,a2) -> ( match (value a1, value a2) with
			(Num n1,Num n2) -> Num (n1+n2) 
			| _ -> Unknown 
		   )
;;

(*----------------------------------------------------------
  function vars_in : expr -> char list. 

	takes an arith expression and returns a list of the names of the 
	variables in the expression (duplicates allowed). 
*)

let rec vars_in x = match x with
    Unknown -> []
  | Num n -> []
  | Var x -> [Char.escaped x]
  | Sum (a1,a2) -> (vars_in a1) @ (vars_in a2)
;;

(*----------------------------------------------------------
   print a list of strings
*)

let string_of_str_list l =
    let rec string_of_str_elements l = match l with
          [] -> ""
        | (h::[]) -> h
        | (h::t) -> h ^ ";" ^ string_of_str_elements t
    in "[" ^ string_of_str_elements l ^ "]"
;;

let prt_str_list l = print_endline (string_of_str_list l)
;;

(*----------------------------------------------------------
    test cases
*)

let a1 = Unknown ;;
let a2 = Num 1 ;;
let a3 = Num 2 ;;
let a4 = Var 'a' ;;
let a5 = Sum (a2,a3) ;;
let a6 = Sum (a4,a1) ;;
let a7 = Sum (a5,a2) ;;
let a8 = Sum (a7,a5) ;;

print_endline (a_to_str a1) ;;
print_endline (a_to_str a2) ;;
print_endline (a_to_str a3) ;;
print_endline (a_to_str a4) ;;
print_endline (a_to_str a5) ;;

print_endline (a_to_str (value a1)) ;;
print_endline (a_to_str (value a2)) ;;
print_endline (a_to_str (value a3)) ;;
print_endline (a_to_str (value a4)) ;;
print_endline (a_to_str (value a5)) ;;
print_endline (a_to_str (value a6)) ;;
print_endline (a_to_str (value a7)) ;;
print_endline (a_to_str (value a8)) ;;

prt_str_list (vars_in a4) ;;
prt_str_list (vars_in a5) ;;
prt_str_list (vars_in a6) ;;
