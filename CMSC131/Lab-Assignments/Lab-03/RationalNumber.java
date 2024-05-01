public class RationalNumber {
	/* STUDENTS:  You may NOT add any further instance or static variables! */
	private final MyDouble numerator;   // To be initialized in constructors
	private final MyDouble denominator;   // To be initialized in constructors
	
	public RationalNumber() {
		/* constructor with no parameters -- sets
		 * the value of the rational number to 0/1
		 */
		numerator = new MyDouble(0);
		denominator = new MyDouble(1);
	}
	
	public RationalNumber(MyDouble num, MyDouble denom) {
		/* constructor with two parameters -- sets
		 * the value of the rational number to num/denom
		 */
		numerator = num;
		denominator = denom;
	}
	
	public RationalNumber(RationalNumber old) {
		/* copy constructor for the rational number class */
		numerator = old.numerator;
		denominator = old.denominator;
	}

	public MyDouble getNum() {
		/* returns the numerator of the rational number */
		return numerator;
	}
	
	public MyDouble getDenom() {
		/* returns the denominator of the rational number */
		return denominator;
	}

	public RationalNumber add(RationalNumber right) {
		/* must add the parameter to the current and
		 * then return the new RationalNumber that is the sum*/
		right.numerator.add(numerator);
		right.denominator.add(denominator);
		return right;
	}	
	
	public RationalNumber subtract(RationalNumber right) {
		/* must subtract the parameter from the current and
		 * then return the new RationalNumber that is the difference*/
		numerator.subtract(right.numerator);
		denominator.subtract(right.denominator);
		return this;
	}	
	
	public RationalNumber multiply(RationalNumber right) {
		/* must multiply the parameter and the current and
		 * then return the new RationalNumber that is the product*/
		RationalNumber product = new RationalNumber(numerator.multiply(right.denominator), denominator.multiply(right.numerator));
		return product;
	}
	
	public RationalNumber divide(RationalNumber right) {
		/* must divide the current by the parameter
		 * then return the new RationalNumber that is the quotient*/		
		return new RationalNumber(right.numerator,this.denominator);
	}
	
	public boolean equals(RationalNumber right) {
		/* compared two rational numbers for actual equality
		 * the numerators are equal and the denominators are equal*/
		return (numerator.equals(right.denominator) && denominator.equals(right.numerator));
	}
	
	public boolean equivalent(RationalNumber right) {
		/* compares the two for equality of value (not comparing numerator
		 * and denominator (i.e. 1/2 = 2/4)*/
		if (numerator.equals(right.numerator)) {
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		/* returns the string in the form of numerator/denominator */
		return (denominator + "/" + numerator);
	}
	
	public boolean isLess(RationalNumber right) {
		/* returns true if the current object is less than the parameter
		 * or false otherwise (notice this means the floating point value
		 * of that rational number is less than the floating point value of
		 * the argument*/
		return (numerator.compareTo(right.numerator) < 0);
	}
	
	public boolean isGreater(RationalNumber right) {
		/* returns true if the current object is greater than the parameter
		 * or false otherwise (notice this means the floating point value
		 * of that rational number is greater than the floating point value of
		 * the argument*/
		return (denominator.compareTo(right.denominator) < 0);
	}
}