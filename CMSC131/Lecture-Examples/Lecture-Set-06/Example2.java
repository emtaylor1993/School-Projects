import java.util.Scanner;

public class Example2 {
	private static int MPG(int miles, int gallons) {
		int answer;
		System.out.println("before calculation");

		try {
			System.out.println("before calculation");
			answer = miles / gallons;

			if (gallons < 0) {
				throw new RuntimeException("negative gallons is strange");
			}
			
			System.out.println("answer = " + answer);
		} catch (ArithmeticException e) {
			System.out.println("The error we got was: " + e.getMessage());
			answer = -1;
		} catch (RuntimeException e){
			System.out.println("HERE error we got was: " + e.getMessage());
			answer = -5;
		}
		
		System.out.println("after Calculation");
		return answer;
	}

	public static void main(String[] args) {
		Scanner keyboardIn = new Scanner(System.in);

		while (true) {
			System.out.println("Enter milage: ");
			int miles = keyboardIn.nextInt();

			System.out.println("Enter gallons used: ");
			int gallons = keyboardIn.nextInt();

			int answer = MPG(miles, gallons);
			System.out.println(answer);
		}
	}
}
