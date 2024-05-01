public class PsychMajor implements UMStudent {
	private String name;
	
	public PsychMajor (String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void goToClass() {
		System.out.println(name + " says:  ...my classmates are all psychotic!  " +
			"Going to class makes me depressed, so I'll stay home and counsel my " +
			"roommate about his breakup with Debbie.");
	}
	
	public void study() {
		System.out.println(name + " thinks:  I wonder what Debbie is doing tonight...");
	}

	public void add(int a, int b) {
		System.out.println(name + " says:  Let's talk about how adding numbers makes us feel.");
	}
	
	public void psychoAnalyze(UMStudent student) {
		System.out.println(name + " says:  " + student.getName() + " needs some help.");
		System.out.println("OK, " + student.getName() +", what is 2 + 2?");
		student.add(2, 2);
		System.out.println(name + " says:  " + student.getName() + ", you are crazy.");
	}
}
