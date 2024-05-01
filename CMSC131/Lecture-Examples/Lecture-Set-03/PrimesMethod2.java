import java.util.Scanner;

public class PrimesMethod2 {
	public static void main(String[] args) {
		int primesFoundSoFar = 0;

		Scanner keyboardInput = new Scanner(System.in);
		System.out.print("How many primes would you like to see?");
		int numberToDisplay = keyboardInput.nextInt();
		
		for (int currentContender = 2; primesFoundSoFar < numberToDisplay; currentContender++) {
			boolean couldBePrime = true;
			
			for (int potentialFactor = 2; potentialFactor < currentContender; potentialFactor++) {
				if (currentContender % potentialFactor == 0) {
					couldBePrime = false;
				}
			}
		
			if (couldBePrime) {
				System.out.println(currentContender);
				primesFoundSoFar = primesFoundSoFar + 1;
			}
		}

        keyboardInput.close();
	}
}
