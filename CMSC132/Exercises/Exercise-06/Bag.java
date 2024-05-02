import java.util.HashMap;
import java.util.Set;

public class Bag {	
	HashMap<Integer, Integer> bag = new HashMap<Integer, Integer>();

	public void add(int elt) {
		if (!bag.containsKey(elt)) {
			bag.put(elt, 1);
		} else if (bag.containsKey(elt)) {
			int current = bag.get(elt);
			bag.put(elt, current + 1);
		}
	}

	public boolean contains(int elt) {
		return bag.containsKey(elt);
	}

	public int getCount(int elt) {
		if (bag.containsKey(elt)) {
			return bag.get(elt);
		} else {
			return 0;
		}
	}

	public int size() {
		int index = 0;
		for (Integer a : bag.keySet()) {
			index += bag.get(a);
		}
		
		return index;
	}

	public Set<Integer> uniqueElements() {
		return bag.keySet();
	}

	public void remove(int elt) {
		if (bag.containsKey(elt)) {
			int current = bag.get(elt);
			if (current > 1) {
				bag.put(elt, current - 1);
			} else
				bag.remove(elt);
		}
	}
}