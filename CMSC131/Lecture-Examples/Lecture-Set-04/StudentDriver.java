public class StudentDriver {
	public static void main(String[] args) {
		int a = 7;
		Student x = new Student("Jan", 123456789);
		Student y = new Student("Bill", 1, 123456789);
		System.out.println("tokens = " + x.getTok());
		x.acceptTokens(100);
		System.out.println("tokens = " + x.getTok());
		System.out.println("I am " + x.getName());
		System.out.println("I am " + x);
		
		System.out.println("last four = " + x.lastFour());
		a = x.lastFour();
		a *= 2;
		System.out.println("new ID = " + a);
		System.out.println("last four = " + x.lastFour());
		
		if (x == y) {
			System.out.println("same");
		} else {
			System.out.println("diff");
		}
		
		if (x.equals(y)) {
			System.out.println("same");
		} else {
			System.out.println("diff");
		}
		
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		System.out.println("sum of tokens = " + StudentTools.sumTokens(x, y));
	}
}
