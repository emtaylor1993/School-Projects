import java.util.Scanner;

public class StringExample {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name = "";
		System.out.println ("Enter name: ");
		name = sc.next();
		
		if (name.equals ("John Doe")) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}

        sc.close();
	}
}
