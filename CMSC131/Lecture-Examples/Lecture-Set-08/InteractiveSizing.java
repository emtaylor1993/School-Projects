import java.util.Scanner;

public class InteractiveSizing {
	public static void main(String[] args){
		int[][] arr;
		final int LOWEST = 0;
		final int RANGE = 100;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many rows? ");
		int size = sc.nextInt();
		arr = new int[size][];
		
		for (int row = 0; row < arr.length; row++) {
			System.out.print("How many in row " + (row + 1) + "?");
			int rowSize = sc.nextInt();
			arr[row] = new int[rowSize];
		}
		
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[row].length; col++){
				arr[row][col] = (int)(Math.random() * RANGE + LOWEST);
			}
		}
		
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[row].length; col++){
				System.out.print(arr[row][col] + "\t");
			}
			
			System.out.println();
		}

        sc.close();
	}
}
