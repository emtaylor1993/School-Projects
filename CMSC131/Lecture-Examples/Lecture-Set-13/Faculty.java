public class Faculty extends Person2 {
	private int hireYear;

	public Faculty(String name, int id, int year) {
		super(name, id);
		hireYear = year;
	}

	public Faculty(Faculty f) {
		this(f.getName(), f.getID(), f.hireYear);
	}
	
	public boolean equals(Object other) {
		System.out.println("in Faculty's NEW equals");

		if (other == null) {
			return false;
		} else if (other.getClass() != getClass()) {
			return false;
		} else {
			Faculty f = (Faculty)other;
			return (super.equals(f) && hireYear == f.hireYear);
		}
	}
	
	public boolean equalsOld(Faculty other) {
		System.out.println("in Faculty's old equals");
		return (super.equalsOld(other) && hireYear == other.hireYear);
	}
}
