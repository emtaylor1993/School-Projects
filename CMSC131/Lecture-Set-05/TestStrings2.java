import junit.framework.TestCase;

public class TestStrings2 {
	public void testCharAt() {
		String name = "Jan";
		char second = name.charAt(2);
		assertTrue(second == 'n');
	}
	
	public void testIndexOf() {
		String name = "Jandelyn Dawn Plane";
		int firstSpace = name.indexOf(' ');
		int lastSpace = name.lastIndexOf(' ');
		assertTrue (firstSpace != lastSpace);
		assertTrue(firstSpace == 8);
		assertTrue(lastSpace == 13);
	}
	
	public void testsubString() {
		String name = "Jandelyn Dawn Plane";
		int firstSpace = name.indexOf(' ');
		int lastSpace = name.lastIndexOf(' ');
		String middleName = name.substring(firstSpace + 1, lastSpace);
		assertTrue(middleName.equals("Dawn"));
	}
}
