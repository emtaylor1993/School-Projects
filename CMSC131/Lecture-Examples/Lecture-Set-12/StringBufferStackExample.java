import java.util.Stack;

public class StringBufferStackExample {	
	public static void main(String[] args) {
		Stack<StringBuffer> stack = new Stack<StringBuffer>();
		
		stack.push(new StringBuffer("Hello"));
		stack.push(new StringBuffer("There"));
		stack.push(new StringBuffer("Everyone"));
		
		System.out.println("Top entry is: " + stack.peek());
		System.out.println("Here is toString: " + stack);
		
		for (StringBuffer s : stack) {
			char temp = s.charAt(0);
			s.replace(0, 1, "");
			s.append("" + temp + "ay");
		}
		
		System.out.println("Now pulling off all entries:  ");
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		
		System.out.println("Here is toString: " + stack);
	}
}