public class CatDriver {
	public static void main(String[] args) {
		CatCommented a = new CatCommented("Fluffy");
		System.out.println(CatCommented.tellUsAboutCats());
		System.out.println("A cat can have at most " + CatCommented.MAX_LIVES + " lives.");
		a.beEatenByADog();
	}
}
