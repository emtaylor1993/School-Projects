import java.util.Scanner;

public class Example1 {
	private static int MPG(int miles, int gallons) {
		System.out.println("before calculation");
		int answer =  miles / gallons;
		System.out.println("done with calculation");
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner keyboardIn = new Scanner(System.in);
		
		while (true) {
			System.out.print("Enter milage: ");
			int miles = keyboardIn.nextInt();
			
			System.out.print("Enter gallons used: ");
			int gallons = keyboardIn.nextInt();
			
			float answer = MPG(miles, gallons);
			System.out.println(answer + " Miles per Gallon");
		}
	}
}
