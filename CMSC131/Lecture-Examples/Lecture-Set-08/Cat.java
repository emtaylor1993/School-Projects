public class Cat {
	private String name;
	private int lives;
	public final static int MAX_LIVES = 9;
	
	public Cat(String nameProvided) {
		name = nameProvided;
		lives = MAX_LIVES;
	}
	
	public Cat(Cat otherGuy) {
		name = otherGuy.name;
		lives = otherGuy.lives;
	}
	
	public Cat() {
		name = "default cat";
		lives = MAX_LIVES;
	}
	
	public boolean equals(Cat otherGuy) {
		return name.equals(otherGuy.name) && lives == otherGuy.lives;
	}
	
	public int getLives() {
		return lives;
	}
	public void setName(String newName) {
		name = newName;
	}
	
	public void beEatenByADog() {
		lives--;
		//System.out.println(name + " has been eaten!");
		//System.out.println(name + " has " + lives + " more lives...");
	}
	
	public boolean isAlive() {
		return lives > 0;
	}
	
	public String toString() {
		return name + " ( " + lives + " lives.)";
	}
	
	public static String tellUsAboutCats() {
		String output = "Cats are furry little creatures.\n";
		output += "Some people believe that cats are magical ";
		output += "and possess universal wisdom.\nI think cats ";
		output += "are more like domestic squirrels.";
		return output;
	}
}
