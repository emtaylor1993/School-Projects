import java.util.Set;
import org.junit.*;
import static org.junit.Assert.*;

public class PublicTests {

    @Test public void testPublic1() {
        Bag bag = new Bag();

        bag.add(131);
        bag.add(132);

        assertTrue(bag.contains(131));
        assertTrue(bag.contains(132));
        assertFalse(bag.contains(130));
    }

    @Test public void testPublic2() {
        Bag bag = new Bag();

        bag.add(131);
        bag.add(132);

        assertEquals(2, bag.size());
    }

    @Test public void testPublic3() {
        Bag bag = new Bag();

        bag.add(131);
        bag.add(132);
        bag.add(132);

        assertTrue(bag.contains(131));
        assertTrue(bag.contains(132));
        assertFalse(bag.contains(130));
        assertEquals(3, bag.size());
    }

    @Test public void testPublic4() {
        Bag bag = new Bag();

        bag.add(131);
        bag.add(132);
        bag.add(132);

        assertEquals(1, bag.getCount(131));
        assertEquals(2, bag.getCount(132));
    }

    @Test public void testPublic5() {
        Bag bag = new Bag();
        Set elements;

        bag.add(131);
        bag.add(131);
        bag.add(132);
        bag.add(132);
        bag.add(132);
        elements = bag.uniqueElements();

        assertEquals(2, elements.size());
        assertTrue(elements.contains(131));
        assertTrue(elements.contains(132));
    }

    @Test public void testPublic6() {
        Bag bag = exampleBag();
        int i;

        for (i = 1; i <= 9; i++)
            assertTrue(bag.contains(i));

        assertFalse(bag.contains(0));
        assertFalse(bag.contains(10));
    }

    @Test public void testPublic7() {
        Bag bag = exampleBag();
        // array element 0 is the number of occurrences of 1 in the example bag,
        // element 1 is the numebr of occurrences of 2 in the example bag, etc.
        int[] numOcurrences = {2, 1, 3, 1, 3, 1, 1, 1, 3};
        int i;

        for (i = 0; i < 9; i++)
            assertEquals(numOcurrences[i], bag.getCount(i + 1));
    }

    @Test public void testPublic8() {
        Bag bag = exampleBag();
        int[] numOcurrences = {1, 1, 2, 1, 3, 1, 1, 1, 3};
        int i;

        bag.remove(1);
        bag.remove(3);

        for (i = 0; i < 9; i++)
            assertEquals(numOcurrences[i], bag.getCount(i + 1));
    }

    @Test public void testPublic9() {
        Bag bag = exampleBag();

        bag.remove(5);
        bag.remove(5);
        bag.remove(5);

        assertFalse(bag.contains(5));
    }

    @Test public void testPublic10() {
        Bag bag = exampleBag();

        assertEquals(0, bag.getCount(10));
    }

    // private utility methods ////////////////////////////////////////////
    public Bag exampleBag() {
        Bag b = new Bag();

        for (int j : new int[] {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 7, 9, 3})
            b.add(j);

        return b;
    }
}
