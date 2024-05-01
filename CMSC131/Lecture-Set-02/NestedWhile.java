public class NestedWhile {
	public static void main(String[] args) {
		int rowNumber = 1;
		
		while (rowNumber < 10) {
			int colNumber = 1;
			
			while (colNumber < 10) {
				System.out.print((rowNumber + colNumber) % 2);
				colNumber = colNumber + 1;
			}
			
			System.out.println();
			rowNumber = rowNumber + 1;
		}
	}
}
