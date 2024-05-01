import java.util.Stack;

public class StackExample {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();

		stack.push("Hello");
		stack.push("There");
		stack.push("Everyone");
		
		System.out.println("Top entry is: " + stack.peek());
		System.out.println("Here is toString: " + stack);
		
		for (String s : stack) {
			s += "Jan";
		}
		
		for (String s : stack) {
			System.out.println(s);
		}
		
		System.out.println("Now pulling off all entries:  ");

		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		
		System.out.println("Here is toString: " + stack);
	}
}
