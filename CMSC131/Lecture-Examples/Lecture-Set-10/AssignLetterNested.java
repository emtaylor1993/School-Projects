import java.util.Scanner;

public class AssignLetterNested {
	/**
	 * Shows the use of the ternary operator
	 */
	private static final double LOWEST_D = 60;
	private static final double LOWEST_P = 70;
	private static final double LOWEST_A = 90;

	public static void main(String[] args) {
		double score;
		Scanner scn = new Scanner(System.in);

		System.out.print("Give the score the student earned:");
		score = scn.nextDouble();
		char grade;
		grade = (score >= LOWEST_P ? (score >= LOWEST_A ? 'A' : 'P') : (score >= LOWEST_D ? 'D' : 'F'));
		
		if (score >= LOWEST_P) {
			if (score >= LOWEST_A) {
				grade='A';
			} else {
				grade='P';
			}
		} else {
			if (score >= LOWEST_D) {
				grade = 'D';
			} else {
				grade = 'F';
			}
		}
		
		System.out.println("A student with a " + score + "% " + "will receive a " + grade);
        scn.close();
	}
}
