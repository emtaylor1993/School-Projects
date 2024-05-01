import java.util.Scanner;

public class Scanner2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("What is your favorite book? ");
		String book = s.nextLine();
		System.out.print("How much does it weigh (in lbs)? ");
		double weight = s.nextDouble();
		System.out.print("How many times have you read it? ");
		int timesRead = s.nextInt();
		
		System.out.println();
		System.out.println("Since you have read " + book + " " + timesRead + " times,");
		System.out.println("and " + book + " weighs " + weight + " pounds,");
		System.out.println("you have read " + timesRead * weight + " pounds worth of " + book + ".");

        s.close();
	}
}
