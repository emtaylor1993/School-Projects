public class CatDriver2 {
	public static void main(String[] args) {
		CatCommented x = new CatCommented("Felix");
		CatCommented y = x;
		
		x.beEatenByADog();
		System.out.println(y);
		System.out.println("We're about to take " + x + " for a walk.");
		walkTheCat(x);
		System.out.println("We're back from the walk.");
		System.out.println(x);
	}
	
	private static void walkTheCat(CatCommented pet) {
		System.out.println("Walking " + pet + " is fun!");
		System.out.println("WATCH OUT!");
		pet.beEatenByADog();
	}
}
