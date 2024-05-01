public class Student implements Person {
	private String name;
	private int financialAid;
	
	public Student() {
		this.name = "None";
		financialAid = 0;
	}
	
	public Student (String name, int financialAid) {
		this.name = name;
		this.financialAid = financialAid;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getValue() {
		return financialAid;
	}
	
	public Person copyMe() {
		Student oldStudent = (Student)this;
		Student tempStudent= new Student(oldStudent.name, oldStudent.financialAid);
		return tempStudent;
	}
	
	public int giveRaise() {
		int oldVal = financialAid;
		financialAid += 1000;
		return financialAid - oldVal;
	}
}
