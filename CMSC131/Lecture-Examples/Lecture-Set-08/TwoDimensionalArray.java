import java.util.Random;

public class TwoDimensionalArray {
	public static void main(String[] args) {
		Random random = new Random();
		final int ROWS = 10;
		final int COLS = 40;

		char[][] a = new char[ROWS][COLS];

		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				a[i][j] = (char)(random.nextInt(26) + (int)('A'));
			}
		}

		for (int i = 0; i < ROWS; i++) { 
			for (int j = 0; j < COLS; j++) {
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
	}
}
