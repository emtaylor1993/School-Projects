import java.util.Scanner;

public class SwitchEasier {
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

		switch(letterGrade) {
			case 'A':
				System.out.println("GREAT JOB !!!");
				System.out.println("EXCELLENT WORK!!!");
				break;
			case 'B':
				System.out.println("great job!!!");		
				break;	
			case 'C':
				System.out.println("good job");
				break;
			case 'D':
				System.out.println("good job if you tried"); 
				break;
			case 'F':
				System.out.println("you can try harder next time");
				break;
			default:
				System.out.println("The teacher must have been confused. " + " It is impossible to earn a " + letterGrade);
		}

        scn.close();
	}
}
