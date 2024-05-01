/* This code is difficult to read because of the 
 * calculations that appear between the getting
 * of the values and the actual calculation for MPG
 * This is fixed by using a static method in
 * MpgCalculator1.java */

import java.util.Scanner;

public class MpgCalculator0 {
	public static void main(String[] args) {
		Scanner keyboardIn = new Scanner(System.in);
		
		while(true) {
			System.out.print("Enter milage in kilometers: ");
			int kilometers = keyboardIn.nextInt();
			
			System.out.print("Enter liters used: ");
			int liters = keyboardIn.nextInt();

			double gallons = liters / 3.78541178;
			double miles = kilometers / 1.609344;
			double answer =  miles / gallons;
			System.out.println("done with calculation");
			
			/* double answer = (kilometers/1.609344) / (liters / 3.78541178);*/
			
			System.out.println(answer + " Miles per Gallon");
		}
	}
}
