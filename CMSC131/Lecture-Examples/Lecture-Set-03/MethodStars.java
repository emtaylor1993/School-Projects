import java.util.Scanner;

public class MethodStars {
	public static void printStars(int size) {
		for (int count = 0; count < size; count++) {
			System.out.print("*");
		}
		
		System.out.println();
	}
	
	public static void printSquare(int size) {
		for (int row = 0; row < size; row++) {
			printStars(size);
		}
	}
	
	public static void printRec(int rowSize, int colSize) {
		for (int row = 0; row < rowSize; row++) {
			printStars(colSize);
		}
	}
	
	public static void printTri(int size) {
		for (int row = 0; row < size; row++) {
			printStars(row + 1);
		}
	}
	
	public static void main(String[] args) {
		Scanner keyboardInput = new Scanner(System.in);
		System.out.println("Give an integer");
		int size = keyboardInput.nextInt();
		
		printStars(size);
		System.out.println("-------------");
		printSquare(size);
		System.out.println("-------------");
		printRec(size, size * 2);
		System.out.println("-------------");
		printTri(size);
		System.out.println("-------------");

        keyboardInput.close();
	}
}
