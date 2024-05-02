/*
 * Name: Emmanuel Taylor
 * Discussion Section: Section 0202
 * Student ID Number: 111615834
 * Student Terpconnect Login ID: etaylor5
 */

/*
 * The purpose of this class is to represent a Binary Search Tree that is 
 * empty. The methods used in this class are used to manipulate the tree and 
 * the contents of the tree such as removing subtrees with certain values or 
 * checking the paths from two different keys. This class contains references
 * to a root key with a value, and references to right and left trees that 
 * contain keys/values.
 */

import java.util.List;

public class EmptyTree<K extends Comparable<K>, V> implements Tree<K, V> {
	/*
	 * Instance variables for the constructor
	 */
	private static EmptyTree SINGLETON = new EmptyTree();
	private V value;
	private K root;

	/*
	 * This method returns a reference to the unique instance of the class. 
	 */
	@SuppressWarnings("unchecked")
	public static <K extends Comparable<K>, V> EmptyTree<K, V> getInstance() {
		return SINGLETON;
	}

	private EmptyTree(){
		//Empty constructor.
	}

	/*
	 * (non-Javadoc)
	 * @see tree.Tree#add(java.lang.Comparable, java.lang.Object)
	 * This method adds keys to the current tree object that corresponds to 
	 * value. If they key already exists, it will be replaced by the new value
	 * without affecting the rest of the tree. 
	 */
	public NonEmptyTree<K, V> add(K key, V value) {
		return new NonEmptyTree<K, V>(key, value, null, null);
	}

	/*
	 * (non-Javadoc)
	 * @see tree.Tree#lookup(java.lang.Comparable)
	 * This methods finds the value that the key is corresponding to. Returns 
	 * null if they key isn't associated with any value.
	 */
	public V lookup(K key) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see tree.Tree#size()
	 * This method returns the number of keys and value pairs that are present
	 * and will return 0 for the EmptyTree class.
	 */
	public int size() {
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * @see tree.Tree#max()
	 * This method returns the largest key in a tree. If the tree is empty,
	 * an EmptyTreeException will be thrown stating that the tree has no
	 * contents.
	 */
	public K max() throws EmptyTreeException {
		throw new EmptyTreeException();
	}

	/*
	 * (non-Javadoc)
	 * @see tree.Tree#min()
	 * This method returns the smallest tree in a tree. If the tree is empty,
	 * an EmptyTreeException will be thrown stating that the tree has no
	 * contents.
	 */
	public K min() throws EmptyTreeException {
		throw new EmptyTreeException();
	}

	/*
	 * (non-Javadoc)
	 * @see tree.Tree#delete(java.lang.Comparable)
	 * This method removes the key and value associated with that key which is
	 * called upon. Since there are never any duplicate keys, there will only
	 * be one matching key at most. Since this class is already empty, this is
	 * returned.
	 */
	public Tree<K, V> delete(K key) {
		return this;
	}

	/*
	 * (non-Javadoc)
	 * @see tree.Tree#removeSubTree(java.lang.Comparable)
	 * This method should remove the key/value pair that is called upon, and
	 * the entire subtree of that pair if they contain one. If the called key/
	 * value pair is the root, the tree will transform into an EmptyTree.
	 */
	public Tree<K, V> removeSubTree(K key) {
		return this;
	}

	/*
	 * (non-Javadoc)
	 * @see tree.Tree#haveSameKeys(tree.Tree)
	 * This method returns true if the tree object and otherTree have the same
	 * exact keys, and false if they do not. Values do not matter, but each
	 * tree should have only the exact same keys.
	 */
	public boolean haveSameKeys(Tree<K, V> otherTree) {
		if (otherTree.size() == 0) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see tree.Tree#pathFromRoot(java.lang.Comparable, java.util.List)
	 * If they key exists in the current object tree, this method will remove
	 * current contents of the parameter list and make it contain a list of all
	 * the keys between root and key. If the root is the key, the list will 
	 * contain only that single key.
	 */
	public void pathFromRoot(K key, List<K> list) {
		return;
	}

	/*
	 * (non-Javadoc)
	 * @see tree.Tree#pathToRoot(java.lang.Comparable, java.util.List)
	 * This method will return the exact reverse of what the pathFromRoot()
	 * method will return.
	 */
	public void pathToRoot(K key, List<K> list) {
		return;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "";
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 * Because the Tree interface implements the cloneable interface, the
	 * clone() method must create a reference the the new Tree's object and 
	 * whose contents and shape are exactly the same and return it.
	 */
	public EmptyTree<K, V> clone() {
		return this;
	}
}