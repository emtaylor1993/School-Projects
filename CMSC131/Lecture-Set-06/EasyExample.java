public class EasyExample {
	public static void g() {
		System.out.println("           in g BEFORE THROW");
		throw new RuntimeException("Oh no, you did something bad...");
		//System.out.println("           in g AFTER THROW");
	}
	
	public static void f() {
		System.out.println("     in f BEFORE g");
		g();
		System.out.println("     in f AFTER g");
	}
	
	public static void main(String[] args) {
		System.out.println("in main BEFORE f");
		f();
		System.out.println("in main AFTER f");
	}
}
