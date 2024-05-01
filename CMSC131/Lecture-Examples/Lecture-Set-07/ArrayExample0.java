import java.util.Scanner;

public class ArrayExample0 {
	public static void main(String[] args) {
		Scanner scIn = new Scanner(System.in);
		
		System.out.println("How many values would you like to store: ");
		int size = scIn.nextInt();

		int[] nums = new int[size];
		
		for (int pos = 0; pos < nums.length; pos++) {
			System.out.println("Enter value " + (pos + 1) + ": ");
			nums[pos] = scIn.nextInt();
		}
		
		System.out.println("Here are the values you entered:  ");
		
		for (int pos = 0; pos < nums.length; pos++) {
			System.out.println(nums[pos]);
		}

        scIn.close();
	}
}
