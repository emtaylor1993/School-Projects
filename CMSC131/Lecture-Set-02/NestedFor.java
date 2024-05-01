import java.util.Scanner;

public class NestedFor {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size;
		System.out.println("Give a positive integer for the size: ");
		size = sc.nextInt();
		
		for (int col = 0; col <size; col = col + 1) {
			System.out.print("*");
		}
		
		System.out.println();

		// Add code to make a column of size "size" high
		for (int row = 0; row < size; row = row + 1) {
			System.out.println("*");
		}
		
		// Add code to make a square of size "size" square
		for (int row = 0; row < size; row = row + 1) {
			for (int col = 0; col < size; col= col + 1) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		
		// Add code to make a triangle where top row is one star on the left
		for (int row = 0; row < size; row = row + 1) {
			for (int col = 0; col <= row; col= col + 1) {
				System.out.print("*");
			}

			System.out.println();
		}
		
		// Add code to make a triangle where top row is full but
		// bottom row is one star on the left
		for (int row = 0; row < size; row = row + 1) {
			for (int col = size; col > row; col = col - 1) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		
		// Add code to make a triangle where top row is one star on the right
		for (int row = 0; row < size; row = row + 1) {
			for (int col = size - 1; col > row; col = col - 1) {
				System.out.print(" ");
			}
			
			for (int col = 0; col <= row; col = col + 1) {
				System.out.print("*");
			}
			System.out.println();
		}

        sc.close();
	}
}
