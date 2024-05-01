public class BreakContinue {
	/**
	 * Shows break and continue in for loop
	 */
	public static void main(String[] args) {
		for (int j = 1; j < 5; j++) {
			for (int i = j; i <= 100; i++) {
				System.out.println("---------------------------");
				System.out.println("currently Processing " + i);
				
				if (i % 5 == 0) {
					System.out.println("I like Multiples of five");
					continue;
				}
				
				if (i == 9) {
					System.out.println("I quit this game");
					break;
				}
				
				System.out.println("I will continue processing");			

				if (i % 2 == 0) {
					System.out.println(i + " is even");
				} else {
					System.out.println(i + " is odd");
				}
			}
			
			System.out.println("done with inner");
		}
	}
}
