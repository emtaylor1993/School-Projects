/*
 * Name: Emmanuel Taylor
 * Discussion Section: Section 0202
 * Student ID Number: 111615834
 * Student Terpconnect Login ID: etaylor5
 */

/*
 * The purpose of this class is to create a collection of tests that test 
 * different scenarios beyond public tests in order to pass the Secret Tests
 * that are given for the project.
 */

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class StudentTests {
	// tests calling haveSameKeys() on two trees.
	@Test public void testHaveSameKeys(){
		Tree<Character, Integer> nonEmptyTree = studentTree1();
		Tree<Character, Integer> nonEmptyTree2 = studentTree2();
		Tree<Character, Integer> smallTree = studentTree3();

		assertTrue(nonEmptyTree.haveSameKeys(nonEmptyTree2));
		assertFalse(nonEmptyTree.haveSameKeys(smallTree));
	}
	
	// tests calling haveSameKeys() on an empty tree.
	@Test public void testHaveSameKeysEmptyTree(){
		Tree<Integer, Character> newTree = studentTree5();

		assertEquals("", newTree.toString());
	}

	// tests calling max() on an empty tree.
	@Test public void testMax() {
		Tree<Integer, Character> newTree = studentTree5();
		try {
			assertEquals((Character) 'l', newTree.max());
		} catch (EmptyTreeException error) {

		}
	}

	// tests calling min() on an empty tree.
	@Test public void testMin() {
		Tree<Integer, Character> newTree = studentTree5();
		try {
			assertEquals((Character) 't', newTree.min());
		} catch (EmptyTreeException error) {

		}
	}

	// tests calling pathToRoot() on different sized trees.
	@Test public void testPathToRoot(){
		Tree<Integer, Character> newTree = studentTree4();
		ArrayList<Integer> list = new ArrayList<Integer>();

		newTree.pathToRoot(5, list);
		assertEquals("[5, 4, 2]", list.toString());
	}

	// tests calling pathToRoot() on an empty tree.
	@Test public void testPathToRootEmptyTree(){
		Tree<Integer, Character> newTree = studentTree5();
		ArrayList<Integer> list = new ArrayList<Integer>();

		newTree.pathToRoot(5, list);
		assertEquals("[]", list.toString());
	}

	// tests calling pathFromRoot() on different sized trees.
	@Test public void testPathFromRoot(){
		Tree<Integer, Character> newTree = studentTree4();
		ArrayList<Integer> list = new ArrayList<Integer>();

		newTree.pathFromRoot(4, list);
		assertEquals("[2, 4]", list.toString());
	}

	// tests calling pathToRoot() on an empty tree.
	@Test public void testPathFromRootEmptyTree(){
		Tree<Integer, Character> newTree = studentTree5();
		ArrayList<Integer> list = new ArrayList<Integer>();

		newTree.pathFromRoot(4, list);
		assertEquals("[]", list.toString());
	}


	// tests calling clone() on a tree created.
	@Test public void testClone(){
		Tree<Integer, Character> newTree = studentTree4();

		Tree<Integer, Character> cloneTree = newTree.clone();
		assertEquals("1=>b 2=>a 3=>e 4=>c 5=>d", cloneTree.toString());
	}

	// tests removing subtrees in different cases.
	@Test public void testRemoveSubTree() {
		Tree<Integer, String> newTree = studentTree6();

		assertTrue(newTree.removeSubTree(0).toString().equals(""));
	}

	// tests removeSubTree() on an empty tree.
	@Test public void testRemoveSubTreeEmptyTree(){
		Tree<Integer, String> newTree = studentTree7();

		assertTrue(newTree.removeSubTree(0).toString().equals(""));
	}

	// private utility methods ////////////////////////////////////////////

	// returns a tree with multiple keys and values in characters and integers.
	private static Tree<Character, Integer> studentTree1() {
		Tree<Character, Integer> tree = EmptyTree.getInstance();
		tree = tree.add('c', 1);
		tree = tree.add('o', 2);
		tree = tree.add('m', 3);
		tree = tree.add('p', 4);
		tree = tree.add('u', 5);
		tree = tree.add('t', 6);
		tree = tree.add('e', 7);
		tree = tree.add('r', 8);
		tree = tree.add('i', 9);
		tree = tree.add('z', 10);
		tree = tree.add('a', 11);
		tree = tree.add('b', 12);
		tree = tree.add('l', 13);
		tree = tree.add('y', 14);
		return tree;
	}

	// returns a tree with multiple keys and values in characters and integers.
	private static Tree<Character, Integer> studentTree2() {
		Tree<Character, Integer> tree = EmptyTree.getInstance();
		tree = tree.add('b', 12);
		tree = tree.add('p', 4);
		tree = tree.add('c', 1);
		tree = tree.add('y', 14);
		tree = tree.add('o', 2);
		tree = tree.add('m', 3); 
		tree = tree.add('r', 8);
		tree = tree.add('u', 5);
		tree = tree.add('t', 6);	
		tree = tree.add('i', 9);
		tree = tree.add('z', 10);
		tree = tree.add('e', 7);
		tree = tree.add('a', 11); 
		tree = tree.add('l', 13);
		return tree;
	}

	// returns a tree with multiple keys and values in characters and integers.
	private static Tree<Character, Integer> studentTree3() {
		Tree<Character, Integer> tree = EmptyTree.getInstance();
		tree = tree.add('w', 1);
		tree = tree.add('x', 2);
		tree = tree.add('y', 3);
		tree = tree.add('z', 4);
		tree = tree.add('v', 5);
		return tree;
	}

	// returns a tree with multiple keys and values in characters and integers.	
	private static Tree<Integer, Character> studentTree4() {
		Tree<Integer, Character> tree = EmptyTree.getInstance();
		tree = tree.add(2, 'a');
		tree = tree.add(1, 'b');
		tree = tree.add(4, 'c');
		tree = tree.add(5, 'd');
		tree = tree.add(3, 'e');
		return tree;
	}

	// returns an empty tree with no values or keys.	
	private static Tree<Integer, Character> studentTree5(){
		Tree<Integer, Character> tree = EmptyTree.getInstance();
		return tree;
	}

	// returns a tree with multiple keys and values in characters and strings.
	private static Tree<Integer, String> studentTree6(){
		Tree<Integer, String> tree = EmptyTree.getInstance();
		tree = tree.add(0, "Yo!");
		tree = tree.add(1, "hello");
		tree = tree.add(2, "hi");
		tree = tree.add(3, "what's up");
		tree = tree.add(4, "how are you?");
		return tree;
	}

	// returns an empty tree with no values or keys with type string.
	private static Tree<Integer, String> studentTree7(){
		Tree<Integer, String> tree = EmptyTree.getInstance();
		return tree;
	}
}