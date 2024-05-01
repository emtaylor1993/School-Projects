public class Student2 {
	/* instance variables */
	public String name;
	public int idNum;
	public int tokenLevel;
	
	/* instance methods */
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
}
