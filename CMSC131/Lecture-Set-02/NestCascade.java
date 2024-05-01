import java.util.Scanner;

public class NestCascade {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Choose a number from 1 to 4: ");
		int choice = scanner.nextInt();
		String nameOfValue;
        
		if (choice == 1) {
			nameOfValue = "ONE";
		} else {
			if (choice == 2) {
				nameOfValue = "TWO";
			} else {
				if (choice == 3) {
					nameOfValue = "THREE";
				} else {
					nameOfValue = "FOUR";
				}
			}
		}
		
		System.out.println("You chose " + nameOfValue);
        scanner.close();
	}
}
