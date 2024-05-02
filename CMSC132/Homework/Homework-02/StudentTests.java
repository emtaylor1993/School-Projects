import org.junit.*; 
import static org.junit.Assert.*;
import java.util.*;

public class StudentTests {
	@Test
	public <T> void testDuplicateFirst() {
		ArrayList<Integer> aList = new ArrayList<Integer>();
		aList.add(4);
		aList.add(3);
		aList.add(2);
		aList.add(1);

		RecursiveListMethods.duplicateFirst(aList);
		assertEquals("[4, 4, 4, 4]", aList.toString());
	}

	@Test
	public <T> void testDuplicateLast() {
		ArrayList<Integer> aList = new ArrayList<Integer>();
		aList.add(4);
		aList.add(3);
		aList.add(2);
		aList.add(1);

		RecursiveListMethods.duplicateLast(aList);
		assertEquals("[1, 1, 1, 1]", aList.toString());
	}

	/*
	 * Testing for Duplicates.
	 */
	@Test
	public <T> void testAnyDuplicates() {
		ArrayList<Integer> aList = new ArrayList<Integer>();
		aList.add(4);
		aList.add(3);
		aList.add(4);
		aList.add(2);
		aList.add(2);
		aList.add(5);

		assertTrue(RecursiveListMethods.anyDuplicates(aList));
	}

	/*
	 * Testing for when there are no Duplicates.
	 */
	@Test
	public <T> void testNoDuplicates() {
		ArrayList<Integer> aList = new ArrayList<Integer>();
		aList.add(9);
		aList.add(5);
		aList.add(4);
		aList.add(2);
		aList.add(1);

		assertFalse(RecursiveListMethods.anyDuplicates(aList));
	}

	@Test
	public <T> void testFindLargest() {
		ArrayList<Integer> aList = new ArrayList<Integer>();
		aList.add(9);
		aList.add(4);
		aList.add(2);
		aList.add(3);
		aList.add(5);
		aList.add(2);

		int x = RecursiveListMethods.findLargest(aList);
		assertEquals(9,x);
	}
}