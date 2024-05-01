public class CatDriver2 {
	public static void main(String[] args) {
		Cat x = new Cat("Felix", 9);
		Cat y = x;
		
		x.beEatenByADog();
		System.out.println("y = " + y);
		
		System.out.println("We're about to take (x)" + x + " for a walk.");
		walkTheCat(x);
		System.out.println("We're back from the walk.");
		System.out.println("x = " + x);
		System.out.println("y = " + y);
	}
	
	private static void walkTheCat(Cat pet) {
		System.out.println("Walking " + pet + " is fun!");
		System.out.println("WATCH OUT!");
		pet.beEatenByADog();
	}
}
