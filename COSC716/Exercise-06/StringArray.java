/**
 * @author Emmanuel Taylor
 * @author Leo Tangban
 * @author Vincent Gruse
 * 
 * @description
 *      This class will demonstrate using a custom iterator to iterate through
 *      a StringArray.
 * 
 * @packages
 *      Java Utilities (Iterator)
 */

 import java.util.Iterator;

public class StringArray implements Iterable<String> {
    private String[] values;

    /**
     * Constructor Name: StringArray
     * @param values (String[])
     * 
     * Creates a constructor for the StringArray class.
     */
    public StringArray(String[] values) {
        this.values = values;
    }

    /**
     * Function Name: iterator()
     * @return ArrayIterator (Iterator<String>)
     * 
     * Returns an instance of the ArrayIterator class.
     */
    @Override
    public Iterator<String> iterator() {
        return new ArrayIterator();
    }

    /**
     * Class Name: ArrayIterator
     * 
     * Inner class that will implement the iterator interface for 
     * traversing through the StringArray.
     */
    private class ArrayIterator implements Iterator<String> {
        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < values.length;
        }

        @Override
        public String next() {
            return values[current++];
        }
    }

    /**
     * Class Name: LongStringIterator
     * 
     * Inner class that will implement the iterator interface for
     * traversing through the StringArray and excluding each string
     * that is not at least 4 characters long.
     */
    private class LongStringIterator implements Iterator<String> {
        private int current = 0;

        @Override
        public boolean hasNext() {
            while (current < values.length) {
                if (values[current].length() >= 4) {
                    return true;
                }
                current++;
            }

            return false;
        }

        @Override
        public String next() {
            return values[current++];
        }
    }

    /**
     * Function Name: getLongStringIterator
     * @return LongStringIterator (Iterator<String>)
     * 
     * Returns an instance of the longStringIterator.
     */
    public Iterator<String> getLongStringIterator() {
        return new LongStringIterator();
    }

    public static void main(String[] args) {
        String[] strings = {"one", "two", "three", "four", "five"};
        StringArray stringArray = new StringArray(strings);

        System.out.println("Using ArrayIterator: ");
        for (String s : stringArray) {
            System.out.println(s);
        }

        System.out.println("\nUsing LongStringIterator: ");
        Iterator<String> longStringIterator = stringArray.getLongStringIterator();
        while (longStringIterator.hasNext()) {
            System.out.println(longStringIterator.next());
        }
    }
}
