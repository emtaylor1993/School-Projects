public class CatDriver4 {
	public static void main(String[] args) {
		Cat x = new Cat("Felix", 9);
		Cat y = new Cat("Bob", 9);
		
		CatOwner a = new CatOwner("Millie", x);
		CatOwner b = new CatOwner("Martha", y);
		CatOwner c = new CatOwner(a);
		
		a.walkPet();
		b.walkPet();
		c.walkPet();
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
	}
}
