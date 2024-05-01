import java.util.Scanner;

public class IfElse {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter an integer: ");
		int i = sc.nextInt();

		if (i < 0) {
			System.out.println("That was a negative number!");
		} else {
			System.out.println("That was a non-negative number!");
		}
		
		System.out.println("The number was: " + i);
        sc.close();
	}
}
