import java.util.Scanner;

public class HardString {
	private static String addLastName(String myName) {
		Scanner sc = new Scanner(System.in);
		System.out.print(myName + ", what is your last name?");
		String inVal = sc.nextLine();
		myName += " " + inVal;
		System.out.print(" In Method appended " + inVal);
		System.out.println(" to get " + myName);
        sc.close();
		return myName;
	}
	
	public static void main(String[] args) {
		String name1 = new String("Jan");
		String name2 = name1;
		System.out.println("String names before = " + name1 + "/" + name2);
		name1 = addLastName(name1);
		System.out.println("String names after = " + name1 + "/" + name2);
	}
}
