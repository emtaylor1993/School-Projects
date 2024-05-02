let rec fold f a l = match l with
	[] -> a
	| (h::t) -> fold f (f a h) t
	;;

(* return number of elements in 'a list *)
let count lst = 
	fold (fun a h -> a+1) 0 lst
	;;

print_int (count [[1];[2]]) ;;
print_endline "";;
print_int (count [[1;2];[3;4;5];[6]]) ;;
print_endline "";;

(* return number of elements in 'a list list *)
let count_elem lst = 
	fold (fun a h -> a+(count h)) 0 lst
	;;
	
print_int (count_elem [[1];[2]]) ;;
print_endline "";;
print_int (count_elem [[1;2];[3;4;5];[6]]) ;;
print_endline "";;

(* return min & max of elements in int list *)
let min_max_elem lst =
	let smaller x y = if x < y then x else y in
	let larger x y = if x > y then x else y in
	fold (fun (a,b) x -> (smaller a x, larger b x)) (1000,0) lst
	;;

let print_int_tuple (x,y) =
	print_string "Min=" ;
	print_int x ;
	print_string " Max=" ;
	print_int y ;
	print_endline "";;
	
print_int_tuple (min_max_elem [1]) ;;
print_int_tuple (min_max_elem [1;2;3;4;5;6;7;8;9]) ;;
print_int_tuple (min_max_elem [2;1;3;6;5;4;9;8;7]) ;;
