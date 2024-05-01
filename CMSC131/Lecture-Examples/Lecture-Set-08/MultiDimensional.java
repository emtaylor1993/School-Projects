public class MultiDimensional {
	/**
	 * Showing 3 dimensions
	 */
	public static void main(String[] args) {
		int[][][] array1;
		array1 = new int[3][][];
		array1[0] = new int[2][];
		array1[1] = new int[3][];
		array1[2] = new int[4][];
		
		for (int row = 0; row < array1.length; row++) {
			for (int col = 0; col < array1[row].length; col++) {
				array1[row][col]= new int[5];
			}
		}
		
		// Etc making space for all parts
		array1[0][0][0] = 99;
		array1[0][0][1] = 46;
		System.out.println("sum = " + (array1[0][0][0] + array1[0][0][1]));
		
		for (int[][] arr2: array1) {
			for(int[] arr: arr2) {
				for (int curr: arr) {
					System.out.print(curr+" ");
				}
				
				System.out.println();
			}
			System.out.println("---------------------");
		}
	}
}
