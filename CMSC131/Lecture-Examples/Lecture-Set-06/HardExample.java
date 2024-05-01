public class HardExample {
	public static void g(int valIn) {
		System.out.println("\t\tin g BEFORE THROW");
		
		if (valIn == 4) {
			throw new RuntimeException("NEW bad thing happened");
		}
		
		try {
			if (valIn == 1) {
				throw new ArithmeticException("a bad math thing");
			} else if (valIn == 2) {
				throw new NullPointerException("pointer gone bad");
			} else if (valIn == 3) {
				throw new RuntimeException("Runtime bad thind described");
			}
		}
		// catch (NullPointerException e){
		// System.out.println("\t\tdealing with the bad pointer in g");
		// System.out.println("\t\tmessage = "+e.getMessage());
		// return;
		// }
		finally {
			System.out.println("\t\tthe finally block of g");
		}
		
		System.out.println("\t\tin g AFTER THROW");
	}

	public static void f(int inVal) {
		System.out.println("\tin f BEFORE g");
		try {
			g(inVal);
			System.out.println("\tin try of f");
		} catch (NullPointerException e) {
			System.out.println("\tNull Pointer Solved in f");
		}
		// catch (ArithmeticException a){
		// System.out.println("\tBad Math OK in f");
		// System.out.println("\tIt was : "+a.getMessage());
		// }
		finally {
			System.out.println("\tthe finally block in f");
		}
		
		System.out.println("\tin f AFTER g");
	}

	public static void main(String[] args) {
		System.out.println("in main BEFORE f");
		
		try {
			f(2); // substitute here 1,2,3,and 4
			System.out.println("XXX");
		} catch (NullPointerException e) {
			System.out.println("Null Pointer Solved in f");
		} catch (ArithmeticException a) {
			System.out.println("Bad Math OK in f");
			System.out.println("It was : " + a.getMessage());
		} catch (RuntimeException b) {
			System.out.println("Runtime now OK in main");
			System.out.println("Its message : " + b.getMessage());
		} finally {
			System.out.println("the finally block in MAIN");
		}
		
		System.out.println("in main AFTER f");
	}
}
