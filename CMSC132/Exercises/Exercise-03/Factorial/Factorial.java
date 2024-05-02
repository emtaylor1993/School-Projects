package Factorial;

import java.util.NoSuchElementException;
import java.util.Iterator;

public class Factorial implements Iterable<Integer> {
	private int lowerLim, upperLim;

	public Factorial(int lowerLimit, int upperLimit) {
		lowerLim = lowerLimit;
		upperLim = upperLimit;
	}

	private class iterator2 implements Iterator<Integer> {
		public boolean hasNext() {
			if(lowerLim <= upperLim) {
				return true;
			} else {
				return false;
			}
		}

		public Integer next() {
			if(hasNext() == true) {
				int fact = 1;
				for(int g = lowerLim; g > 1; g--) {
					fact *= g;
				}
				lowerLim ++;
				return fact;
			} else {
				throw new NoSuchElementException();
			}
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	public String toString() {
		String val = "";
		iterator2 iterator3 = new iterator2();

		while(iterator3.hasNext()==true){
			val += iterator3.next() + " ";
		}

		return val;
	}

	public static void main(String args[]) {
		Factorial f= new Factorial(2, 5);
		System.out.println(f);  // calls toString()
	}

	@Override
	public java.util.Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return new iterator2();
	}
}
