public class While2 {
	public static void main(String[] args) {
		int i = 1;
		long total = 0;

		while (i <= 1000000){
			total = total + i;
			i = i + 1;
		}

		System.out.println("Total is: " + total);
	}
}
