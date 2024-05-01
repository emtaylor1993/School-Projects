public class Driver3 {
	public static void main(String[] args) {
		UMStudent[] students = new UMStudent[5];
		
		students[0] = new CSMajor("Fred");
		students[1] = new CEMajor("Susan");
		students[2] = new PsychMajor("Bob");
		students[3] = students[1];
		students[4] = students[2];
		
		for (int i = 0; i < 5; i++){
			Driver2.dailyRoutine(students[i]);
		}
	}
}
