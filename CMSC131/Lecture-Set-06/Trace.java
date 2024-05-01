import java.util.Scanner;

public class Trace {
	private static void starsRec(int wd, int ht) {
		for (; ht > 0; ht--){
			for (int col = 0; col < wd; col++) {
				System.out.print("*");
			}
			
			System.out.println();
		}		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int width, height;
		System.out.println("Give a positive integer for the width: ");
		width = sc.nextInt();
		System.out.println("Give a positive integer for the length: ");
		height = sc.nextInt();
        sc.close();
		starsRec(width, height);
	}
}
