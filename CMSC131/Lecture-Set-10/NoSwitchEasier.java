import java.util.Scanner;

public class NoSwitchEasier {
	/**
	 * Shows the use of the switch
	 * 
	 * Gives Positive Feedback for Grades
	 */
	public static void main(String[] args) {
		char letterGrade;
		Scanner scn = new Scanner(System.in);

		System.out.print("Give the letter grade earned:");
		String letterGradeLine = scn.next();
		letterGrade = letterGradeLine.charAt(0);
		System.out.print("You say you earned a(n) " + letterGrade);
		
		if (letterGrade == 'A') {
			System.out.println("GREAT JOB !!!");
			System.out.println("EXCELLENT WORK!!!");
		} else if (letterGrade == 'B') {
			System.out.println("great job!!!");		
		} else if (letterGrade == 'C') {
			System.out.println("good job");
		} else if (letterGrade == 'D') {
			System.out.println("good job if you tried"); 
		} else if (letterGrade =='F') {
			System.out.println("you can try harder next time");
		} else {
			System.out.println("The teacher must have been confused. " + " It is impossible to earn a " + letterGrade);
		}

        scn.close();
	}
}
