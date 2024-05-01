public class Student {
	/* Declaring instance variables */
	private String name;
	private String idNum;
	private int tokenLevel;
	
	/* Declaring instance methods */
	public void sayHello() {
		System.out.print("Hi, my name is " + name);
		System.out.println(", and I have " + tokenLevel + " tokens.");
	}
	
	public void spendToken() {
		tokenLevel--;
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
		lastFour = Integer.valueOf(idNum) % 10000;
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

	public int getIdNum() {
		return Integer.valueOf(idNum);
	}

	public void setIdNum(int idNumIn) {
		idNum = String.valueOf(idNumIn);
	}

	public String getName() {
		return name;
	}

	public void setName(String nameIn) {
		name = nameIn;
	}

	public int getTokenLevel() {
		return tokenLevel;
	}

	public void setTokenLevel(int tokenLevelIn) {
		tokenLevel = tokenLevelIn;
	}
}
