import junit.framework.TestCase;

public class TestPolymorphism extends TestCase {
	public void testPolyGood() {
		System.out.println("In testPolyGood");
		Student stu1 = new Student ("R. Goode", 23456, 1998, 3.89);
		Student stu2 = new Student("R. Goode", 23456, 1998, 3.89);
		System.out.println("1.");
		assertTrue(stu1.equals(stu2));
		
		Person perStu1 = new Student ("R. Goode", 23456, 1998, 3.89);
		Person perStu2 = new Student("R. Goode", 23456, 1998, 3.89);
		System.out.println("2.");
		assertTrue(perStu1.equals(perStu2));
		
		Person perStu3 = new Student ("R. Goode", 23456, 1998, 5.9);
		Person perStu4 = new Student("R. Goode", 23456, 1998, 3.89);
		System.out.println("3.");
		assertFalse(perStu3.equals(perStu4));
		
		Person perStu = new Student("R. Goode", 23456, 1998, 3.89);
		Person perFac = new Faculty ("R. Goode", 23456, 1998);
		System.out.println("4.");
		assertFalse (perStu.equals (perFac));
		System.out.println("5.");
		assertFalse(perFac.equals(perStu));
	}
	
	public void testPolyBad() {
		System.out.println("------------------\nIn testPolyBad");
		Student stu1 = new Student ("R. Goode", 23456, 1998, 3.89);
		Student stu2 = new Student("R. Goode", 23456, 1998, 3.89);
		System.out.println("1.");
		assertTrue(stu1.equalsOld(stu2));

		Person perStu1 = new Student ("R. Goode", 23456, 1998, 3.89);
		Person perStu2 = new Student("R. Goode", 23456, 1998, 3.89);
		System.out.println("2.");
		assertTrue(perStu1.equalsOld(perStu2));
		
		Person perStu3 = new Student ("R. Goode", 23456, 1998, 5.9);
		Person perStu4 = new Student("R. Goode", 23456, 1998, 3.89);
		System.out.println("3.");
		//assertFalse(perStu3.equalsOld(perStu4));
		
		Person perStu = new Student("R. Goode", 23456, 1998, 3.89);
		Person perFac = new Faculty ("R. Goode", 23456, 1998);
		System.out.println("4.");
		assertFalse (perStu.equalsOld(perFac));
		System.out.println("5.");
		assertFalse (perFac.equalsOld(perStu));
	}
	
	public void testPolyNullGood() {
		System.out.println("------------------\nIn testPolyNullGood");
		Student stu1 = new Student ("R. Goode", 23456, 1998, 3.89);
		Student stu2 = null;
		System.out.println("1.");
		assertFalse(stu1.equals(stu2));

		Person perStu1 = new Student ("R. Goode", 23456, 1998, 3.89);
		Person perStu2 = null;
		System.out.println("2.");
		assertFalse(perStu1.equals(perStu2));
		
		Person perStu = new Student("R. Goode", 23456, 1998, 3.89);
		Person perFac = null;
		System.out.println("3.");
		assertFalse (perStu.equals(perFac));
	}
	
	public void testPolyNullBad() {
		System.out.println("------------------\nIn testPolyNullBad");
		Student stu1 = new Student ("R. Goode", 23456, 1998, 3.89);
		Student stu2 = null;
		System.out.println("1.");
		assertFalse(stu1.equalsOld(stu2));

		Person perStu1 = new Student ("R. Goode", 23456, 1998, 3.89);
		Person perStu2 = null;
		System.out.println("2.");
		assertFalse(perStu1.equalsOld(perStu2));
		
		Person perStu = new Student("R. Goode", 23456, 1998, 3.89);
		Person perFac = null;
		System.out.println("3.");
		assertFalse (perStu.equalsOld(perFac));
	}
}