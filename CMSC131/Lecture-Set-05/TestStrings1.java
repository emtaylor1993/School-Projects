import junit.framework.TestCase;

public class TestStrings1 extends TestCase {
	public void testCharAt(){
		String myName = "Jan";
		char second = myName.charAt(2);
		assertTrue(second == 'n');
	}
	
	public void testIndexOf(){
		String myName = "Jandelyn Dawn Plane";
		int firstSpace = myName.indexOf(' ');
		int lastSpace = myName.lastIndexOf(' ');
		assertTrue(firstSpace != lastSpace);
		assertEquals(firstSpace, 8);
		assertEquals(lastSpace, 13);
	}
	
	public void testSubString(){
		String myName = "Jandelyn Dawn Plane";
		int firstSpace = myName.indexOf(' ');
		int lastSpace = myName.lastIndexOf(' ');
		String middleName = myName.substring(firstSpace+1,lastSpace);
		assertTrue(middleName.equals("Dawn"));
	}
}
