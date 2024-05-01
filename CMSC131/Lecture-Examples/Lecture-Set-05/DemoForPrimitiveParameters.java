public class DemoForPrimitiveParameters {
	public static int funnyAdd(int first, int second) {
		int localVal = 8;
		localVal += first++ + ++second;
		System.out.println("In Other Method: " + first + " & " + second);
		return localVal;
	}

	public static void main(String[] args) {
		int x = 3, y = 2;
		System.out.println("In main: " + x + " & " + y);
		int sum1 = funnyAdd(x, y);
		System.out.println("sum1 = " + sum1);
		System.out.println("In main: " + x + " & " + y);
		int sum2 = funnyAdd(x - y, y + 1);
		System.out.println("sum2 = " + sum2);
		System.out.println("In main: " + x + " & " +y);
	}
}
