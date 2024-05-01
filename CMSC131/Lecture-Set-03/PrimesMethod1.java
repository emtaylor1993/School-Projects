import java.util.Scanner;

public class PrimesMethod1 {
	public static void main(String[] args) {
		int primesFoundSoFar = 0;

		Scanner keyboardInput = new Scanner(System.in);
		System.out.print("How many primes would you like to see?");
		int numberToDisplay = keyboardInput.nextInt();
		int currentContender = 2;
		
		while (primesFoundSoFar < numberToDisplay) {
			boolean couldBePrime = true;
			int potentialFactor = 2;
			
			while (potentialFactor < currentContender) {
				if (currentContender % potentialFactor == 0) {
					couldBePrime = false;
				}
				
				potentialFactor = potentialFactor + 1;
			}
			
			if (couldBePrime) {
				System.out.println(currentContender);
				primesFoundSoFar = primesFoundSoFar + 1;
			}
			
			currentContender = currentContender + 1;
		}

        keyboardInput.close();
	}
}
