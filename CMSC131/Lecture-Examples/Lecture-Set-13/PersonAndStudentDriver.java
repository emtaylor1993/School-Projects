import java.util.ArrayList;

public class PersonAndStudentDriver {
	public static void main(String[] args) {
		Person p = new Person("Larry", 27272);
		Student x = new Student("Moe", 272728, 1995, 7.0);
		Person y = new Student("Curly", 192812, 1998, 10.4);
		
		System.out.print("Using the correct toString ");
		System.out.println("when there are individual objects: ");
		System.out.println("Person Reference: " + p);
		System.out.println("Student Reference: " + x);
		System.out.println("Person Reference: " + y);
		System.out.println();
		
		ArrayList<Person> pArr = new ArrayList<Person>();
		pArr.add(p); // Adds person "Larry"
		pArr.add(x); // Adds student "Moe"
		pArr.add(y); // Adds student "Curly"
		pArr.add(new Student("Mike", 92823, 1996, 7.6));
		pArr.add(new Person("Pete", 19282));
		pArr.add(new Student("Matt", 3939, 1994, 2.6));
		pArr.add(new Student("Melissa", 91921, 1997, 9.0));
		pArr.add(new Person("Jon", 19293));
		
		// In the list there are 3 persons & 5 students
		System.out.println("Using the correct toString in an ArrayList:");
		
		for (Person tempP: pArr) {
			System.out.println(tempP);
		}
		
		System.out.println();
		Student student = new Student("Dummy", 0, 0, 0);
		ArrayList<Person> personList = new ArrayList<Person>(pArr);
		
		for (Person curr : pArr ) {
			if (curr.getClass() == student.getClass()) {
				personList.remove(curr);
			}
		}
		
		System.out.println("Original List:");
		for (Person tempP: pArr) {
			System.out.println(tempP);
		}
		
		System.out.println("---------");
		System.out.println("New List:");
		
		for (Person tempP: personList) {
			System.out.println(tempP);
		}
		
		System.out.println("================");
		ArrayList<Student> studentList = new ArrayList<Student>();
		
		for (Person curr : pArr) {
			if (curr.getClass() == student.getClass()) {
				studentList.add((Student)curr);
			}
		}
		
		System.out.println("Original List:");
		for (Person tempP: pArr) {
			System.out.println(tempP);
		}
		
		System.out.println("---------");
		System.out.println("New List:");
		
		for (Student tempP: studentList) {
			System.out.println(tempP);
		}
		
		System.out.println("================");
		System.out.print("Printing all Names and ");
		System.out.println("also GPAs for Students:");
		
		for (Person tempP : pArr) {
			System.out.print(tempP.getName());
			
			if (tempP instanceof Student) {
				System.out.print (" " + ((Student)tempP).getGPA());
			}
			
			System.out.println();
		}
		
		System.out.println();
		Person p1 = new Person("Person1 Name", 19392);
		Student s1 = new Student("Person1 Name", 19392, 1997, 2.0);
		Person p2 = new Student("Person1 Name", 19392, 1997, 2.0);
		
		if (p1.equalsOld(p2)) {
			System.out.println("according to Old - p1 equals p2");
		} else {
			System.out.println("according to Old - p1 NOT equal to p2");
		}
		
		if (p1.equalsOld(s1)) {
			System.out.println("according to Old - p1 equals s1");
		} else {
			System.out.println("according to Old - p1 NOT equal to s1");
		}
		
		if (s1.equalsOld(p1)) {
			System.out.println("according to Old - s1 equals p1");
		} else {
			System.out.println("according to Old - s1 NOT equal to p1");
		}
		
		if (p1.equals(p2)) {
			System.out.println("according to New - p1 equals p2");
		} else {
			System.out.println("according to New - p1 NOT equal to p2");
		}
		
		if (p1.equals(s1)) {
			System.out.println("according to New - p1 equals s1");
		} else {
			System.out.println("according to New - p1 NOT equal to s1");
		}
		
		if (s1.equals(p2)) {
			System.out.println("according to New - s1 equals p2");
		} else {
			System.out.println("according to New - s1 NOT equal to p2");
		}
	}
}
