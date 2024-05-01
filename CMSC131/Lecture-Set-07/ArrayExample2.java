public class ArrayExample2 {
	public static void main(String[] args) {
		int [] numArr = new int[100];

		for (int currPos = 1; currPos <= numArr.length; currPos++) {    // Doh!
			try {
				numArr[currPos] = 24;
				System.out.println("put 24 into position " + currPos);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("went too far");
			}
		}
	}
}
