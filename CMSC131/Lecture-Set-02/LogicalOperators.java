import java.util.Scanner;

public class LogicalOperators {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter an integer from 1 to 10: ");
		int i = sc.nextInt();

		if (1 <= i && i <= 10) { // 1 <= i <= 10
			System.out.println("Good job!");
		} else {
			System.out.println("You didn't follow instructions!");
		}

        sc.close();
	}
}
