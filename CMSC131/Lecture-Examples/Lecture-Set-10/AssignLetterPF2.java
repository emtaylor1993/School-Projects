import java.util.Scanner;

public class AssignLetterPF2 {
	/**
	 * Shows the use of the ternary operator
	 */
	private static final double LOWEST_P = 60;
	
	public static void main(String[] args) {
		double score;
		Scanner scn = new Scanner(System.in);

		System.out.print("Give the score the student earned:");
		score = scn.nextDouble();

		System.out.println("A student with a " + score + "% " + "will receive a \n" + (score >= LOWEST_P ? "P" + "good job" : "F"));
        scn.close();
	}
}