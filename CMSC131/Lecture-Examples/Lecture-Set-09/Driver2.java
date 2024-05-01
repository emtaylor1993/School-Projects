public class Driver2 {
	public static void dailyRoutine(UMStudent student) {
		student.goToClass();
		student.add(2, 2);
		student.study();
		//student.psychoAnalyze(student);
		System.out.println();
	}
	
	public static void main(String[] args) {
		CSMajor csMajor = new CSMajor("John");
		CEMajor ceMajor = new CEMajor("Tom");
		PsychMajor psychMajor = new PsychMajor("Mark");
		dailyRoutine(csMajor);
		dailyRoutine(ceMajor);
		dailyRoutine(psychMajor);
//		psychMajor.psychoAnalyze(csMajor);
//		psychMajor.psychoAnalyze(ceMajor);
//		psychMajor.psychoAnalyze(psychMajor);
//		psychMajor.psychoAnalyze(csMajor);	
	}
}
