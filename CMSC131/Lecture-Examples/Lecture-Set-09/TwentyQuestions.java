import java.util.Scanner;

public class TwentyQuestions {
	public static void playGame(CanHost20QuestionsGame host) {
		System.out.println("Hello, my name is " + host.getName() + ".");
		System.out.println("We are going to play 20 QUESTIONS.");
		System.out.println("I'm thinking of a common object, and you have to");
		System.out.println("guess what it is by asking up to 20 yes or no questions.\n");
		System.out.println("Type \"DONE\" if you want to stop before 20 questions have been asked.\n\n");		
	
		Scanner sc = new Scanner(System.in);

		String[] possibleTaunts = host.getTauntArray();
		
		for (int i = 1; i <= 20; i++) {
			System.out.print("Ask question #" + i + ": ");
			String question = sc.nextLine();
			
			if (question.equals("DONE"))
				break;
			
			String answer = host.answerQuestion(question);
			System.out.println(answer);
			System.out.println();
			
			if (Math.random() < .4) {		
				int tauntSelection = (int)(Math.random() * possibleTaunts.length);
				System.out.println(possibleTaunts[tauntSelection]);
			}
		}
		
		System.out.println("\n\nGAME OVER!\n\n");
        sc.close();
	}
}
