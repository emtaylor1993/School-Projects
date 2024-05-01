import java.util.Scanner;

/**
 * Shows some string operations
 */

public class Strings {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Type a three letter name: ");
		String s1 = sc.nextLine();
		System.out.print("Type a different three letter name: ");
		String s2 = sc.nextLine();
		
		System.out.println("s1 = '" + s1 + "'; s2 = '" + s2 + "'");
		System.out.print("Using .equals to compare " + s1 + " and " + s2 + ": ");
		System.out.println(s1.equals(s2));
		System.out.print("Using == to compare " + s1 + " and " + s2 + ": ");
		System.out.println(s1 == s2);
		System.out.print("Using == to compare lengths of " + s1 + " and " + s2 + ": ");
		System.out.println(s1.length() == s2.length());

		System.out.print("Type the first 3 letter name again:");
		s2 = sc.nextLine();		
		System.out.println("s1 = '"+s1+"'; s2 =  '"+ s2+"'");
		System.out.print("Using .equals to compare " + s1 + " and " + s2 + ": ");
		System.out.println(s1.equals(s2));
		System.out.print("Using == to compare " + s1 + " and " + s2 + ": ");
		System.out.println(s1 == s2);
		System.out.print("Using == to compare lengths of " + s1 + " and " + s2 + ": ");
		System.out.println(s1.length() == s2.length());

        sc.close();
    }
}