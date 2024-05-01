import java.util.Scanner;

public class Example3 {
	private static int MPG(int miles, int gallons) {
		int answer = miles / gallons;
		System.out.println("done with " + miles + " " + gallons);
		if (gallons == -1) {
			throw new NullPointerException("bad gallons == 1");
		} else if (gallons == -2) {
			throw new RuntimeException ("Really Bad");
		}
			
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner keyboardIn = new Scanner(System.in);

		while(true) {
			System.out.println("Enter milage: ");
			int miles = keyboardIn.nextInt();

			System.out.println("Enter gallons used: ");
			int gallons = keyboardIn.nextInt();
			
			int answer = 0;
			
			try {
				answer = MPG(miles, gallons);
				System.out.println ("you had " + answer + " MPG");
			} catch(ArithmeticException e) {
				System.out.println("You can't use 0 for gallons.  Try again?");
				keyboardIn.nextLine();
				String reply = keyboardIn.nextLine();
				reply = reply.trim();

				if (reply.charAt(0) == 'y' || reply.charAt(0) == 'Y') {
					continue;
				} else {
					break;
				}
			} finally {
				System.out.println("In finally");
			}
			
			System.out.println(answer);
		}
	}
}
