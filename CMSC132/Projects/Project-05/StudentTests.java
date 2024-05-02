import org.junit.*;
import static org.junit.Assert.*;

public class StudentTests {
	@Test public void testStudent1() {
		Names names = new Names();

		names.getNames(2010, 2010, 13);

		assertEquals("Ella", names.getGirlName(2010, 13));
	}

	@Test public void testStudent2() {
		Names names = new Names();

		names.getNames(2009, 2009, 3);
		names.getNames(2009, 2009, 5);

		assertEquals("Ava", names.getGirlName(2009, 5));
		assertEquals("Michael", names.getBoyName(2009, 3));
	}

	@Test public void testStudent3() {
		Names names = new Names();

		names.getNames(2008, 2008, 5);

		assertEquals(5, names.getGirlRank(2008, "Ava"));
	}

	@Test public void testStudent4() {
		Names names = new Names();
		String[] topFiveGirlsNames= {"Emily", "Hannah", "Madison", "Ashley", "Sarah"};
		int i;

		names.getNames(2000, 2000, 5);

		for (i = 0; i < 5; i++)
			assertEquals(topFiveGirlsNames[i], names.getGirlName(2000, i + 1));
	}

	@Test public void testStudent5() {
		Names names = new Names();
		String[] topTenGuysNames= {"Jacob", "Michael", "Matthew", "Joshua", "Christopher", "Nicholas", "Andrew", "Joseph", "Daniel", "Tyler"};
		int i;

		names.getNames(2000, 2000, 10);

		for (i = 0; i < 10; i++)
			assertEquals(topTenGuysNames[i], names.getBoyName(2000, i + 1));
	}

	@Test public void testStudent6() {
		String girlNames[][] = {{"Emily", "Hannah", "Madison", "Ashley", },
		    {"Emily", "Madison", "Hannah", "Ashley"},
			{"Emily", "Madison", "Hannah", "Emma"},
			{"Emily", "Emma", "Madison", "Hannah"},
			{"Emily", "Emma", "Madison", "Olivia"},
			{"Emily", "Emma", "Madison", "Abigail"}};
		
		String boyNames[][] = {{"Jacob", "Michael", "Matthew", "Joshua"},
			{"Jacob", "Michael", "Matthew", "Joshua"},
			{"Jacob", "Michael", "Joshua", "Matthew"},
			{"Jacob", "Michael", "Joshua", "Matthew"},
			{"Jacob", "Michael", "Joshua", "Matthew"},
			{"Jacob", "Michael", "Joshua", "Matthew"}};
				
		int i, j;

		Names names = new Names();
		names.getNames(2000, 2005, 4);

		for (i = 0; i < 4; i++)
			for (j = 0; j < 4; j++) {
				assertEquals(girlNames[i][j], names.getGirlName(2000 + i, j + 1));
				assertEquals(boyNames[i][j], names.getBoyName(2000 + i, j + 1));
			}
	}
}