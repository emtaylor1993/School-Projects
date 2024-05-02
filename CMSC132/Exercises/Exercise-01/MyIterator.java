import java.util.Iterator; 
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MyIterator implements Iterator <Student> {
	private int count;
	private ArrayList <Student> it;
	
	public MyIterator(ArrayList<Student> studentList){
		it = studentList;
	}

	public boolean hasNext() {
		if (count == it.size())
			return false;
		else
			return true;
	}

	public Student next() {
		if(hasNext()){
			count++;
			return it.get(count - 1);
		} else {
			throw new NoSuchElementException();
		}
	}
	
	public void remove() {
		it.remove(it.size());
	}
}