import java.util.*;

public class RecursiveListMethods {
	private static <T> List<T> duplicateFirstHelper(List<T> list, int ind) {
		if (ind > list.size() - 1) {
			return list;
		} else{
			list.set(ind, list.get(0));
			return duplicateFirstHelper(list, ind + 1);
		}
	}

	public static <T> void duplicateFirst(List<T> list) {
		if (list == null) {
			throw new NullPointerException();
		}

		if(list.isEmpty()){
		} else{
			list = duplicateFirstHelper(list, 0);
		}
	}

	private static <T> List<T> duplicateLastHelper(List<T> list, int ind) {
		if (ind < 0) {
			return list;
		} else {
			list.set(ind, list.get(list.size()-1));
			return duplicateLastHelper(list, ind - 1);
		}
	}

	public static <T> void duplicateLast(List<T> list) {
		if (list == null) {
			throw new NullPointerException();
		}

		if (list.isEmpty()) {
		} else{
			list = duplicateLastHelper(list, list.size() - 1);
		}
	}

	private static <T> boolean anyDuplicatesHelper(List<T> list, int ind) {
		if (ind == list.size() - 1) {
			return false;
		}

		ArrayList<T> aList = new ArrayList<T>();
		aList.addAll(list);
		aList.remove(list.get(ind));

		if (aList.contains(list.get(ind))) {
			return true;
		} else {
			return anyDuplicatesHelper(list, ind + 1);
		}
	}

	public static <T> boolean anyDuplicates(List<T> list) {
		if (list == null) {
			throw new NullPointerException();
		}

		if (list.isEmpty()) {
			return true;
		} else {
			return anyDuplicatesHelper(list, 0);
		}
	}

	private static <T extends Comparable<T>> T findLargestHelper(List<T> list, int ind, T large) {
		if (ind > list.size() - 1) {
			return large;
		} else {
			if (list.get(ind).compareTo(large) >= 0) {
				return findLargestHelper(list, ind + 1, list.get(ind));
			} else {
				return findLargestHelper(list, ind + 1, large);
			}
		}
	}

	public static <T extends Comparable<T>> T findLargest(List<T> list) {
		if (list == null) {
			throw new NullPointerException();
		}

		if (list.isEmpty()) {
			throw new NoSuchElementException();
		}

		return findLargestHelper(list, 0, list.get(0));
	}
}