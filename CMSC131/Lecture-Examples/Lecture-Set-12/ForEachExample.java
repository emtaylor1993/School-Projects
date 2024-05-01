import java.util.ArrayList;
import java.util.Stack;

public class ForEachExample {
	public static void main(String[] args) {
		int[] a = {7, 9, 11};
		Integer[] b= {1, 3, 5};
		
		//---------------------
		for (int j = 0 ; j < a.length; j++) {
			System.out.println(a[j]);
		}
		
		for (int i : a) {
			System.out.println(i);
		}
		
		//---------------------
		for (Integer i : b) {
			System.out.println(i);
		}
		
		//--------------------
		System.out.println("********** for Cats");
		Cat[] catList = new Cat[5];
		catList[0] = new Cat("Fluffy");
		catList[1] = new Cat("Elvis");
		catList[2] = new Cat("Dante");
		catList[3] = new Cat("Benny");
		catList[4] = new Cat("Alice");
		
		for (Cat c :catList) {
			System.out.println(c);
		}
		
		catList[2].beEatenByADog();
		
		for (Cat c:catList) {
			c.beEatenByADog();
		}
		
		for (Cat c :catList) {
			System.out.println(c);
		}
		
		//===========================
		System.out.println("**********for int:");
		
		for (int i : a) {
			i += 100;
		}
		
		System.out.println("after first:");
		
		for (int i : a) {
			System.out.print(i+" ");
		}
		
		//===========================
		System.out.println();
		
		for (int j = 0; j < a.length; j++){
			int i = a[j];
			i += 100;
		}
		
		System.out.println("after second: ");
		
		for (int i : a) {
			System.out.print(i + " ");
		}
		
		//===========================
		System.out.println();
		for (int j = 0; j < a.length; j++) {
			a[j] += 100;
		}
		
		System.out.println("after third: ");
		
		for (int i : a) {
			System.out.print(i + " ");
		}
		
		//===========================
		System.out.println();
		System.out.println("**********for Integers");
		
		for (Integer i : b) {
			i += 100;
		}
		
		System.out.println("after first:");
		
		for (Integer i : b) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		for (int j = 0; j < b.length; j++) {
			Integer i = b[j];
			i += 100;
		}
		
		System.out.println("after second: ");
		
		for (Integer i : b) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		for (int j = 0; j < b.length; j++){
			b[j] += 100;
		}
		
		System.out.println("after third: ");
		
		for (Integer i : b) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		// NEW SECTION
		Stack<String> stack = new Stack<String>();
		stack.push("cat");
		stack.push("dog");
		stack.push("antelope");
		
		for (String s : stack) {
			System.out.println(s);
		}

		ArrayList<Student> students = new ArrayList<Student>();
		students.add(new Student("Joe", 12345));
		students.add(new Student("Fred", 27272));
		students.add(new Student("Cindy", 27272));
		
		for (Student s : students) {
			System.out.println(s);
		}
	}
}
