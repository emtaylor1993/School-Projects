import junit.framework.TestCase;

public class HumaneSocietyTest extends TestCase {
	public void testHumaneSociety() {
		HumaneSociety newPlace = new HumaneSociety();
		assertTrue(newPlace.toString().equals("Nothing Available"));
	}

	public void testAddOneCat() {
		HumaneSociety newPlace = new HumaneSociety();
		Cat first = new Cat("Abigail", 1);
		newPlace.addCat(first);
		String correct = "Current Cats Available: \n" + first.toString() + ";\n";
		assertTrue(newPlace.toString().equals(correct));
		first.setName("Yuck");
		String incorrect = "Current Cats Available: \n" + first.toString() + ";\n";
		assertFalse(newPlace.toString().equals(incorrect));
		HumaneSociety newerPlace = new HumaneSociety();
		Cat second = new Cat("Benji", 2);
		newerPlace.addCat(second);
		String secCorrect = "Current Cats Available: \n" + second.toString() + ";\n";
		assertTrue(newerPlace.toString().equals(secCorrect));
	}

	public void testAddMoreCats() {
		HumaneSociety newPlace = new HumaneSociety();
		Cat first = new Cat("Abigail", 1);
		newPlace.addCat(first);
		String correct = "Current Cats Available: \n" + first.toString()+";\n";
		assertTrue(newPlace.toString().equals(correct));
		Cat second = new Cat("Benji", 2);
		newPlace.addCat(second);
		String secCorrect = correct + second.toString()+";\n";
		assertTrue(newPlace.toString().equals(secCorrect));
		Cat third = new Cat("Cassandra", 1);
		newPlace.addCat(third);
		String thirdCorrect = "Current Cats Available: \n" + first.toString() + ";" + third.toString() + ";\n" + second.toString() + ";\n";
		assertTrue(newPlace.toString().equals(thirdCorrect));
	}
	
	public void testAllEmpty() {
		HumaneSociety newPlace = new HumaneSociety();
		assertTrue(newPlace.allEmpty());
		Cat first = new Cat("OneCat", 1);
		newPlace.addCat(first);
		assertFalse(newPlace.allEmpty());
		Cat zeroth = new Cat("ZeroCat", 0);
		newPlace.addCat(zeroth);
		Cat second = new Cat("TwoCat", 2);
		newPlace.addCat(second);
		Cat third = new Cat("ThreeCat", 3);
		newPlace.addCat(third);
		Cat fourth = new Cat("FourCat", 4);
		newPlace.addCat(fourth);
		assertFalse(newPlace.allEmpty());
	}
	
	public void testAtLeastOneOfEach() {
		HumaneSociety newPlace = new HumaneSociety();
		assertFalse(newPlace.atLeastOneOfEachType());
		Cat first = new Cat("OneCat", 1);
		newPlace.addCat(first);
		assertFalse(newPlace.atLeastOneOfEachType());

		Cat zeroth = new Cat("ZeroCat", 0);
		newPlace.addCat(zeroth);
		assertFalse(newPlace.atLeastOneOfEachType());
		
		Cat second = new Cat("TwoCat", 2);
		newPlace.addCat(second);
		assertFalse(newPlace.atLeastOneOfEachType());

		Cat third = new Cat("ThreeCat", 3);
		newPlace.addCat(third);
		Cat third2 = new Cat("ThreeCat2", 3);
		newPlace.addCat(third2);
		assertFalse(newPlace.atLeastOneOfEachType());

		Cat fourth = new Cat("FourCat", 4);
		newPlace.addCat(fourth);
		assertTrue(newPlace.atLeastOneOfEachType());
	}
}
