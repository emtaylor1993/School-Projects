import java.util.Scanner;

public class Initialization2 {
	public static void main(String[] args) {
		int x;
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();

		if (s.equals("dog")) {
			x = 10;
		} else if (!s.equals("dog")) {
			x = 12;
		}
			
		// Uncomment the next line to see the error
		// System.out.println("x is " + x);

        scanner.close();
	} 
}
