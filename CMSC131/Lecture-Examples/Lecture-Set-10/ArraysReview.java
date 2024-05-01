public class ArraysReview {
	private static double twiceVal(double paramVal) {
		System.out.println("---in twiceVal(double)");
		return 2 * paramVal;
	}
	
	private static double twiceVal(int paramVal) {
		System.out.println("---in twiceVal(int)");
		return 2 * paramVal;
	}
	
	private static double sumVals(double[] paramArr) {
		double sum = 0;
		System.out.println("---in sumVals(double[])");
		
		for (int i = 0; i < paramArr.length; i++) {
			sum+= paramArr[i];
		}
		
		return sum;
	}
	
	private static double sumVals(int[] paramArr) {
		double sum = 0;
		System.out.println("---in sumVals(double[])");
		for (int i = 0; i < paramArr.length; i++) {
			sum += paramArr[i];
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		int iVal = 5;
		double dVal = 2.1;
		int[] iArr = {2, 6, 5, 3};
		double[] dArr = {1.5, 2.7, 8.1, 99.25, 7.89};
		System.out.println(twiceVal(5.4 * 2));
		System.out.println(twiceVal(dVal));		// variable, value or expression
		System.out.println(sumVals(dArr));		// only variable (not value or expression
		System.out.println(twiceVal(iVal));
		System.out.println(twiceVal(iArr[0]));	// widening conversion
		System.out.println(sumVals(iArr));		// no widening conversion
	}
}
