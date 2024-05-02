/**
 * COSC600 Assignment 1, Problem #4 - Majority Element
 * @author Emmanuel Taylor
 * 
 * Description:
 *      Uses two algorithms designs, one O(Nlog(N)) and one O(N) to solve the
 *      Majority Element Problem for four sets of Arrays. The execution time
 *      for each algorithm will be calculated and compared.
 * 
 * Packages Used:
 *      BufferedReader, File, FileReader, IOException, ArrayList
 * 
 * Functions Called:
 *      readFile, getFrequency, findMajorityElement, mooresVotingAlgorithm
 * 
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MajorityElement {
    public static void main(String[] args) throws IOException {

        /*****************************************************
         * Majex1.txt
         ****************************************************/
        System.out.println("\n###################### Majex1 Example: ######################\n");
        int[] array = readFile("Majex1.txt");
        System.out.println("\nAlgorithm 1: O(Nlog(N))");
        long startTime = System.nanoTime();
        int majorityElement = findMajorityElement(array, 0, array.length);
        long stopTime = System.nanoTime();
        if (majorityElement == -1) {
            System.out.println("No Majority Element was found.");
        } else {
            System.out.println("The Majority Element is " + majorityElement);
        }        System.out.println("Time to execute was " + (stopTime - startTime) + " nanoseconds.\n");

        System.out.println("Algorithm 2: O(N)");
        startTime = System.nanoTime();
        majorityElement = mooresVotingAlgorithm(array);
        stopTime = System.nanoTime();
        if (majorityElement == -1) {
            System.out.println("No Majority Element was found.");
        } else {
            System.out.println("The Majority Element is " + majorityElement);
        }
        System.out.println("Time to execute was " + (stopTime - startTime) + " nanoseconds.\n");

        /*****************************************************
         * Majex2.txt
         ****************************************************/
        System.out.println("\n###################### Majex2 Example: ######################\n");
        array = readFile("Majex2.txt");
        System.out.println("\nAlgorithm 1: O(Nlog(N))");
        startTime = System.nanoTime();
        majorityElement = findMajorityElement(array, 0, array.length);
        stopTime = System.nanoTime();
        if (majorityElement == -1) {
            System.out.println("No Majority Element was found.");
        } else {
            System.out.println("The Majority Element is " + majorityElement);
        }        System.out.println("Time to execute was " + (stopTime - startTime) + " nanoseconds.\n");

        System.out.println("Algorithm 2: O(N)");
        startTime = System.nanoTime();
        majorityElement = mooresVotingAlgorithm(array);
        stopTime = System.nanoTime();
        if (majorityElement == -1) {
            System.out.println("No Majority Element was found.");
        } else {
            System.out.println("The Majority Element is " + majorityElement);
        }
        System.out.println("Time to execute was " + (stopTime - startTime) + " nanoseconds.\n");

        /*****************************************************
         * Majex3.txt
         ****************************************************/
        System.out.println("\n###################### Majex3 Example: ######################\n");
        array = readFile("Majex3.txt");
        System.out.println("\nAlgorithm 1: O(Nlog(N))");
        startTime = System.nanoTime();
        majorityElement = findMajorityElement(array, 0, array.length);
        stopTime = System.nanoTime();
        if (majorityElement == -1) {
            System.out.println("No Majority Element was found.");
        } else {
            System.out.println("The Majority Element is " + majorityElement);
        }        System.out.println("Time to execute was " + (stopTime - startTime) + " nanoseconds.\n");

        System.out.println("Algorithm 2: O(N)");
        startTime = System.nanoTime();
        majorityElement = mooresVotingAlgorithm(array);
        stopTime = System.nanoTime();
        if (majorityElement == -1) {
            System.out.println("No Majority Element was found.");
        } else {
            System.out.println("The Majority Element is " + majorityElement);
        }
        System.out.println("Time to execute was " + (stopTime - startTime) + " nanoseconds.\n");

        /*****************************************************
         * Majex4.txt
         ****************************************************/
        System.out.println("\n###################### Majex4 Example: ######################\n");
        array = readFile("Majex4.txt");
        System.out.println("\nAlgorithm 1: O(Nlog(N))");
        startTime = System.nanoTime();
        majorityElement = findMajorityElement(array, 0, array.length);
        stopTime = System.nanoTime();
        if (majorityElement == -1) {
            System.out.println("No Majority Element was found.");
        } else {
            System.out.println("The Majority Element is " + majorityElement);
        }        
        System.out.println("Time to execute was " + (stopTime - startTime) + " nanoseconds.\n");

        System.out.println("Algorithm 2: O(N)");
        startTime = System.nanoTime();
        majorityElement = mooresVotingAlgorithm(array);
        stopTime = System.nanoTime();
        if (majorityElement == -1) {
            System.out.println("No Majority Element was found.");
        } else {
            System.out.println("The Majority Element is " + majorityElement);
        }
        System.out.println("Time to execute was " + (stopTime - startTime) + " nanoseconds.\n");
    }

    /**
     * Function Name: readFile
     * 
     * @param filePath (File)
     * @throws IOException
     * @return         (int [])
     * 
     * Inside the Function:
     *  1. Create a File object out of the path given.
     *  2. Create a BufferedReader object to read File contents.
     *  3. Split each line by " " and store each element in an ArrayList.
     *  4. Convert ArrayList to an int[] array and return.
     */
    public static int[] readFile(String filePath) throws IOException {
        File file = new File(filePath);
        ArrayList<Integer> array = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String string;
        while ((string = reader.readLine()) != null) {
            System.out.println(string);
            String[] chars = string.split(" ");
            for (int index = 0; index < chars.length; index++) {
                array.add(Integer.parseInt(chars[index]));
            }
        }
        reader.close();
        return array.stream().mapToInt(i -> i).toArray();
    }
 
    /**
     * Function Name: getFrequency
     * @param array   (int[])
     * @param element (int)
     * @return        (int)
     * 
     * Inside the Function:
     *  1. Loops through the array and increments count whenever
     *     the element at the current index matches the element
     *     parameter.
     */
    public static int getFrequency(int array[], int element) {
        int count = 0;
        for (int index = 0; index < array.length; index++) {
            if (array[index] == element) {
                count++;
            }
        }
        return count;
    }

    /**
     * Function Name: findMajorityElement (O(Nlog(N)))
     * 
     * @param array (int[])
     * @param start (int)
     * @param stop  (int)
     * @return      (int)
     * 
     * Inside the Function:
     *  1. Calculate the size and midpoint of the array.
     *  2. Recursively call the findMajorityElement on each half of the array.
     *  3. Calculate the frequency of each majority term in each array half.
     *  4. Returns the majority element.
     */
    public static int findMajorityElement(int[] array, int start, int stop) {
        int n = stop - start;

        if (n == 1) {
            return array[start];
        }

        int k = n / 2;

        // Recursively call the findMajorityElement function on the left and
        // right halves of the array.
        int elemlsub = findMajorityElement(array, start, start + k);
        int elemrsub = findMajorityElement(array, start + k, stop);

        if (elemlsub == elemrsub) {
            return elemlsub;
        }

        // Calculates the number of times the majority element in each half
        // of the array occurs.
        int lcount = getFrequency(array, elemlsub);
        int rcount = getFrequency(array, elemrsub);

        if (lcount > array.length / 2) {
            return elemlsub;
        } else if (rcount > array.length / 2) {
            return elemrsub;
        } else {
            return -1;
        }
    }

    /**
     * Function Name: mooresVotingAlgorithm (O(N))
     * 
     * @param array (int[])
     * @return      (int)
     * 
     * Inside the Function:
     *  1. Initializes a counter and candidate.
     *  2. Increment/Decrement counter if the current element is
     *     equal to the stored candidate.
     *  3. If the counter reaches 0, store the new candidate.
     *  4. Count the frequency of the final candidate.
     */
    public static int mooresVotingAlgorithm(int[] array) {
        int majorityIndex = 0;
        int count = 0;

        // Moore's Voting Algorithm.
        for (int index = 0; index < array.length; index++) {
            if (array[majorityIndex] == array[index]) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                majorityIndex = index;
                count = 1;
            }
        }

        // Moore's Voting Algorithm Verification Step.
        count = 0;
        for (int index = 0; index < array.length; index++) {
            if (array[majorityIndex] == array[index]) {
                count++;
            }
        }

        if (count > (array.length / 2)) {
            return array[majorityIndex];
        } else {
            return -1;
        }
    }
}
