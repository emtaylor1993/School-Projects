public class ForEachWith2DimensionalArray {
	public static void main(String[] args) {
		int[][] raggedArr = 
		{{91,90}, {22,24,26,20,28}, {10,13,17,15,12,19,18,11}};

		for (int[] row : raggedArr) {
			for (int value : row) {
				System.out.print(value + " ");
			}
			
			System.out.println();
		}
		
		for (int i = 0; i < raggedArr.length; i++) {
			for (int j = 0; j < raggedArr[i].length; j++) {
				System.out.print(raggedArr[i][j] + " ");
			}
			
			System.out.println();
		}
		
		for (int[] row : raggedArr) {
			for (int i = 0; i < row.length; i++) {
				row[i] += 100;
			}
		}
		
		for (int[] row : raggedArr) {
			for (int value : row) {
				System.out.print(value + " ");
			}
			
			System.out.println();
		}
	}
}
