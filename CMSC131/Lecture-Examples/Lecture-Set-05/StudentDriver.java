public class StudentDriver {
	public static void main(String[] args) {
		Student x, y;
		x = new Student();
		y = new Student();
	
		x.setName("Fred");
		y.setName("Lawrence of Arabia");
		x.setIdNum(123456789);
		y.setIdNum(999999999);
		x.setTokenLevel(3);
		y.setTokenLevel(3);
		x.sayHello();
		y.sayHello();
		x.spendToken();
		x.spendToken();
		x.sayHello();
		x.acceptTokens(7);
		x.sayHello();
		int tokensForLawrence = 100;
		y.acceptTokens(tokensForLawrence);
		y.sayHello();
		x.doProject("Letter Maker", 6);
		y.doProject("Important People", 3);
		int lastFourReceived = x.getLastFourDigits();
		System.out.println("lastFourReceived is " + lastFourReceived);
		System.out.println(y.getLastFourDigits());
		System.out.println(x.eatLunch("Hamburger", 4));
	}
}
