public class CallingOtherMethods {
	public static void main(String[] args) {
		Student3 a = new Student3("Bob", 7777);
		Student3 a2 = new Student3();
		Student3 a3 = new Student3("Jan", 111, 99);
		
		Student3.printClassSize();
		Student3.printClass(a, a2, a3);
		a.printOneStudent();
		a2.printOneStudent();
		a3.printOneStudent();
	}
}
