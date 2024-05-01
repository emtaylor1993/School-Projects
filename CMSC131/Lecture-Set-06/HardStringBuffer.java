import java.util.Scanner;

public class HardStringBuffer {
	private static void addLastName(StringBuffer myName) {
		Scanner sc = new Scanner(System.in);
		System.out.print(myName + ", what is your last name?");
		StringBuffer inVal = new StringBuffer(sc.nextLine());
		myName.append(" " + inVal);
		System.out.print(" In Method appended " + inVal);
		System.out.println(" to get " + myName);
        sc.close();
	}
	
	public static void main(String[] args) {
		StringBuffer name1 = new StringBuffer("Jan");
		StringBuffer name2 = name1;
		System.out.println("String names before = " + name1 + "/" + name2);
		addLastName(name1);
		System.out.println("String names after = " + name1 + "/" + name2);
	}
}
