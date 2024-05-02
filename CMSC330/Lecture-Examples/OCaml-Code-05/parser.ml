(*----------------------------------------------------------
 
  arith : user-defined variant datatype for arithmetic expressions
 
*)
 
type arith =
     Num of int
   | Sum of arith * arith
   | Mult of arith * arith
 
(*----------------------------------------------------------
  function a_to_str : arith -> string
 
        converts arithmetic expression into a string 
*)
 
let rec a_to_str a = match a with
    Num n -> string_of_int n            (* from Pervasives *)
  | Sum (a1,a2) -> "(" ^ (a_to_str a1) ^ " + " ^ (a_to_str a2) ^ ")"
  | Mult (a1,a2) -> "(" ^ (a_to_str a1) ^ " * " ^ (a_to_str a2) ^ ")"
;;
 
(*----------------------------------------------------------
  function value : arith -> int
 
        finds value of arithmetic expression 
        always returns (Num n)
*)
 
let rec value a = match a with 
    Num n -> n
  | Sum (a1,a2) -> ( match (value a1, value a2) with
                        (n1,n2) -> (n1+n2) 
                   )
  | Mult (a1,a2) -> ( match (value a1, value a2) with
                        (n1,n2) -> (n1*n2) 
                   )
;;

(************************************************************************)
 
(* Scanner *)
 
exception IllegalExpression of string

type token =
    Tok_Num of char
    | Tok_Sum
    | Tok_Mult
    | Tok_LParen
    | Tok_RParen
    | Tok_END
 
#load "str.cma"

let re_num = Str.regexp "[0-9]" 	(* single digit number *)
let re_add = Str.regexp "+"
let re_mult = Str.regexp "*"
let re_lparen = Str.regexp "("
let re_rparen = Str.regexp ")"
 
(*----------------------------------------------------------
  function tokenize : string -> token list
 
        converts string into a list of tokens
*)
 
let tokenize str =
    let rec tok pos s =
        if pos >= String.length s then
            [Tok_END]
        else 
            if (Str.string_match re_num s pos) then
                let token = Str.matched_string s in
                    (Tok_Num token.[0])::(tok (pos+1) s)
            else if (Str.string_match re_add s pos) then
                Tok_Sum::(tok (pos+1) s)
            else if (Str.string_match re_mult s pos) then
                Tok_Mult::(tok (pos+1) s)
            else if (Str.string_match re_lparen s pos) then
                Tok_LParen::(tok (pos+1) s)
            else if (Str.string_match re_rparen s pos) then
                Tok_RParen::(tok (pos+1) s)
            else
                raise (IllegalExpression "tokenize")
    in
    tok 0 str
 
(*----------------------------------------------------------
  function tok_to_str : token -> string
 
        converts token into a string 
*)
 
let tok_to_str t = ( match t with
          Tok_Num v -> (Char.escaped v)
        | Tok_Sum -> "+"
        | Tok_Mult ->  "*"
        | Tok_LParen -> "("
        | Tok_RParen -> ")"
        | Tok_END -> "END"
    )

(************************************************************************)

(* Parser *)

(*----------------------------------------------------------

  function lookahead : token list -> (token * token list)

	Returns tuple of head of token list & tail of token list

*)

let lookahead tok_list = match tok_list with
    [] -> raise (IllegalExpression "lookahead")
    | (h::t) -> (h,t)

(*----------------------------------------------------------

  recursive descent parser

	Returns tuple of ast & token list for remainder of string

  Arithmetic expression grammar:

  [Basic grammar]
  E -> A Tok_Sum E | A
  A -> B Tok_Mult A | B
  B -> Tok_Num | Tok_LParen E Tok_RParen 

  FIRST(E) = { Tok_Num, Tok_LParen } 
  FIRST(A) = { Tok_Num, Tok_LParen } 
  FIRST(B) = { Tok_Num, Tok_LParen } 

  [Grammar rewritten to avoid conflicting FIRST sets]
  E -> A X 
  X -> Tok_Sum E | epsilon
  A -> B Y
  Y -> Tok_Mult A | epsilon
  B -> Tok_Num | Tok_LParen E Tok_RParen 

*)

let rec parse_E l = 
    let (a1,l1) = parse_A l in
    let (t,n) = lookahead l1 in
    match t with 
        Tok_Sum -> ( 		(* E -> A Tok_Sum E *)
        let (a2,l2) = (parse_E n) in
        (Sum (a1,a2),l2) 
        )
        | _ -> (a1,l1) 		(* E -> A *)
 
and parse_A l =
    let (a1,l1) = parse_B l in
    let (t,n) = lookahead l1 in
    match t with
        Tok_Mult -> ( 		(* A -> B Tok_Mult A *)
            let (a2,l2) = (parse_A n) in
            (Mult (a1,a2),l2) 
            )
            | _ -> (a1,l1)		(* A -> B *)

and parse_B l =
        let (t,n) = lookahead l in
	match t with
  		(* B -> Tok_Num *)
        Tok_Num c -> (Num (int_of_string (Char.escaped c)), n) 

		(* B -> Tok_LParen E Tok_RParen *)
        | Tok_LParen -> (
                let (a2,l2) = (parse_E n) in 
                let (t2,n2) = lookahead l2 in 
		if (t2 = Tok_RParen) then
			(a2,n2)
		else
        	raise (IllegalExpression "parse_B")
		)

        | _ -> raise (IllegalExpression "parse_B")

(*----------------------------------------------------------

  function eval_str : given string, parse string, build AST,
			evaluate value of AST

*)

let eval_str str =
	let tok_list = tokenize str in

	print_string "Input token list = " ;
	List.iter (fun x -> print_string (" " ^ (tok_to_str x))) tok_list ;
	print_endline "";

	let (a,t) = (parse_E tok_list) in 

	if t <> [Tok_END] then raise (IllegalExpression "parse_E") ;
	
	print_string "AST produced = " ;
	print_endline (a_to_str a) ;

	let (v) = (value a) in

	print_string "Value of AST = " ;
	print_int v ;
	print_endline "";

	v
;;

eval_str "1+2+3+4+5+6" ;;
eval_str "1*2*3*4*5*6" ;;
eval_str "1+2+3*4*5+6" ;;
eval_str "1+(2+3)*4*5+6" ;;
eval_str "1++2" ;;
eval_str "1+12" ;;
