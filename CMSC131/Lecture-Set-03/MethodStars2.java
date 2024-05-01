import java.util.Scanner;

public class MethodStars2 {
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
			printStars(row+1);
		}
	}
	
	public static int getSize() {
		Scanner keyboardInput = new Scanner(System.in);
		int inVal;
		do {
			System.out.println("Give an integer");
			inVal = keyboardInput.nextInt();
		} while(!goodVal(inVal));
		
        keyboardInput.close();
		return inVal;
	}
	
	public static boolean goodVal(int value) {
		if (value >= 1 && value <= 10) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		int size = getSize();
		printStars(size);
		System.out.println("-------------");
		printSquare(size);
		System.out.println("-------------");
		printRec(size, size*2);
		System.out.println("-------------");
		printTri(size);
		System.out.println("-------------");
	}
}
