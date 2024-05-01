import java.util.Scanner;

public class IfElseBlock {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter an integer: ");
		int i = sc.nextInt();
		
		if (i < 0) {
			System.out.println("That was a negative number!");
			System.out.println("I prefer positive ones, so I'll fix it...");
			i = -i;
		} else {
			System.out.println("That was a positive number!");
			System.out.println("That makes me happy.");
		}
		
		System.out.println("The number was " + i);
        sc.close();
	}
}
