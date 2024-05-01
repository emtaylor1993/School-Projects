public class OperationExpressions {

	/**
	 * Will show how assignment statements are
	 * also expressions.
	 */
	public static void main(String[] args) {
		int x = 5;
		char y = 'a';
		boolean z = true;
		
		System.out.print("x: ");
		System.out.println(x = 7);
		System.out.println("y: " + (y = 'x'));
		System.out.println("z: " + (z = false));
		System.out.println("z again: " + (z == false));
	}
}
