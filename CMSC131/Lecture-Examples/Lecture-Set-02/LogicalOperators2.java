import java.util.Scanner;

public class LogicalOperators2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("What is your favorite animal? ");
		String animal = sc.next();
		System.out.print("How many " + animal + "s do you own? ");
		int numberOwned = sc.nextInt();

		if ((animal.equals("dog") || animal.equals("cat") || animal.equals("Dog") || animal.equals("Cat")) && (numberOwned > 0 && numberOwned < 4)) {
			System.out.println("You are a typical " +  animal + " owner.");
		} else {
			System.out.println("That's unusual!");
		}

        sc.close();
	}
}
