public class Student {
	/* Declaring instance variables */
	public String name;
	public int idNum;
	public int tokenLevel;
	
	/* Constructors */
	public Student() {
		name = "Unknown";
		idNum = 0;
		tokenLevel = 3;
	}
	
	public Student(String nameIn, int idIn) {
		name = nameIn;
		idNum = idIn;
		tokenLevel = 3;
	}
	
	public Student(String nameIn, int idIn, int tokensIn) {
		name = nameIn;
		idNum = idIn;
		tokenLevel = tokensIn;
	}
	
	/* Declaring instance methods */
	public void sayHello() {
		System.out.print("Hi, my name is " + name);
		System.out.println(", and I have " + tokenLevel + " tokens.");
	}
	
	public void spendToken() {
		tokenLevel--;
	}
	
	public boolean equals(Student other) {
		boolean idNumsMatch = (idNum == other.idNum);
		boolean namesMatch = (name.equals(other.name));
		return idNumsMatch && namesMatch;
	}
	
	public void acceptTokens(int numberOfTokensAccepted) {
		tokenLevel += numberOfTokensAccepted;
	}
	
	public void doProject(String project, int numPages) {
		int currPage = 1;
		
		while (currPage <= numPages) {
			System.out.println(name + " is working on page " + currPage);
			currPage++;
		}
		
		System.out.println(name + " is done with " + project);
	}
	
	public int getLastFourDigits() {
		int lastFour;
		lastFour = idNum % 10000;
		return lastFour;
	}
	
	public String eatLunch(String foodType, int amountOrdered) {
		String lunch = "";
		int numberEaten = 0;
		
		while (numberEaten < amountOrdered) {
			lunch += foodType + " ";
			numberEaten++;
		}
		
		return name + " has eaten " + lunch;
	}
	
	public String toString() {
		return name + ", ID " + idNum + ", tokens " + tokenLevel;
	}
}
