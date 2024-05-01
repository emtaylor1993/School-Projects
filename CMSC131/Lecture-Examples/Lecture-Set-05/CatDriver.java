public class CatDriver {
	public static void main(String[] args) {
		Cat a = new Cat("Fluffy", 9);
		System.out.println(Cat.tellUsAboutCats());
		// System.out.println("Cat's name = " + a.name);
		// a.name = "Bob";
		// System.out.println("A cat can have at most " + Cat.MAX_LIVES + " lives.");
		// Cat.MAX_LIVES = 99;
		a.petTheCat();
		a.beEatenByADog();
		System.out.println("a = " + a);
		a.petTheCat();
		a.setName("Lawrence of Arabia");
		System.out.println("a = " + a);
		Cat b = new Cat("Felix", 9);
		System.out.println("A cat can have at most " + Cat.MAX_LIVES + " lives.");
	}
}
