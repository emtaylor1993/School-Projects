import junit.framework.TestCase;

public class TestStrings3 {
	public void testCharAt(){
		String name = "Jan";
		char second = name.charAt(2);
		assertTrue(second == 'n');
	}
	
	public void testIndexOf() {
		String name = "Jandelyn Dawn Plane";
		int firstSpace = name.indexOf(' ');
		int lastSpace = name.lastIndexOf(' ');
		assertTrue(firstSpace != lastSpace);
		assertEquals(firstSpace, 8);
		assertEquals(lastSpace, 13);
		
		String shortName = "Jan";
		int space = shortName.indexOf(' ');
		assertEquals(space, -1);
	}
	
	public void testSubstring(){
		String name = "Jandelyn Dawn Plane";
		int firstSpace = name.indexOf(' ');
		int lastSpace = name.lastIndexOf(' ');
		String middleName = name.substring(firstSpace + 1, lastSpace);
		assertTrue(middleName.equals("Dawn"));
	}
}
