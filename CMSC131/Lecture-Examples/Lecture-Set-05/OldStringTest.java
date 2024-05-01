import junit.framework.TestCase;

public class OldStringTest {
	public void testIndexOf() {
		String myName = "Jandelyn Dawn Plane";
		assertTrue(myName.length() == 19);
		int firstSpace = myName.indexOf(' ');
		assertEquals(firstSpace, 8);
		int lastA = myName.lastIndexOf(' ');
		assertEquals(lastA, 13);
		assertTrue(firstSpace != lastA);
		int theX = myName.indexOf('x');
		assertTrue(theX == -1);
	}
	
	public void testSubString(){
		String myName = "Jandelyn Dawn Plane";
		int firstSpace = myName.indexOf(' ');
		String firstPart = myName.substring(0, firstSpace);
		assertTrue(firstPart.equals("Jandelyn"));
		myName = myName.substring(firstSpace + 1);
		assertTrue(myName.equals("Dawn Plane"));
		
		firstSpace = myName.indexOf(' ');
		String secondPart = myName.substring(0, firstSpace);
		assertTrue(secondPart.equals("Dawn"));
		myName = myName.substring(firstSpace + 1);
		assertTrue(myName.equals("Plane"));
		
		String five = "abcde";
		String first = five.substring(0, 3);
		String second = five.substring(3, five.length());
		assertTrue(first.equals("abc"));
		assertTrue(second.equals("de"));
	}
	
	private static int countAs(String name){
		int count = 0;
		String remainder = new String(name);
		int nextA = remainder.indexOf('a');
		
		while (nextA != -1){
			count++;
			remainder = remainder.substring(nextA + 1);
			nextA = remainder.indexOf('a');
		}
		
		return count;
	}
	
	public void testCount(){
		String myName = "Jandelyn Dawn Plane";
		assertTrue(countAs(myName) == 3);
		String noA = "My house is green";
		assertTrue(countAs(noA) == 0);
		String allA = "aaaaaa";
		assertTrue(countAs(allA) == 6);
	}
}
