public class Person {
	private String name;
	private int id;
	
	public Person() {
		name = "No Name";
		id = 0;
	}
	
	public Person(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public Person(Person p) {
		name = p.name;
		id = p.id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getID() {
		return id;
	}
	
	public String toString() {
		return "name: " + name + ", ID: " + id;
	}
	
	public boolean equals(Person other) {
		if (other == null) {
			return false;
		} else {
			return name.equals(other.getName()) && id == other.getID();
		}
	}
	
	public boolean equalsOld(Person p) {
		return name.equals(p.getName()) && id == p.getID();
	}
}
