import java.util.Random;

public class RandomRaggedArray {
	public static void main(String[] args) {
		Random generator = new Random();
		int rows = generator.nextInt(10) + 1;
		int[][] a = new int[rows][];
		
		for (int i = 0; i < a.length; i++) {
			a[i] = new int[generator.nextInt(10) + 1];
			
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = generator.nextInt(10);
			}
		}
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			
			System.out.println();
		}
	}	
}