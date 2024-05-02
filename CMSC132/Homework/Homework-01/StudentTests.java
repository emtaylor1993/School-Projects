import junit.framework.TestCase;

public class StudentTests extends TestCase {
	public void testAddWord() throws InvalidParameterException {
		Index index = new Index();
		index.addWord("the", new int[] {1});	
		assertEquals(index.toString(), "the: 1\n");
	}
	
	public void testLongestWord() throws InvalidParameterException {
		Index index = new Index();
		index.addWord("the", new int[] {1});
		index.addWord("hello", new int[] {1, 2, 3});	
		assertFalse(index.longestWord().equals("the"));
		assertTrue(index.longestWord().equals("hello"));
	}
	
	public void testNumUniqueWords() throws InvalidParameterException {
		Index index = new Index();
		index.addWord("the", new int[] {1});
		index.addWord("hello", new int[] {1, 2, 3});
		assertTrue(index.numUniqueWords() == 2);
	}
	
	public void testnumWordOccurrences() throws InvalidParameterException {
		Index index = new Index();
		index.addWord("the", new int[] {1, 2, 3});	
		assertTrue(index.numWordOccurrences() == 3);
	}
	
	public void testisAlphabetized() throws InvalidParameterException {
		Index index = new Index();
		index.addWord("the", new int[] {1, 2, 3});
		index.addWord("at", new int[] {1, 2, 3});	
		assertTrue(index.isAlphabetized() == false);
	}
	
	public void testremoveWord() throws InvalidParameterException {
		Index index = new Index();
		index.addWord("the", new int[] {1});
		index.addWord("hello", new int[] {1});
		index.removeWord("the");
		assertEquals( index.toString(), "hello: 1\n");
	}
	
	public void testToString() throws InvalidParameterException {
		Index index = new Index();
		index.addWord("hello", new int[] {1});	
		assertEquals(index.toString(), "hello: 1\n");
	}
}