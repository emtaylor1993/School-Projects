import java.util.Scanner;

public class SwitchHarder {
	/**
	 * Shows the use of the switch
	 * 
	 * It is a program that based on one of those
	 * compatibility/dating quizzes - it tells you
	 * if he is worth the work
	 */
	public static void main(String[] args) {
		int matches;
		Scanner scn = new Scanner(System.in);

		System.out.print("Give the score earned on the MatchQuiz:");
		matches = scn.nextInt();
		System.out.println("Based on the Number of Matches you reported,");
		System.out.println("I will determine your compatability.");

		switch(matches) {
			case 0:
				System.out.println("Run Away, don't walk");		
				break;
			case 1:
			case 2:
			case 3:
				System.out.println("Not Good - Give Up"); 
				break;
			case 4:
			case 5:
				System.out.println("Not Good");
				System.out.println("It would be lots of work");
				System.out.println("Make sure he is worth it");
				System.out.println("Before continuing");
				break;
			case 6:
				System.out.print("Not great but ...");
			case 7:
				System.out.println("You have something to work with here");
				System.out.println("Now get to work");
				break;
			case 8:
			case 9:
				if (matches == 8) {
					System.out.print("Nearly ");
				} else {
					System.out.print("Almost ");
				}
				
				System.out.println("Perfect");
				System.out.println("He'll still be some work");
				System.out.println("but he shows a lot of potential");
				break;
			case 10:
				System.out.println("You are a Perfect Match"); 
				break;
		}

        scn.close();
	}
}
