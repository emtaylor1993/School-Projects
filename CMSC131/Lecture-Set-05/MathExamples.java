public class MathExamples {
	/**
	 * To demonstrate some of the things in the Math class
	 * which are automatically included since they are in the
	 * Java.lang package
	 */
	public static void main(String[] args) {
		int val1 = 7, val2 = 9;
		System.out.println("PI = " + Math.PI);
		System.out.println("E = " + Math.E);		
		System.out.println("square root (" + val1 + ") = " + Math.sqrt(val1));
		System.out.println("square root (" + val2 + ") = " + Math.sqrt(val2));
		System.out.println(val1 + "^3 = " + Math.pow(val1, 3));
		System.out.println(val2 + "^3 = " + Math.pow(val2, 3));
		System.out.println("random value 1 = " + Math.random());
		System.out.println("random value 2 = " + Math.random());
		int myInt = (int)(Math.random() * 10 + 1);
		System.out.println("random int = " + myInt);
	}
}
