public class StringExample {
	/*
	 * To show use of the string API
	 */
	public static void main(String[] args) {
		String s = new String("CAT");
		String t = new String("cat");
		String u = new String("car");

		int i = s.length();
		System.out.println("i = " + i);

		boolean a = s.equals(t);				// false
		boolean b = s.equalsIgnoreCase(t);		// true
		System.out.println("a = " + a + "; b = " + b);

		if (t.compareTo(u) != 0) { 				// Some negative number
			System.out.println("Not the same by compareTo");
			System.out.println(s.compareTo(t));
		} else {
			System.out.println("Same by compareTo");
		}
		
		if (t.compareToIgnoreCase(u) != 0) {	// 0
			System.out.println("Not the same by compareToIgnoreCase");
		} else {
			System.out.println("Same by compareToIgnoreCase");
		}
		
		char c0 = s.charAt(0);					// ‘C’
		char c1 = s.charAt(1);					// ‘A’
		System.out.println("*" + c0 + "*" + c1 + "*" + s.charAt(2) + "*");
		
		String x = t.toLowerCase();  			// Creates a NEW String
		String y = s.toUpperCase();  			// Ditto
		System.out.println("new strings x=" + x + "; y=" + y);
		
		String z = x;
		x += y;
		System.out.println(x + " and " + z);
	}
}
