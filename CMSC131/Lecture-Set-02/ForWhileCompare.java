public class ForWhileCompare {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int START = 1;
		final int END = 10;

		// Counted while loop examples
		int curr = START;
		while (curr <= END) {
			int i = 5;
			System.out.println("counting at : " + curr + i);
			curr = curr + 1;
		}
		
		System.out.println("I'm done; curr = " + curr);

		// For loop examples
		for (int cur = START; cur <= END; cur = cur + 1){
			System.out.println("counting at : " + cur);
		}
		
		// Uncomment the next line to see the error
		// System.out.println("I'm done; cur = "+cur);
		
		for (int cur = END; cur >= START; cur = cur - 1){
			System.out.println("countint at : " + cur);
		}
		
		for (int cur = 1024; cur >= 1; cur = cur / 2){
			System.out.println("counting at : " + cur);
		}
		
		for (int cur = 1024; cur >=1; cur = cur - 2){
			System.out.println("counting at : " + cur);			
		}
	}
}
