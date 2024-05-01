public class StringMethods {
	/** Use the String library methods to 
	 * implement the following methods
	 * then test them with the junit tests
	 * enclosed and your own
	 * Do not just use loops and character by character
	 * traversal if it can be avoided - make use of the 
	 * string library methods whenever possible.
	 */
	
	/** 
	 * returns the true if character indicated by value appears
	 * in the String passed as the first parameter 
	 * and false if it does not.
	 *  
	 * @param s is the string to be searched through 
	 * @param value the character you want to locate in the string
	 * @return true if it is there or false if it is not
	 */
	public static boolean isThere(String s, char value) {
		if((s.indexOf(value) == -1)){
			return false;
		} else {
			return true;
		}
	}	
	
	/** 
	 * returns the number of times the character
	 * indicated by value appears in the String
	 * passed as the first parameter
	 * 
	 * @param s is the string of characters you'll search through
	 * @param value the character you want to find in the string
	 * @return the count of how many times that character appears
	 */
	public static int count(String s, char value) {
		int count = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == value) {
				count++;
			}
		}
		
		return count;
	}
	
	/**
	 * If the parameter passed does not contain a 
	 * plus sign or a minus sign, return the value -1.
	 * If the string does contain a plus sign or a minus sign,
	 * you can assume it has a positive double before 
	 * and a positive double after
	 * (there might also be spaces as appropriate).
	 * @param s the string hopefully of the form number+number or number-number
	 * for example: 1.23+4.56 (possibly 
	 * with spaces (but not in the middle of a number))
	 * @return the value of the expression (so for this example 5.79)
	 */
	public static double returnValue(String s) {
		return -1;
	}
}
