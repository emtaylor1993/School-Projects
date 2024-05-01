import java.util.Scanner;

/**
 * Shows Arguments
 * 
 * @author Jan
 *
 */
public class IntegerArgs {
	/**
	 * Sums Integer arguments
	 * 
	 * @param args must be integers or else
	 */
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int total = 0;
		
		if (args.length == 0) {
			System.out.println("You must give arguments");
		} else {
			for (int  argIndex = 0; argIndex < args.length; argIndex++) {
				int argVal = 0;
				
				try {
					argVal = Integer.parseInt(args[argIndex]);
				} catch (NumberFormatException e) {
					System.out.println(args[argIndex] + " is not a numeric value");
					System.out.print("give a numeric value to replace it:");
					argVal = sc.nextInt();
				}
				
				printStars(argVal);
				total += argVal;
			}
		}
		
		System.out.println("total = " + total);
        sc.close();
	}
	
	/**
	 * prints that many stars
	 * 
	 * @param val number of stars to print
	 */
	public static void printStars(int val) {
		for (int col = 0; col < val;col++) {
			System.out.print("*");
		}
		
		System.out.println(": "+val);
	}
}
