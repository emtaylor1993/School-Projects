/*
 * Name: Emmanuel Taylor 
 * Discussion Section: Section 0202
 * Student ID Number: 111615834
 * Student Terpconnect Login ID: etaylor5
 */

/*
 * The purpose of this class is to test methods that aren't covered in the
 * PublicTests section of the project in order to make sure they are working
 * correctly.
 */

import org.junit.*; 
import static org.junit.Assert.*;

public class StudentTests {
	/*
	 * Student test "testReplace()" will create a new list and assign values 
	 * from 1 through 5 and tests to see if the replace method is able to 
	 * replace the 1 with the 4.
	 */
	@Test
	public void testReplace(){
		List<Integer> list = new List<Integer>(new IntegerComparator());
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		list.replace(1, 4);
		assertEquals("4 2 3 4 5", list.toString());
	}

	/*
	 * Student test "testClear()" will create a new list and assign values from
	 * 1 to 5 and call the clear method. This method will check to see if the
	 * clear method will return the list with no values.
	 */
	@Test
	public void testClear(){
		List<Integer> list = new List<Integer>(new IntegerComparator());
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		list.clear();
		assertEquals("", list.toString());
	}	

	/*
	 * Student test "testIsEmpty()" will create a new list and assign values
	 * from 1 through 5. This test with then call the clear method which should
	 * leave an empty list. Next the test checks to see if the isEmpty method
	 * will return true for having an empty list.
	 */
	@Test
	public void testIsEmpty(){
		List<Integer> list = new List<Integer>(new IntegerComparator());
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		list.clear();
		list.isEmpty();
		assertEquals(true, list.isEmpty());
	}	

	/*
	 * Student test "testCompareTo" will check to see if the compareTo method
	 * will return 0 when two lists are identical.
	 */
	@Test
	public void testCompareTo(){
		SortedList<Integer> list = new SortedList<Integer>(new IntegerComparator());
		list.add(7);
		list.add(8);
		list.add(9);

		SortedList<Integer> otherList = new SortedList<Integer>(new IntegerComparator());
		otherList.add(7);
		otherList.add(8);
		otherList.add(9);

		assertEquals(0 ,list.compareTo(otherList));
	}
}
