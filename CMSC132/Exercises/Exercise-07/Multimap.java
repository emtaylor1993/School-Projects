import java.util.*;

public class Multimap {
	Map<Character, ArrayList<Integer>> maps = new HashMap<Character, ArrayList<Integer>>();

	public void put(Character key, Integer value) {
		ArrayList<Integer> values = new ArrayList<Integer>();
		if (maps.containsKey(key)) {
			maps.get(key).add(value);
		} else {
			values.add(value);
			maps.put(key, values);
		}
	}

	public List<Integer> get(Object key) {
		if (maps.containsKey(key)) {
			return maps.get(key);
		} else {
			return null;
		}
	}

	public int size() {
		int count = 0;
		for (ArrayList<Integer> x: maps.values()) {
			count += x.size();
		}
		
		return count;
	}

	public void remove(Character key, Integer value) {
		if (maps.containsKey(key) && maps.get(key).contains(value)) {
			if (maps.get(key).size() == 1) {
				maps.remove(key);
			} else {
				maps.get(key).remove(value);
			}
		}
	}
}