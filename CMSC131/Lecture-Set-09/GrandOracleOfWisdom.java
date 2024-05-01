public class GrandOracleOfWisdom implements CanHost20QuestionsGame {
	private String[] taunts = {"Can't you think of anything better than that?",
		"You might as well give up -- you'll never get it...",
		"Are you even trying?",
		"Honestly, that was the dumbest question I've ever heard.",
		"What in the world are you thinking???"};
	
	public String getName() {
		return "The Grand Oracle of Wisdom";
	}
	
	public String[] getTauntArray() {  
		return taunts;
	}
	
	public String answerQuestion(String question) {
		String answer ;
		if (Math.random() < .5) {
			answer = "YES";
		} else {
			answer = "NO";
		}
		
		return answer;
	}
}
