public class ArrayExample4 {
	public static void triple(int y) {
		y *= 3;
	}
	
	public static void triple(int[] a) {
		for (int ind = 0; ind < a.length; ind++) {
			a[ind] *= 3;
		}
	}
	
	public static void main(String[] args) {
		final int size = 3;
		int y = 5;
		int[] a = new int[size];
		
		for (int ind = 0; ind < a.length; ind++) {
			a[ind] = 5;
		}
		
		triple(y);
		triple(a);
		System.out.println("length = " + a.length);
		System.out.println("After triple, y is " + y);
		System.out.println("After triple, a[2] is " + a[2]);	
		triple(a[2]);
		System.out.println("After triple, a[2] is " + a[2]);	
	}
}