public class Faculty implements Person {
	private String name;
	private int annualSalary;
	
	public Faculty () {
		this.name = "None";
		annualSalary = 0;
	}
	
	public Faculty (String name, int annualSalary) {
		this.name = name;
		this.annualSalary = annualSalary;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getValue() {
		return this.annualSalary;
	}
	
	public Person copyMe() {
		Faculty oldStudent = (Faculty)this;
		Faculty tempStudent = new Faculty(oldStudent.name, oldStudent.annualSalary);
		return tempStudent;
	}
	
	public int giveRaise() {
		int oldVal = annualSalary;
		annualSalary *= 2;
		return annualSalary - oldVal;
	}
}
