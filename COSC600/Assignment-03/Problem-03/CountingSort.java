/**
 * COSC600 Assignment 3, Problem #3 - Counting Sort
 * @author Emmanuel Taylor
 * 
 * Description:
 *      This program will perform a non-traditional counting sort algorithm on
 *      an array of 5_000 random numbers betwen 0 to 500.
 * 
 * Packages Used:
 *      Java Utilities (Arrays, Collections)
 * 
 * Functions Called:
 *      randomInt, countingSort
 * 
 * Citations:
 *      https://www.geeksforgeeks.org/counting_sort/
 */
import java.util.Arrays;
import java.util.Collections;

public class CountingSort {
    final static int ARRAY_SIZE = 5_000;
    
    public static void main(String[] args) {
        Integer[] array = new Integer[ARRAY_SIZE];

        // Populating array with random numbers between 0 and 500.
        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = randomInt();
        }

        // Performing counting sort algorithm.
        long startTime = System.nanoTime();
        Integer[] result = countingSort(array);
        long stopTime = System.nanoTime();

        System.out.println("##################################################");
        System.out.println("#                  COUNTING SORT                 #");
        System.out.println("##################################################\n");
       
        System.out.println("Printing every 100th element:\n");
       
        // Printing out every 100th element.
        for (int i = 0; i < ARRAY_SIZE; i++) {
            if (i % 100 == 0) {
               if (i % 1000 == 0 && i != 0) {
                    System.out.println();
                }
                System.out.print(result[i] + ", ");
            }
        }

        // Printing out execution time.
        System.out.println("\n\nExecution Time: " + (stopTime - startTime) + " nanoseconds.\n");
    }

    /**
     * Function Name: randomInt
     * @return (int)
     * 
     * Inside the Function:
     *  1. Generate and return a random number from 0 to 500.
     */
    public static int randomInt() {
        return (int) (Math.random() * 500);
    }

    /**
     * Function Name: countingSort
     * @param array (Integer[])
     * @return      (Integer[])
     * 
     * Inside the Function:
     *  1. Create countArray to count frequency of each element in the array.
     *  2. Based on the frequency and position, build resultArray.
     *  3. Return result array.
     * 
     * Citation: https://www.geeksforgeeks.org/counting_sort/
     */
    public static Integer[] countingSort(Integer[] array) {
        int maxElement = Collections.max(Arrays.asList(array));
        Integer[] countArray = new Integer[maxElement + 1];
        Integer[] resultArray = new Integer[ARRAY_SIZE];
        
        // Initializing the countArray with 0s.
        Arrays.fill(countArray, 0);

        // Mapping each element of the array as an index of countArray.
        for (int i = 0; i < ARRAY_SIZE; i++) {
            countArray[array[i]]++;
        }

        // Calculating prefix sum at every index of countArray.
        for (int i = 1; i <= maxElement; i++) {
            countArray[i] += countArray[i - 1];
        }

        // Building resultArray using the frequency at each index in countArray.
        for (int i = ARRAY_SIZE - 1; i >= 0; i--) {
            resultArray[countArray[array[i]] - 1] = array[i];
            countArray[array[i]]--;
        }
 
        return resultArray;
    }
}
