import java.util.Scanner;

public class ArrayExample1 {
	public static void main(String[] args) {
		System.out.println("I'll generate some random numbers.");
		System.out.print("How many do you want:  ");
		Scanner scIn = new Scanner(System.in);
		int arrSize = scIn.nextInt();
		double[] arr = new double[arrSize];

		for (int ind = 0; ind < arr.length; ind++) {
			arr[ind] = Math.random();
		}
		
		System.out.print("I'm done. Would you like to see the numbers? ");
		String input = scIn.next();
		
		if (input.charAt(0) == 'y') {
			for (int ind = 0; ind < arr.length; ind++) {
				System.out.println(arr[ind]);
			}
		}
		
		System.out.print("Can I show off by adding them all up? ");
		input = scIn.next();
		
		double sum = 0.0;
		
		if (input.charAt(0) == 'y') {
			for (int pos = 0; pos < arr.length; pos++) {
				sum += arr[pos];
			}
		}
		
		System.out.println("That was fun.  They added up to " + sum);
        scIn.close();
	}
}
