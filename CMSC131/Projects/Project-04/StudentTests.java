import junit.framework.TestCase;

public class StudentTests extends TestCase {
	public void testComplexNumber(MyDouble real, MyDouble imag) {
		ComplexNumber myNum = new ComplexNumber(real, imag);
		MyDouble expectedReal = real;
		MyDouble expectedImag = imag;
		MyDouble actualReal = myNum.getReal();
		MyDouble actualImag = myNum.getImag();
		assertTrue(expectedReal == actualReal);
		assertTrue(expectedImag == actualImag);
	}
	
	public void testAdd(){
		{
			ComplexNumber a = new ComplexNumber(new MyDouble(3), new MyDouble(4));
			ComplexNumber b = new ComplexNumber(new MyDouble(4), new MyDouble(5));
			MyDouble expectedReal = new MyDouble(7);
			MyDouble expectedImag = new MyDouble(9);
			ComplexNumber sum = a.add(b);
			MyDouble actualReal = sum.getReal();
			MyDouble actualImag = sum.getImag();
			assertTrue(expectedReal.equals(actualReal));
			assertTrue(expectedImag.equals(actualImag));
		}	
		{
			ComplexNumber a = new ComplexNumber(new MyDouble(-3.2), new MyDouble(4.5));
			ComplexNumber b = new ComplexNumber(new MyDouble(4.1), new MyDouble(-5.3));
			MyDouble expectedReal = new MyDouble(0.9);
			MyDouble expectedImag = new MyDouble(-0.8);
			ComplexNumber sum = a.add(b);
			MyDouble actualReal = sum.getReal();
			MyDouble actualImag = sum.getImag();
			assertTrue(expectedReal.equals(actualReal));
			assertTrue(expectedImag.equals(actualImag));
		}
	}

	public void testSubtract() {
		{
			ComplexNumber a = new ComplexNumber(new MyDouble(9), new MyDouble(10));
			ComplexNumber b = new ComplexNumber(new MyDouble(4), new MyDouble(7));
			MyDouble expectedReal = new MyDouble(5);
			MyDouble expectedImag = new MyDouble(3);
			ComplexNumber diff = a.subtract(b);
			MyDouble actualReal = diff.getReal();
			MyDouble actualImag = diff.getImag();
			assertTrue(expectedReal.equals(actualReal));
			assertTrue(expectedImag.equals(actualImag));
		}	
		{
			ComplexNumber a = new ComplexNumber(new MyDouble(-3.2), new MyDouble(4.5));
			ComplexNumber b = new ComplexNumber(new MyDouble(4.1), new MyDouble(-5.3));
			MyDouble expectedReal = new MyDouble(-7.3);
			MyDouble expectedImag = new MyDouble(9.8);
			ComplexNumber diff = a.subtract(b);
			MyDouble actualReal = diff.getReal();
			MyDouble actualImag = diff.getImag();
			assertTrue(expectedReal.equals(actualReal));
			assertTrue(expectedImag.equals(actualImag));
		}
	}

	public void testMult() {
		{
			ComplexNumber a = new ComplexNumber (new MyDouble(9), new MyDouble(10));
			ComplexNumber b = new ComplexNumber (new MyDouble(4), new MyDouble(7));
			MyDouble expectedReal = new MyDouble(-34);
			MyDouble expectedImag = new MyDouble(103);
			ComplexNumber product = a.multiply(b);
			MyDouble actualReal = product.getReal();
			MyDouble actualImag = product.getImag();
			assertTrue(expectedReal.equals(actualReal));
			assertTrue(expectedImag.equals(actualImag));
		}
		{
			ComplexNumber a = new ComplexNumber (new MyDouble(-3), new MyDouble(4));
			ComplexNumber b = new ComplexNumber (new MyDouble(4), new MyDouble(-5));
			MyDouble expectedReal = new MyDouble(8);
			MyDouble expectedImag = new MyDouble(31);
			ComplexNumber product = a.multiply(b);
			MyDouble actualReal = product.getReal();
			MyDouble actualImag = product.getImag();
			assertTrue(expectedReal.equals(actualReal));
			assertTrue(expectedImag.equals(actualImag));
		}
	}
	
	public void testDivide(){
		{
			MyDouble expectedReal1 = new MyDouble(16);
			MyDouble expectedImag1 = new MyDouble(-2);
			ComplexNumber myNum1 = new ComplexNumber(expectedReal1, expectedImag1);
			
			MyDouble expectedReal2 = new MyDouble(3);
			MyDouble expectedImag2 = new MyDouble(-2);
			ComplexNumber myNum2 = new ComplexNumber(expectedReal2, expectedImag2);
			
			MyDouble actualReal = new MyDouble(4);
			MyDouble actualImag = new MyDouble(2);
			ComplexNumber actualNum = new ComplexNumber(actualReal, actualImag);
		}
		{
			MyDouble expectedReal1 = new MyDouble(-8);
			MyDouble expectedImag1 = new MyDouble(27);
			ComplexNumber myNum1 = new ComplexNumber (expectedReal1, expectedImag1);
			
			MyDouble expectedReal2 = new MyDouble(2);
			MyDouble expectedImag2 = new MyDouble(3);
			ComplexNumber myNum2 = new ComplexNumber(expectedReal2, expectedImag2);
			
			MyDouble actualReal = new MyDouble(5);
			MyDouble actualImag = new MyDouble(6);
			ComplexNumber actualNum = new ComplexNumber(actualReal, actualImag);	
		}		
	}
	
	public void testEqComp(){
		MyDouble x = new MyDouble(5);
		MyDouble y = new MyDouble(7);
		MyDouble real = new MyDouble(5);
		MyDouble imag = new MyDouble(7);
		ComplexNumber myNum1 = new ComplexNumber (real,imag);
		ComplexNumber myNum2 = new ComplexNumber (x, y);
		assertTrue(myNum1.compareTo(myNum2) == 0);
	}
	
	public void testParse(){
		{	
			MyDouble a = new MyDouble(4);
			MyDouble b = new MyDouble(5);
			ComplexNumber c = new ComplexNumber(a, b);
			String str = "     4 +   5i   ";
			ComplexNumber n1 = ComplexNumber.parseComplexNumber(str);
			assertTrue(n1.equals(c));	
		}
		{	
			MyDouble a = new MyDouble(-3);
			MyDouble b = new MyDouble(5);
			ComplexNumber c = new ComplexNumber(a, b);
			String str = "     -3 +   5i   ";
			ComplexNumber n1 = ComplexNumber.parseComplexNumber(str);
			assertTrue(n1.equals(c));
		}
	}
	
	public void testNorm(){
		MyDouble a = new MyDouble(6);
		MyDouble b = new MyDouble(8);
		MyDouble c = new MyDouble(10);
		MyDouble realpart = a.multiply(a);
		MyDouble imagpart = b.multiply(b);
		MyDouble comnumber = realpart.add(imagpart);
		MyDouble squareroot = comnumber.sqrt();
		assertTrue(c.equals(squareroot));
	}
}
