import java.util.Scanner;

public class PrimesMethod4 {
	public static boolean isPrime(int currVal) {
		for (int factor = 2; factor < currVal; factor++) {
			if (currVal % factor == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		int primesFoundSoFar = 0;

		Scanner keyboardInput = new Scanner(System.in);
		System.out.print("How many primes would you like to see?");
		int numberToDisplay = keyboardInput.nextInt();
		
		for (int currentContender = 2; primesFoundSoFar < numberToDisplay; currentContender++) {
			if (isPrime(currentContender)) {
				System.out.println(currentContender);
				primesFoundSoFar = primesFoundSoFar + 1;
			}
		}

        keyboardInput.close();
	}
}