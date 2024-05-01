import junit.framework.TestCase;

public class StringMethodsTest extends TestCase {
	public void testIsThere() {
		{
			String sVal = "Jan Plane";
			boolean hasA = StringMethods.isThere(sVal, 'a');
			assertTrue(hasA);
			boolean notIn = StringMethods.isThere(sVal, 'b');
			assertFalse(notIn);
		}
		{
			String sVal = "";
			boolean nothingIn = StringMethods.isThere(sVal, 'a');
			assertFalse(nothingIn);
			boolean notIn = StringMethods.isThere(sVal, 'b');
			assertFalse(notIn);	
		}
	}

	public void testCount() {
		{
			String sVal = "Jan Plane";
			int hasAs = StringMethods.count(sVal, 'a');
			assertTrue(hasAs == 2);
			int notIn = StringMethods.count(sVal, 'b');
			assertTrue(notIn == 0);
		}
		{
			String sVal = "aaabba";
			int hasA = StringMethods.count(sVal, 'a');
			assertTrue(hasA == 4);
			int hasB = StringMethods.count(sVal, 'b');
			assertTrue(hasB == 2);	
		}
		{
			String sVal = "";
			int hasA = StringMethods.count(sVal, 'a');
			assertTrue(hasA == 0);
		}
	}

	public void testReturnValue() {
		final double  EPSILON = 0.00001;
		
		{
			String sVal = "1.23 + 4.56";
			double sum = StringMethods.returnValue(sVal);
			double diff = Math.abs(sum - 5.79);
			assertTrue(diff < EPSILON);
		}
		{
			String sVal = "1.23 + 4.56 ";
			double sum = StringMethods.returnValue(sVal);
			double diff = Math.abs(sum - 5.79);
			assertTrue(diff < EPSILON);
		}
		{
			String sVal = "2.2 + 4.4";
			double sum = StringMethods.returnValue(sVal);
			double diff = Math.abs(sum - 6.6);
			assertTrue(diff < EPSILON);
		}
	}
}
