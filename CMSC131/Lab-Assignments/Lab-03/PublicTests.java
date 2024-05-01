import junit.framework.TestCase;

public class PublicTests extends TestCase {
	public void testCopyConstructor() {
		MyDouble a = new MyDouble(5), b = new MyDouble(-3);
		
		RationalNumber x = new RationalNumber(a, b);
		RationalNumber y = new RationalNumber(x);
		assertTrue(x != y);
		assertTrue(y.getNum().compareTo(a) == 0 && y.getDenom().compareTo(b) == 0);
	}
	
	// write tests for all of the other methods here
	// Since you know some of the code is bad (faulty reasoning)
	// try to find cases that fail -- that show it is bad
	// (without looking at the code)
	// it is also useful to find one that passes even though
	// it is bad code
	
	public void testGetNum() {
		MyDouble a = new MyDouble(10);
		MyDouble b = new MyDouble(4);
		
		RationalNumber x = new RationalNumber(a, b);
		assertEquals(a, x.getNum());
	}
	
	public void testGetDenom() {
		MyDouble a = new MyDouble(10);
		MyDouble b = new MyDouble(4);
		
		RationalNumber x = new RationalNumber(a, b);
		assertEquals(b, x.getDenom());
	}
	
	public void testAdd() {
		MyDouble a = new MyDouble(5);
		MyDouble b = new MyDouble(5);
		MyDouble c = new MyDouble(5);
		MyDouble d = new MyDouble(5);
		
		RationalNumber x = new RationalNumber(a, b);
		RationalNumber y = new RationalNumber(c, d);
		x.add(y);
		assertEquals(a.add(c), x.getNum());
		assertEquals(b.add(d), x.getNum());
	}
	
	public void testSubtract() {
		MyDouble a = new MyDouble(5);
		MyDouble b = new MyDouble(5);
		MyDouble c = new MyDouble(5);
		MyDouble d = new MyDouble(5);
		
		RationalNumber x = new RationalNumber(a, b);
		RationalNumber y = new RationalNumber(c, d);
		x.subtract(y);
		assertEquals(a.subtract(c), x.getNum());
		assertEquals(b.subtract(d), x.getDenom());
	}
	
	public void testMultiply() {
		MyDouble a = new MyDouble(5);
		MyDouble b = new MyDouble(5);
		MyDouble c = new MyDouble(5);
		MyDouble d = new MyDouble(5);
		
		RationalNumber x = new RationalNumber(a, b);
		RationalNumber y = new RationalNumber(c, d);
		x.multiply(y);
		assertEquals(a.multiply(c), x.getNum());
		assertEquals(a.multiply(d), x.getDenom());
	}
	
	public void testDivide() {
		MyDouble a = new MyDouble(5);
		MyDouble b = new MyDouble(5);
		MyDouble c = new MyDouble(5);
		MyDouble d = new MyDouble(5);
		
		RationalNumber x = new RationalNumber(a, b);
		RationalNumber y = new RationalNumber(c, d);
		x.divide(y);
		assertEquals(a.divide(c), x.getNum());
		assertEquals(b.divide(d), x.getDenom());
	}
	
	public void testEquivalent() {
		MyDouble a = new MyDouble(5);
		MyDouble b = new MyDouble(5);
		MyDouble c = new MyDouble(5);
		MyDouble d = new MyDouble(5);
		
		RationalNumber x = new RationalNumber(a, b);
		RationalNumber y = new RationalNumber(c, d);
		assertTrue(true == x.equivalent(y));
	}
	
	public void testIsLess() {
		MyDouble a = new MyDouble(5);
		MyDouble b = new MyDouble(5);
		MyDouble c = new MyDouble(5);
		MyDouble d = new MyDouble(5);
		
		RationalNumber x = new RationalNumber(a, b);
		RationalNumber y = new RationalNumber(c, d);
		assertTrue(false == x.isLess(y));
	}
	
	public void testIsGreater() {
		MyDouble a = new MyDouble(5);
		MyDouble b = new MyDouble(5);
		MyDouble c = new MyDouble(5);
		MyDouble d = new MyDouble(5);
		
		RationalNumber x = new RationalNumber(a, b);
		RationalNumber y = new RationalNumber(c, d);
		assertTrue(false == x.isGreater(y));
	}
}