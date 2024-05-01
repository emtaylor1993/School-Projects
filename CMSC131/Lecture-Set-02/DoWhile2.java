import java.util.Scanner;

public class DoWhile2 {
	public static void main(String[] args) {
		int answer = 1;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.print("Enter an integer from 1 to 10: ");
			answer = sc.nextInt();
		} while (answer >= 1 || answer <= 10);
		
		System.out.println("Good job.");
        sc.close();
	}
}
