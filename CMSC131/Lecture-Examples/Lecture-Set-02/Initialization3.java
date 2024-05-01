import java.util.Scanner;

public class Initialization3 {
	public static void main(String[] args) {
		int x;
		boolean foundDog = false;   // This is an example of a "flag"
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();

		if (s.equals("dog")) {
			x = 10;
			foundDog = true;
		}

		if (!foundDog) {
			x = 12;
		}
		
		// Uncomment the next line to see the error		
		// System.out.println("x is " + x);

        scanner.close();
	}
}
