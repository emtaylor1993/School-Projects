/**
 * LONGEST COMMON PREFIX STRING
 * 
 * @author Emmanuel Taylor
 * 
 * @description
 *    This class will find the longest common prefix string amongst
 *    an array of strings.
 * 
 * @packages
 *    Java Utilities (Arrays)
 */

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] firstCase = {"flower", "flow", "flight"};
        String[] secondCase = {"dog", "racecar", "car"};
        String[] thirdCase = {"cat", "category", "catch"};

        System.out.println("Input: " + Arrays.toString(firstCase) + "\tOutput: \"" + longestCommonPrefix(firstCase) + "\"");
        System.out.println("Input: " + Arrays.toString(secondCase) + "\tOutput: \"" + longestCommonPrefix(secondCase) + "\"");
        System.out.println("Input: " + Arrays.toString(thirdCase) + "\tOutput: \"" + longestCommonPrefix(thirdCase) + "\"");
    }

    /**
     * Function Name: longestCommonPrefix
     * @param strings (String[])
     * @return        (String)
     * 
     * This function will compare the prefix with each string in the array, reducing it 
     * until it matches the beginning of the current string.
     */
    public static String longestCommonPrefix(String[] arr) {
        String prefix = arr[0];

        for (int i = 1; i < arr.length; i++) {
            while (arr[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }
}