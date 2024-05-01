import java.util.Stack;

public class StackExampleComplete {
	public static void doStringExample() {
		Stack<String> stack = new Stack<String>();
		
		stack.push("Hello");
		stack.push("There");
		stack.push("Everyone");
		
		System.out.println("Top entry is: " + stack.peek());
		System.out.println("Here is toString: " + stack);
		System.out.println("Now pulling off all entries:  ");
		
		while (!stack.isEmpty()) {
			System.out.print("removed: " + stack.pop());
			System.out.println("; Current Stack:" + stack);
		}
	}
	
	public static void doCatExample() {
		Stack<Cat> stack = new Stack<Cat>();
		
		stack.push(new Cat("Hello"));
		stack.push(new Cat("There"));
		stack.push(new Cat ("Everyone"));
		
		System.out.println("Top entry is: " + stack.peek());
		System.out.println("Here is toString: " + stack);
		System.out.println("Now pulling off all entries:  ");
		
		while (!stack.isEmpty()) {
			System.out.print("removed: " + stack.pop());
			System.out.println(";\t Current Stack:" + stack);
		}
	}
	
	public static void doIntExample() {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(new Integer(5));
		stack.push(6);
		stack.push(3);
		
		System.out.println("Top entry is: " + stack.peek());
		System.out.println("Here is toString: " + stack);
		System.out.println("Now pulling off all entries:  ");
		Integer sum = 0;
		
		while (!stack.isEmpty()) {
			Integer temp = stack.pop();
			System.out.print("removed: " + temp);
			sum += temp;
			System.out.println(";\t Current Stack:" + stack);
		}
		
		System.out.println("Sum = " + sum);
	}
	
	public static void main(String[] args) {
		doStringExample();
		System.out.println("---------------------");
		doCatExample();
		System.out.println("---------------------");
		doIntExample();
		System.out.println("---------------------");
	}
}
