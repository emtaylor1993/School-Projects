public class Student2 extends Person2 {
	private int admitYear;
	private double gpa;

	public Student2() {
		super();                  // Super must be first line in constructor
		admitYear = 2000;
		gpa = 4.0;
	}

	public Student2(String name, int id, int admitYear, double gpa) {
		super(name, id);
		this.admitYear = admitYear;
		this.gpa = gpa;
	}

	public Student2(Student2 s) {
		super(s);
		admitYear = s.admitYear;
		gpa = s.gpa;
	}

	public int getAdmitYear() {
		return admitYear;
	}

	public double getGPA() {
		return gpa;
	}

	public String toString() {
		return "S:"+super.toString() + ", Admitted: " + admitYear + ", gpa: " + gpa;
	}

	public boolean equals(Object other) {
		System.out.println("in Student's NEW equals");

		if (other == null) {
			return false;
		} else if (other.getClass() != getClass()){
			return false;
		} else {
			Student2 s = (Student2) other;
			return super.equals(s) && admitYear == s.admitYear && gpa == s.gpa;
		}
	}
	
	public boolean equalsOld(Student2 s) {
		System.out.println("in Student's old equals");

		return super.equalsOld(s) && admitYear == s.admitYear && gpa == s.gpa;
	}
}
