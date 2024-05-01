import java.util.Scanner;

public class MpgCalculator1 {
	private static double mpg(int kms, int ltrs) {
		double gallons = ltrs / 3.78541178;
		double miles = kms / 1.609344;
		double answer =  miles / gallons;
		System.out.println("done with calculation");
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner keyboardIn = new Scanner(System.in);
		
		while(true) {
			System.out.print("Enter milage in kilometers: ");
			int kilometers = keyboardIn.nextInt();
			System.out.print("Enter liters used: ");
			int liters = keyboardIn.nextInt();
			double ans = mpg(kilometers, liters);
			System.out.println(ans + " Miles per Gallon");
			//System.out.println(mpg(kilometers,liters)+" Miles per Gallon");
		}
	}
}
