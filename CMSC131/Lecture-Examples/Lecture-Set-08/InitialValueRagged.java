public class InitialValueRagged {
	public static void main(String[] args) {
		int[][] a = {{2, 3, 5}, {7}, {8, 9, 10, 23, 55}};

		for (int row = 0;  row < a.length; row++) {
			for (int col = 0; col < a[row].length; col++) {
				System.out.print(a[row][col] + " ");
			}
			
			System.out.println();
		}
		
		System.out.println("================");
		a[1] = new int[4];
		a[0][0] = 99;
		a[1][0] = 98;
		
		for (int row = 0;  row < a.length; row++) {
			for (int col = 0; col < a[row].length; col++) {
				System.out.print(a[row][col] + " ");
			}
			
			System.out.println();
		}
	}
}
