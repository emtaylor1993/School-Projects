public class IntegerWrapperExample {
	private static void doubleIt(int a) {
		a *= 2;
		System.out.println("in int doubleIt a = " + a);
	}
	
	private static void doubleIt(Integer a) {
		a *= 2;
		System.out.println("in Integer doubleIt a = " + a);
	}
	
	private static Integer sumThem(Integer a, Integer b) {
		return a + b;
	}
	
	public static void main(String[] args) {
		// Using the primitives
		System.out.print("ints: ");
		int a, b, c;
		a = 2; b = 10; c = 44;
		
		System.out.println("Values:");
		System.out.println(a + " " + b + " " + c);		
		
		if (c == (b * 4 + 2 * a)) {
			System.out.println("c == b * 4 + 2 * a");
		} else {
			System.out.println("not good");
		}
		
		// Using the wrapper
		System.out.println("Integers: ");
		Integer x = 3; 
		Integer y = new Integer(9); 
		Integer z;
		z = new Integer(87);
		System.out.println("Values:");
		System.out.println(x + " " + y + " " + z);
		if (z.equals(y * y + x * 2)) {
			System.out.println("z == y * y + x * 2");
		} else {
			System.out.println("not good");
		}
		
		// Arrays of Primitives
		int[] arrInt = {5, 4, 9, 2, 6, 3};
		for (int i = 0; i < arrInt.length; i++) {
			System.out.print(arrInt[i] + " ");
		}
		
		System.out.println();
		// Arrays of Wrapper Objects	
		Integer[] arrInteger = {new Integer(5),new Integer(4),new Integer(9), new Integer(2), 6, 3};
		
		for (int i = 0; i < arrInteger.length; i++) {
			System.out.print(arrInteger[i] + " ");
		}
		
		System.out.println();
		// Mixing the two
		Integer bigSum = 0;
		
		if (arrInt.length == arrInteger.length) {
			for (int i = 0; i < arrInt.length; i++){
				bigSum += (arrInt[i] + arrInteger[i]);
			}
		}
		
		System.out.println("big sum = " + bigSum);
		
		// Showing Method Calls
		int intActual = 7;
		Integer intWrapped = new Integer(77);
		
		System.out.println("they are " + intActual + " and " + intWrapped + " before the method calls");
		doubleIt(intActual);
		doubleIt(intWrapped);
		
		System.out.println("they are " + intActual + " and " + intWrapped + " after the method calls");
		System.out.println(intWrapped + " + " + intWrapped + " = " + sumThem(intWrapped,intWrapped));
		System.out.println(intActual + " + " + intWrapped + " = " + sumThem(intActual,intWrapped));
		System.out.println(14 + " + " + 8 + " = " + sumThem(14, 8));
	}
}
