public class SortArguments {	
	public static void main(String[] args) {
		System.out.println("Original: ");
		
		for (int i = 0; i < args.length; i++) {
			System.out.print(args[i] + " ");
		}
		
		System.out.println();
		String[][] sortedArr = sortByType(args);
		System.out.println("Organized:");

		for (int row = 0; row < sortedArr.length; row++) {
			if (sortedArr[row] != null) {
				for (int col = 0; col < sortedArr[row].length; col++) {
					System.out.print(sortedArr[row][col]+ " ");
				}
			}
			
			System.out.println();
		}
	}

	private static String[][] sortByType(String[] list) {
		int index = 0;
		String[] keyWords = {"for", "while", "public", "System"};
		String[][] masterList = new String[4][];
		
		for (int i = 0; i < list.length; i++) {
			char firstChar = list[i].charAt(0);
			
			if (isIn(list[i],keyWords)) {
				index = 0;
			} else if ((firstChar >= 'A' && firstChar <= 'Z') || (firstChar >='a' && firstChar <= 'z')) {
				index = 1;
			} else if (firstChar >= '0' && firstChar <= '9') {
				index = 2;
			} else {
				index = 3;
			}
			
			masterList[index] = addToList(list[i], masterList[index]);
		}

		return masterList;
	}
	
	private static boolean isIn(String word, String[] list) {
		for (int i = 0; i < list.length; i++) {
			if (word.equals(list[i])) {
				return true;
			}
		}
		
		return false;
	}
	
	private static String[] addToList(String word, String[] arr) {
		if (arr == null) {
			arr = new String[1];
			arr[0] = word;
		} else {
			String[] temp = new String[arr.length + 1];
			
			for (int i = 0; i < arr.length; i++) {
				temp[i] = arr[i];
			}
			
			arr = temp;
			arr[arr.length - 1] = word;
		}
		
		return arr;
	}
}