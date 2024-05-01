public class PolymorphicArray {
	public static void main(String[] args){
		CanHost20QuestionsGame[] arr = new CanHost20QuestionsGame[6];
		arr[0] = new Dog();
		arr[1] = new Politician();
		arr[2] = new Dog();
		arr[3] = new GrandOracleOfWisdom();
		arr[4] = new Politician();
		arr[5] = new Dog();
		
		for (int i = 0; i < arr.length; i++){
			System.out.println(arr[i].getTauntArray()[0]);
		}
	}
}
