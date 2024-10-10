/**
 * @author Emmanuel Taylor
 * @author Leo Tangban
 * @author Vincent Gruse
 * 
 * @description
 *      This class will demonstrate using Java's built in iterator to iterate
 *      through an ArrayList and a TreeSet.
 * 
 * @packages
 *      Java Utilities (ArrayList, Iterator, TreeSet)
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class InClassExercise {
    public static void main(String[] args) {
        ArrayList<String> stringArrayList = new ArrayList<String>();
        stringArrayList.add("one");
        stringArrayList.add("two");
        stringArrayList.add("three");
        stringArrayList.add("four");
        stringArrayList.add("five");

        System.out.println("Printing the result of the stringArrayList");
        for (int i = 0; i < stringArrayList.size(); i++) {
            System.out.println(stringArrayList.get(i));
        }

        System.out.println("\nUsing an iterator for ArrayList");
        Iterator<String> iterator = stringArrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        TreeSet<String> stringTreeSet = new TreeSet<String>();
        stringTreeSet.add("one");
        stringTreeSet.add("two");
        stringTreeSet.add("three");
        stringTreeSet.add("four");
        stringTreeSet.add("five");

        System.out.println("\nUsing an iterator for TreeSet");
        Iterator<String> treeSetIterator = stringTreeSet.iterator();
        while (treeSetIterator.hasNext()) {
            System.out.println(treeSetIterator.next());
        }
    }
}