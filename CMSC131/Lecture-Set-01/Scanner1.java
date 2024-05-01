import java.util.Scanner;

public class Scanner1 {

	/**
	 * Shows basic use of the scanner
	 */
	
	public static void main(String[] args) {
		Scanner keyboardInput = new Scanner(System.in);
		int first, second, sum;
		double average;
		System.out.print("Type your two favorite integers: ");
		first = keyboardInput.nextInt();
		second = keyboardInput.nextInt();
		sum = first + second;
		average = sum / 2.0;
		System.out.println("The first you typed = " + first);
		System.out.println("The second you typed = " + second);
		System.out.println("their sum = " + sum);
		System.out.println("their average = " + average);
        keyboardInput.close();
	}
}