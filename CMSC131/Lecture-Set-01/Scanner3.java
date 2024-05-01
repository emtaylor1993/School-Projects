import java.util.Scanner;

public class Scanner3 {

	/**
	 * Shows other use of the scanner
	 */

	public static void main(String[] args) {
		int invalue1, invalue2;
		Scanner scn = new Scanner(System.in);

		System.out.print("Give two integer values:");
		invalue1 = scn.nextInt();
		invalue2 = scn.nextInt();
		System.out.println("You gave two that add to " + (invalue1 + invalue2));

		System.out.println();
		String s1, s2, s3;
		System.out.println("Enter a line of text that contains more than two words");
		s1 = scn.next();
		s2 = scn.next();
		s3 = scn.nextLine();
		System.out.println("The first scan gave us \"" + s1 + "\"");
		System.out.println("The second scan gave us \"" + s2 + "\"");
		System.out.println("The third scan gave us \""+ s3 + "\"");

		System.out.println("Type an integer:");
		invalue1 = scn.nextInt();
		scn.nextLine();
		System.out.println("Type your name");
		String s99 = scn.nextLine();
		System.out.println(invalue1 + " & " + s99);

		System.out.println("good-bye");
        scn.close();
	}
}
