/**
 * COSC600 Assignment 3, Problem #4 - Radix Sort
 * @author Emmanuel Taylor
 * 
 * Description:
 *      This program will perform a non-traditional counting sort algorithm on
 *      an array of 5_000 random numbers betwen 0 to 50_000.
 * 
 * Packages Used:
 *      Java Utilities (Arrays, Collections)
 * 
 * Functions Called:
 *      randomInt, radixSort, countingSort
 * 
 * Citations:
 *      https://www.geeksforgeeks.org/radix-sort/
 */
import java.util.Arrays;
import java.util.Collections;

public class RadixSort {
    final static int ARRAY_SIZE = 5_000;
    
    public static void main(String[] args) {
        Integer[] array = new Integer[ARRAY_SIZE];

        // Populating array with random numbers between 0 and 50_000.
        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = randomInt();
        }

        // Performing radixSort algorithm.
        long startTime = System.nanoTime();
        radixSort(array);
        long stopTime = System.nanoTime();

        System.out.println("##################################################");
        System.out.println("#                   RADIX SORT                   #");
        System.out.println("##################################################\n");

        // Printing out the first 100 elements.
        System.out.println("First 100 elements:");
        for (int i = 0; i < 100; i++) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.print(array[i] + ", ");
        }

        // Printing out the final 100 elements.
        System.out.println("\n\nFinal 100 elements:");
        for (int i = ARRAY_SIZE - 100; i < ARRAY_SIZE; i++) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.print(array[i] + ", ");
        }

        // Printing out execution time.
        System.out.println("\n\nExecution Time: " + (stopTime - startTime) + " nanoseconds.\n");
    }

    /**
     * Function Name: randomInt
     * @return (int)
     * 
     * Inside the Function:
     *  1. Generate and return a random number from 0 to 50_000.
     */
    public static int randomInt() {
        return (int) (Math.random() * 50_000);
    }

    /**
     * Function Name: radixSort
     * @param array (Integer[])
     * 
     * Inside the Function:
     *  1. Calculate the maximum number to get number of digits.
     *  2. Perform a countingSort on every digit of the number.
     * 
     * Citations: https://www.geeksforgeeks.org/radix-sort/
     */
    public static void radixSort(Integer[] array) {
        int maxElement = Collections.max(Arrays.asList(array));
        for (int exp = 1; maxElement / exp > 0; exp *= 10) {
            countingSort(array, exp);
        }
    }

    /**
     * Function Name: countingSort
     * @param array (Integer[])
     * @param exp   (int)
     * 
     * Inside the Function:
     *  1. Count the occurences of each digit and store in countArray.
     *  2. Change countArray to contain the position of the digit.
     *  3. Construct and copy outputArray to array.
     * 
     * Citations: https://www.geeksforgeeks.org/radix-sort/
     */
    public static void countingSort(Integer[] array, int exp) {
        Integer[] resultArray = new Integer[ARRAY_SIZE];
        int i;
        Integer[] countArray = new Integer[10];

        // Initializing countArray with 0s.
        Arrays.fill(countArray, 0);

        // Store number of occurrences in countArray.
        for (i = 0; i < ARRAY_SIZE; i++) {
            countArray[(array[i] / exp) % 10]++;
        }

        // Change countArray[i] so that countArray[i] now contains the
        // actual position of the digit in the resultArray.
        for (i = 1; i < 10; i++) {
            countArray[i] += countArray[i - 1];
        }

        // Building the resultArray.
        for (i = ARRAY_SIZE - 1; i >= 0; i--) {
            resultArray[countArray[(array[i] / exp) % 10] - 1] = array[i];
            countArray[(array[i] / exp) % 10]--;
        }

        // Copy resultArray to array.
        for (i = 0; i < ARRAY_SIZE; i++) {
            array[i] = resultArray[i];
        }
    }
}
