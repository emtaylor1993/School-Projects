import java.util.Scanner;

public class ScopeRules {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size;
		System.out.println("Give a positive integer for the size: ");
		size = sc.nextInt();
		
		if (size > 10) {
			int smallerSize = 0;
			System.out.println("Give smaller integer");
			smallerSize = sc.nextInt();
			size = size - 10;
		}
		
		// Uncomment the next line to see the error
		// System.out.println("size = "+largerSize);
		for (int count = 0; count < size; count = count + 1) {
			System.out.print("*");
		}
		
		System.out.println();
		int largerSize = size + 10;
		// System.out.println(size+" + " +smallerSize + "+" + largerSize);
        sc.close();
	}
}
