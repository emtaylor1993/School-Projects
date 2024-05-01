import java.util.ArrayList;

public class DoNotTryRemoveInsideForEachLoop {
	public static void main(String[] args) {
		String[] sArray = {"cat", "dog", "bird", "ox", "tiger", "ostrich"};

		ArrayList<Person> myList= new ArrayList<Person>();
		System.out.println("Trying with for loop:");
		ArrayList<String> a1 = new ArrayList<String>();
		
		for (int i = 0; i < sArray.length; i++) {
			a1.add(sArray[i]);
		}
		
		System.out.println("all there: " + a1);
		a1.remove("dog");
		System.out.println("dog removed: " + a1);
		System.out.println("removing short ones");
		
		for (int i = 0; i < a1.size();) {
			String s = a1.get(i);
			
			if (s.length() < 4) {
				a1.remove(s);
			} else {
				i++;
			}
		}
		
		System.out.println("after remove: " + a1);		
		System.out.println("\nNow trying with foreach:");
		ArrayList<String> a2 = new ArrayList<String>();
		
		for (String s : sArray) {
			a2.add(s);
		}
		
		System.out.println("all there: " + a2);
		a2.remove("dog");
		System.out.println("dog removed: " + a2);
		System.out.println("removing short ones");
		
		for (String s : a2) {
			if (s.length() < 4) {
				s = null;
			}
		}
		
		System.out.println("after remove: " + a2);
	}
}
