import java.util.Stack;

public class AlphabeticalStringList {
	private Stack<String> s;

	public AlphabeticalStringList() {
		s = new Stack<String>();
	}

	public void add(String toAdd) {
		Stack<String> temp = new Stack<String>();
		if (s.size() == 0) {
			s.add(toAdd);
		} else {
			while (s.peek().compareTo(toAdd) > 0) {
				temp.push(s.pop());
			}
			
			s.push(toAdd);
		}
		
		while (temp.size() > 0) {
			s.push(temp.pop());
		}
	}
	
	public int remove(String toRemove) {
		int index = s.indexOf(toRemove);
		s.remove(toRemove);
		return index;
	}
	
	public String toString() {
		String value;
		if (s == null) {
			value = "";
		} else {
			value = "AB";
		}
		
		return value;
	} 
}