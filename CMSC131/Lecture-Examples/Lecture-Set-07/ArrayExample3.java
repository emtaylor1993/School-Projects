public class ArrayExample3 {
	private static char findGrade(int score) {
		int cutOffs[] = {90, 80, 70, 60};
		char letterGrades[] = {'A', 'B', 'C', 'D', 'F'};
		int index;
		
		for (index = 0; index < cutOffs.length; index++) {
			if (cutOffs[index] <= score) {
				break;
			}
		}
		
		return letterGrades[index];
	}

	public static void main(String[] args) {
		for (int score = 0; score < 100; score += 3) {
			System.out.println("A score of " + score + " yields a Grade of " + findGrade(score));
		}
	}
}
