import java.util.ArrayList;
import java.util.Collections;

public class ArrayListExample {
	public static void main(String[] args) {
		ArrayList<String> a = new ArrayList<String>();
		final String[] words = {"cat", "dog", "cow", "pig", "monkey", "ostrich", "fish", "rhino", "duck", "human"};
		
		for (int i = 0; i < words.length; i++) {
			a.add(0,words[i]);
		}
		
		System.out.println("Here is the original list:  ");
		System.out.println(a);
		
		String itemRemoved = a.remove(2);
		System.out.println("Here is the list without " + itemRemoved);
		System.out.println(a);
		
		System.out.println("Let's randomize the list:  ");
		Collections.shuffle(a);
		System.out.println(a);
		
		System.out.println("Let's sort the list: ");
		Collections.sort(a);
		System.out.println(a);
	}
}
