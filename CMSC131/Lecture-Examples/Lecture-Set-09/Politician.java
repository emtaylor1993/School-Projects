public class Politician implements CanHost20QuestionsGame {
	private String[] taunts = {"That's it... use good ol' fashioned American engineerity.",
		"Maybe you should try working corroboratorily.",
		"That was a tough one -- I had to look it up in the encyclonopedium."};
	
	private String lastAnswer;
	
	public Politician() {
		lastAnswer = (Math.random() < .5) ? "YES":"NO";
	}
	
	public String getName() {
		return "George Dub-Yah";
	}
	
	public String[] getTauntArray() {
		return taunts;
	} 
	
	public String answerQuestion(String q) {
		if (lastAnswer.equals("YES"))
			lastAnswer = "NO";
		else
			lastAnswer = "YES";
		
		return lastAnswer;
	}
}
