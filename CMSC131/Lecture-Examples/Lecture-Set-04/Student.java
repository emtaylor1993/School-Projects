public class Student {
	/* Declaring instance variables */
	private String name;
	private int idNum;
	private int tokenLevel;

	public Student(String n, int first, int second) {
		if (first > 10000) {
			name = n;
			tokenLevel = second;
			idNum = first;
		} else {
			name = n;
			tokenLevel = first;
			idNum = second;	
		}
	}	

	public Student(String n, int id) {
		name = n;
		tokenLevel = 3;
		idNum = id;
	}
	
	public Student() {
		name = "none";
		tokenLevel = 3;
		idNum = 0;
	}
	
	public int getTok() {
		return tokenLevel;
	}
	
	public String getName() {
		return name;
	}
	
	public void setTok(int tokensIn) {
		if (tokensIn < 4) {
			tokenLevel = tokensIn;
		} else {
			tokenLevel = 0;
		}
	}
	
	public void acceptTokens(int tokensPassedIn) {
		if (tokensPassedIn < 4) {
			tokenLevel += tokensPassedIn;
		}
	}
	
	public int lastFour() {
		return idNum % 10000;
	}
	
	public boolean equals(Student otherStudent) {
		if (otherStudent == null) {
			return false;
		} else if (name.equals(otherStudent.name)) {
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		return (name );
	}
}
