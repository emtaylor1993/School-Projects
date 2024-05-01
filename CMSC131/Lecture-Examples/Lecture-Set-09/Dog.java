public class Dog implements CanHost20QuestionsGame {
	private String[] taunts = {"Woof!  Woof!  Woof!", "Grrrrr....", "AAAWWWOOOOOOO!  ARF!  ARF!"};
	
	public String getName() {
		return "Fido the Dog";
	}
	
	public String[] getTauntArray () {
		return taunts;
	}
	
	public String answerQuestion(String q) {
		return "Woof.";
	}
}