public class Staff implements Person {
	private String name;
	private int hourlySalary;
	
	public Staff() {
		this.name = "None";
		hourlySalary = 0;
	}
	
	public Staff (String name, int hourlySalary) {
		this.name = name;
		this.hourlySalary = hourlySalary;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getValue() {
		return this.hourlySalary;
	}
	
	public Person copyMe() {
		Staff oldStudent = (Staff)this;
		Staff tempStudent= new Staff(oldStudent.name, oldStudent.hourlySalary);
		return tempStudent;
	}
	
	public int giveRaise() {
		double oldVal = hourlySalary;
		hourlySalary = (int)(1.5 * oldVal);
		return hourlySalary - (int)oldVal;
	}
}
