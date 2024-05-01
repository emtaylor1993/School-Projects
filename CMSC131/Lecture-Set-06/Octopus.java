public class Octopus {
	private String name;
	private double weight;
	
	private boolean eatCat(Cat c) {
		if (c.isAlive()) {
			System.out.println("Sorry, " + c + " is still alive!");
			return false;
		}
		
		System.out.println(name + " has eaten " + c);
		weight += 10.0;
		return true;
	}
	
	private static void killCat(Cat kitty) {
		while(kitty.isAlive()) {
			kitty.beEatenByADog();
		}
	}
	
	private void eatLunch() {
		int catsEaten = 0;
		
		Cat kitty1 = new Cat("YummyGuy");
		Cat kitty2 = new Cat("TastyCat");
		Octopus.killCat(kitty1);
		
		if (eatCat(kitty1)) {
			catsEaten++;
		}
		
		if (eatCat(kitty2)) {
			catsEaten++;
		}
		
		System.out.println(name + " ate " + catsEaten + " cats for lunch.");
	}
	
	public static void main(String[] args) {
		Octopus x = new Octopus();
		x.name = "George";
		x.weight = 72.4;
		
		System.out.println("Before lunch, " + x.name + " weighs " + x.weight);
		x.eatLunch();
		System.out.print("After lunch, " + x.name + " weighs " + x.weight);
	}
}