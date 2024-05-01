import java.util.Scanner;

public class CascadingElse {
	public static void main(String args[]) {
		int inVal;
		Scanner inSc = new Scanner(System.in);

		inVal = inSc.nextInt();

		if (inVal < 0) {
			System.out.println("negative");
		} else if (inVal < 1) {
			System.out.println("zero");
		} else if (inVal < 10) {
			System.out.println("single digit positive");
		} else if (inVal < 100) {
			System.out.println("two digit positive");
		} else {
			System.out.println("large positive value");
		}

        inSc.close();
	}
}
