import java.util.Scanner;

public class PrimesMethod3 {
	public static boolean isPrime(int currVal) {
		boolean couldBePrime = true;
		
		for (int factor = 2; factor < currVal; factor++) {
			if (currVal % factor == 0) {
				couldBePrime = false;
			}
		}
		
		return couldBePrime;
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
