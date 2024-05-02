
(* print int on separate line *)
let prt_int x = print_endline (string_of_int x)
;;

let string_of_int_list l =
    let rec string_of_int_elements l = match l with
          [] -> ""
        | (h::[]) -> string_of_int h
        | (h::t) -> string_of_int h ^ ";" ^ string_of_int_elements t
    in "[" ^ string_of_int_elements l ^ "]"
;;

(* print int list on separate line *)
let prt_int_list l = print_endline (string_of_int_list l)
;;

(* fold from int list -> int *)
let rec fold_to_int f a l = 
	print_string "fold a=";
	print_int a ;
	print_string ", l=";
	prt_int_list l ;
	match l with
	[] -> a
	| (h::t) -> fold_to_int f (f a h) t
	;;

(* fold from int list -> int list *)
let rec fold_to_int_list f a l = 
	print_string "fold a=";
	prt_int_list a ;
	print_string "     l=";
	prt_int_list l ;
	match l with
	[] -> a
	| (h::t) -> fold_to_int_list f (f a h) t
	;;

(* fold from int list -> (int * int) *)
let rec fold_to_int_pair f a l = 
	print_string "fold a=(";
	match a with x,y ->
	(print_int x ; print_string ","; print_int y) ;
	print_string "), l=";
	prt_int_list l ;
	match l with
	[] -> a
	| (h::t) -> fold_to_int_pair f (f a h) t
	;;

(* return number of elements in int list *)
let count lst = 
	fold_to_int (fun a h -> a+1) 0 lst
	;;

print_endline " ** count [1;2] ** " ;;
prt_int (count [1;2]) ;;

print_endline " ** count [1;2;3;4;5;6] **" ;;
prt_int (count [1;2;3;4;5;6]) ;;

(* return sum of elements in int list *)
let sum lst = 
	fold_to_int (fun a h -> a+h) 0 lst
	;;

print_endline " ** sum [1;2] **" ;;
prt_int (sum [1;2]) ;;

print_endline " ** sum [1;2;3;4;5;6] **" ;;
prt_int (sum [1;2;3;4;5;6]) ;;

(* return reversed int list *)
let reverse lst = 
	fold_to_int_list (fun a h -> h::a) [] lst
	;;
	
print_endline " ** reverse [1;2] **" ;;
prt_int_list (reverse [1;2]) ;;

print_endline " ** reverse [1;2;3;4;5;6] **" ;;
prt_int_list (reverse [1;2;3;4;5;6]) ;;

(* return list of squares of int list *)
let squares lst = 
	reverse ( fold_to_int_list (fun a h -> (h*h)::a) [] lst )
	;;
	
print_endline " ** squares [1;2] **" ;;
prt_int_list (squares [1;2]) ;;

print_endline " ** squares [1;2;3;4;5;6] **" ;;
prt_int_list (squares [1;2;3;4;5;6]) ;;

(* return min & max of elements in int list *)
let min_max_elem lst =
	let smaller x y = if x < y then x else y in
	let larger x y = if x > y then x else y in
	fold_to_int_pair (fun (a,b) x -> (smaller a x, larger b x)) (1000,0) lst
	;;

let print_int_tuple (x,y) =
	print_string "Min=" ;
	print_int x ;
	print_string " Max=" ;
	print_int y ;
	print_endline "";;
	
print_endline " ** min_max [1] **" ;;
print_int_tuple (min_max_elem [1]) ;;

print_endline " ** min_max [1;2;3;4;5;6;7;8;9] **" ;;
print_int_tuple (min_max_elem [1;2;3;4;5;6;7;8;9]) ;;

print_endline " ** min_max [2;1;3;6;5;4;9;8;7] **" ;;
print_int_tuple (min_max_elem [2;1;3;6;5;4;9;8;7]) ;;
