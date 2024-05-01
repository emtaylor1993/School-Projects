public class Driver {
	public static void main(String[] args) {
		GrandOracleOfWisdom mysterio = new GrandOracleOfWisdom();		
		TwentyQuestions.playGame(mysterio);

		Politician george = new Politician();
		TwentyQuestions.playGame(george);
		
		Dog fido = new Dog();
		TwentyQuestions.playGame(fido);
	}
}
