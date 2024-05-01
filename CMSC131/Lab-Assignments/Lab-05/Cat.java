/** This class is already implemented for the students
 * The students are only expected to use the cat class
 * in order to create a kennel where cats are sorted by color
 * 
 * @author Jan
 *
 */
public class Cat {
	private String name;
	private int color;
	
	public Cat(String nameProvided, int color) {
		name = nameProvided;
		
		if (color < 0 || color > HumaneSociety.KINDS_OF_CATS) {
			throw new RuntimeException("Illegal Color");
		}
		
		this.color = color;
	}
	
	public Cat(Cat otherGuy) {
		name = otherGuy.name;
		color = otherGuy.color;
	}
	
	public Cat() {
		name = "default cat";
		color = 0;
	}
	
	public boolean equals(Cat otherGuy) {
		if (otherGuy == null) {
			return false;
		}
		
		return name.equals(otherGuy.name) && color == otherGuy.color;
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public int getColor(){
		return color;
	}
	
	public String toString() {
		return name + " ( " + color + " )";
	}
}