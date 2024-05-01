import java.util.Random;

public class RaggedArrayOfObjects {
	public static void main(String[] args) {
		Random generator = new Random();
		String[] names = {new String("Fluffy") ,new String("Garfield"), "Sylvester","Cheshire"};
		Cat[][] kennel;
		kennel = new Cat[names.length][];
		
		for (int catName = 0; catName < names.length; catName++) {
			int count = generator.nextInt(5) + 3;
			kennel[catName] = new Cat[count];
		}

		for (int catName = 0; catName < kennel.length; catName++) {
			for (int i =  0; i < kennel[catName].length; i++) {
				kennel[catName][i] = new Cat(names[catName] + (i + 1));
			}
		}

		for (int row = 0; row < kennel.length; row++) {
			for (int col = 0; col < kennel[row].length; col++) {
				System.out.print(kennel[row][col]);
			}
			
			System.out.println();
		}
	}
}
