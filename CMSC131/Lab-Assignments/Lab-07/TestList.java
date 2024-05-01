import junit.framework.TestCase;

public class TestList extends TestCase {
	public void testExceptionThrow() {
		AlphabeticalStringList alpha = new AlphabeticalStringList();
		try {
			alpha.add(null);
		} catch(NullPointerException e) {
			fail("exception not handled.");
		}		
	}

	public void testAdd() {
		AlphabeticalStringList alpha = new AlphabeticalStringList();
		alpha.add("A");
		alpha.add("B");
		assertTrue("AB".equals(alpha.toString()));
	}
	
	public void testRemove() {
		AlphabeticalStringList alpha = new AlphabeticalStringList();
		alpha.remove("A");
		alpha.remove("B");
		assertTrue("".equals(alpha.toString()));
	}
}