import java.util.List;
import java.util.Collections;
import org.junit.*;
import static org.junit.Assert.*;

public class PublicTests {
    @Test public void testPublic1() {
        Multimap mmap = new Multimap();

        mmap.put('C', 132);

        assertEquals(1, mmap.size());
    }

    @Test public void testPublic2() {
        Multimap mmap = new Multimap();

        mmap.put('C', 131);
        mmap.put('M', 132);

        assertEquals(2, mmap.size());
    }

    @Test public void testPublic3() {
        Multimap mmap = new Multimap();

        mmap.put('C', 132);

        assertEquals("[132]", getValuesForKeys(mmap, new char[]{'C'}));
    }

    @Test public void testPublic4() {
        Multimap mmap = new Multimap();

        mmap.put('C', 131);
        mmap.put('M', 132);

        assertEquals("[131]", getValuesForKeys(mmap, new char[]{'C'}));
        assertEquals("[132]", getValuesForKeys(mmap, new char[]{'M'}));
    }

    @Test public void testPublic5() {
        Multimap mmap = new Multimap();

        mmap.put('X', 131);
        mmap.put('X', 250);
        mmap.put('X', 132);

        assertEquals("[131, 132, 250]", getValuesForKeys(mmap, new char[]{'X'}));
    }

    @Test public void testPublic6() {
        Multimap mmap = exampleMultimap();

        assertEquals("[1, 1, 3, 4], [5], [2, 5, 6, 9], [3, 5, 8, 9], [7, 9]", getValuesForKeys(mmap, new char[]{'g', 'r', 'a', 'p', 'e'}));
    }

    @Test public void testPublic7() {
        Multimap mmap = exampleMultimap();

        assertEquals("[2, 5, 6, 9], [3, 5, 8, 9], [7, 9], [5], [1, 1, 3, 4]", getValuesForKeys(mmap, new char[]{'a', 'p', 'e', 'r', 'g'}));
    }

    @Test public void testPublic8() {
        Multimap mmap = exampleMultimap();

        assertEquals(15, mmap.size());
    }

    @Test public void testPublic9() {
        Multimap mmap = exampleMultimap();

        mmap.remove('g', 1);
        mmap.remove('g', 4);
        mmap.remove('p', 9);
        mmap.remove('e', 7);

        assertEquals("[1, 3], [5], [2, 5, 6, 9], [3, 5, 8], [9]", getValuesForKeys(mmap, new char[]{'g', 'r', 'a', 'p', 'e'}));
    }

    @Test public void testPublic10() {
        Multimap mmap = exampleMultimap();

        mmap.remove('g', 1);
        mmap.remove('g', 4);
        mmap.remove('r', 5);
        mmap.remove('p', 9);
        mmap.remove('e', 7);
        mmap.remove('e', 9);

        assertEquals("[1, 3], [2, 5, 6, 9], [3, 5, 8]", getValuesForKeys(mmap, new char[]{'g', 'r', 'a', 'p', 'e'}));
    }

    // private utility methods ////////////////////////////////////////////
    public Multimap exampleMultimap() {
        Multimap mmap = new Multimap();
        int i;
        char[] keys = {'g', 'r', 'a', 'p', 'e'};
        int[][] values = {{3, 1, 4, 1},
            {5},
            {9, 2, 6, 5},
            {3, 8, 5, 9},
            {7, 9}};

        for (i = 0; i < keys.length; i++)
            for (int j : values[i])
                mmap.put(keys[i], j);

        return mmap;
    }

    // a utility routine to avoid repeating code; returns a string with all
    // the values associated with the keys in the paramter array, in sorted
    // order
    private String getValuesForKeys(Multimap m, char[] keys) {
        List<Integer> c;
        int i;
        String result = "";

        for (i = 0; i < keys.length; i++) {
            c = m.get(keys[i]);
            if (c != null) {
                Collections.sort(c);
                if (i > 0)
                    result += ", ";
                result += c;
            }
        }

        return result;
    }
}