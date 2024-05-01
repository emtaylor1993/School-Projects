/* Shows an if/else/if structure
 * Change the structure without changing the meaning
 * for comparison purposes */

import java.util.Scanner;

public class IfElseVariations {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter an integer: ");
		int i = sc.nextInt();

		if (i < 0) {
			System.out.println("I don't like negative numbers!");
			if (i < -100) {
				System.out.println("Also... that one is REALLY negative!");
			}
		} else {
			if (i < 100) {
				System.out.println("That's a small one.");
			} else {
				System.out.println("That's a nice big number!");
			}
		}

        sc.close();
	}
}
