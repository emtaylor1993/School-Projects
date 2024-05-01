import java.util.Scanner;

public class AssignLetterPF1 {
	/**
	 * Shows the use of the ternary operator
	 */
	private static final double LOWEST_P = 60;

	public static void main(String[] args) {
		double score;
		Scanner scn = new Scanner(System.in);

		System.out.print("Give the score the student earned:");
		score = scn.nextDouble();
//		char letterEarned;
//		if (score >= LOWEST_P){
//			letterEarned = 'P';
//		} else {
//			letterEarned = 'F';
//		}

		char letterEarned = (score >= LOWEST_P ? 'P' : 'F');
		int i = 18;

		System.out.println("A student with a " + score + "% " + "will receive a " + letterEarned);
        scn.close();
	}
}
