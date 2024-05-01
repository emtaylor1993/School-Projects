public class ArgumentsSimple {
	public static void main(String[] args) {
		System.out.println("Hello World");
		int largerCount = 0;
		
		if (args.length == 0) {
			System.out.println("Nothing to report");
		} else {
			System.out.println(args.length + " arguments given:");
			
			
			for (int i = 0; i < args.length; i++) {
				System.out.print(args[i] + " ");
			}
			
			System.out.println();
			
			for (int i = 1; i < args.length; i++) {
				if (args[0].compareTo(args[i])< 0) {
					largerCount++;
				}
			}
			
			System.out.println("You gave Information where ");
			System.out.println("compared to " + args[0]);
			System.out.println(largerCount + " are larger and");
			System.out.println(args.length - largerCount - 1 + " are smaller");
		}
	}
}
