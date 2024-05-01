public class CSMajor implements UMStudent {
	private String name;
	
	public CSMajor (String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void typeIntoLaptop(String whatToType) {
		System.out.println(name + " types:  " + whatToType);
	}
	
	public void goToClass() {
		typeIntoLaptop("...something about a Cat being eaten by a Dog...");
	}
	
	public void study() {
		typeIntoLaptop("run WorldOfWarcraft...");
	}
	
	public void add(int a, int b) {
		typeIntoLaptop("computer... what is " + a + " plus " +  b + "?");
	}
}
