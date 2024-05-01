public class StudentTools {
	public static int sumTokens(Student first, Student second) {
		System.out.println("Processing: " + first.getName() + " & " + second.getName());
		int sum = first.getTok() + second.getTok();
		return sum;
	}
}
