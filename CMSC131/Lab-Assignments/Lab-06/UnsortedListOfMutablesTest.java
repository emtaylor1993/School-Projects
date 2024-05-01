import junit.framework.TestCase;

public class UnsortedListOfMutablesTest extends TestCase {
	public void testStudent() {
		Student s = new Student("Pete", 1000);
		assertTrue(s.getName().equals("Pete"));
		assertTrue(s.getValue() == 1000);
		s.giveRaise();
		assertTrue(s.getName().equals("Pete"));
		assertFalse(s.getValue() == 1000);
	}	
	
	public void testAddSimple() {
		UnsortedListOfMutables list = new UnsortedListOfMutables();
		Student stu = new Student("Pete", 1000);
		list.addItem(stu);
		assertTrue(list.getNames().equals("Pete"));
		assertTrue(list.getValues() == 1000);
		Faculty fac = new Faculty("Smith", 10000);
		list.addItem(fac);
		assertTrue(list.getNames().equals("PeteSmith"));
		assertTrue(list.getValues() == 11000);
		Staff stf = new Staff("Jones", 10);
		list.addItem(stf);
		assertTrue(list.getNames().equals("PeteSmithJones"));
		assertTrue(list.getValues() == 11010);
		list.addItem(stu);
		assertTrue(list.getNames().equals("PeteSmithJonesPete"));
		assertTrue(list.getValues() == 12010);
	}
	
	public void testAddNoAlias() {
		UnsortedListOfMutables list = new UnsortedListOfMutables();
		Student s = new Student("Pete", 1000);
		list.addItem(s);
		assertTrue(list.getNames().equals("Pete"));
		assertTrue(list.getValues() == 1000);
		s.giveRaise();
		assertTrue(list.getValues()== 1000);
		assertFalse(list.getValues() == s.getValue());
		Faculty f = new Faculty("Smith", 10000);
		list.addItem(f);
		assertTrue(list.getNames().equals("PeteSmith"));
		assertTrue(list.getValues() == 11000);
		f.giveRaise();
		assertTrue(list.getNames().equals("PeteSmith"));
		assertTrue(list.getValues() == 11000);
		assertFalse(f.getValue() == 10000);
	}

	public void testRemove() {
		UnsortedListOfMutables list = new UnsortedListOfMutables();
		Student stu = new Student("Pete", 1000);
		list.addItem(stu);
		Faculty fac = new Faculty("Smith", 10000);
		list.addItem(fac);
		Staff stf = new Staff("Jones", 10);
		list.addItem(stf);
		list.addItem(stu);
		list.remove("Smith");
		assertTrue(list.getNames().equals("PeteJonesPete"));
		assertTrue(list.getValues() == 2010);
		list.remove("Pete");
		assertTrue(list.getNames().equals("JonesPete"));
		assertTrue(list.getValues() == 1010);
	}
}
