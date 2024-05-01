public class CatOwner {
	private String name;
	private Cat pet;
	
	public CatOwner(String nameIn, Cat petIn) {
		pet = new Cat(petIn);
		name = nameIn;
	}
	
	public CatOwner(CatOwner otherGuy) {
		name = otherGuy.name;
		pet = new Cat(otherGuy.pet);
	}
	
	public static void doubleIt(int y) {
		y *= 2;
		System.out.println("y = " + y);
	}
	
	public static void main(String[] args) {
		int x = 5, y = 7;
		CatOwner.doubleIt(x);
		doubleIt(y);
		System.out.println(x + y);
		System.out.println("" + x + y);
		System.out.println(x + y + "");

		System.out.println(Cat.tellUsAboutCats());
		
		Cat cat = new Cat("Fluffy");
		CatOwner a = new CatOwner("Fred", cat);
		CatOwner b = new CatOwner(a);
		String line = "I like " + cat;
		System.out.println(line);
		System.out.println("a's pet = " + a.pet);
		System.out.println("b's pet = " + b.pet);
		System.out.println("a's pet is in danger!!");
		System.out.println("b's pet is safe (?)");
		a.pet.beEatenByADog();
		System.out.println("a's pet = " + a.pet);
		System.out.println("b's pet = " + b.pet);
		System.out.println("a's name = " + a.name);
		System.out.println("b's name = " + b.name);
		a.name = "Bob";
		b.name = "George";
		System.out.println("a's name = " + a.name);
		System.out.println("b's name = " + b.name);
	}
}
