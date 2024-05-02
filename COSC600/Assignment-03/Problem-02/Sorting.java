/**
 * COSC600 Assignment 3, Problem #2 - Insertion, Selection, Bubble, Merge
 * @author Emmanuel Taylor
 * 
 * Description:
 *      This program will perform four algorithms (insertion sort, selection
 *      sort, bubble sort and merge sort) on an array of 5_000 random numbers 
 *      ranging from 0 to 50_000.
 * 
 * Packages Used:
 *      Java Utilities (Arrays)
 * 
 * Functions Called:
 *      randomInt, insertionSort, selectionSort, bubbleSort, mergeSort, merge
 * 
 * Citations:
 *      https://www.geeksforgeeks.org/insertion-sort/
 *      https://www.geeksforgeeks.org/selection-sort/
 *      https://www.geeksforgeeks.org/bubble-sort/
 *      https://www.geeksforgeeks.org/merge-sort/
 */
import java.util.Arrays;

public class Sorting {
    final static int ARRAY_SIZE = 5_000;
    
    public static void main(String[] args) {
        int[] array = new int[ARRAY_SIZE];

        // Populating the array with 5_000 random integers from 0 to 50_000.
        for (int index = 0; index < ARRAY_SIZE; index++) {
            array[index] = randomInt();
        }

        // Performing insertion sort algorithm.
        int[] copyArray = Arrays.copyOf(array, ARRAY_SIZE);
        long startTime = System.nanoTime();
        int[] insertionSortArray = insertionSort(copyArray);
        long stopTime = System.nanoTime();

        System.out.println("##################################################");
        System.out.println("#                 INSERTION SORT                 #");
        System.out.println("##################################################\n");
        
        System.out.println("Printing out first 100 elements:\n");

        // Printing out first 100 elements of sorted array.
        for (int index = 0; index < 100; index++) {
            System.out.print(insertionSortArray[index] + ", ");
            if (index % 10 == 0 && index != 0) {
                System.out.println();
            }
        } 

        // Printing out execution time.
        System.out.println("\n\nExecution Time: " + (stopTime - startTime) + " nanoseconds.\n");

        // Performing selection sort algorithm.
        copyArray = Arrays.copyOf(array, ARRAY_SIZE);
        startTime = System.nanoTime();
        int[] selectionSortArray = selectionSort(array);
        stopTime = System.nanoTime();

        System.out.println("##################################################");
        System.out.println("#                 SELECTION SORT                 #");
        System.out.println("##################################################\n");

        System.out.println("Printing out first 100 elements:\n");

        // Printing out first 100 elements of sorted array.
        for (int index = 0; index < 100; index++) {
            System.out.print(selectionSortArray[index] + ", ");
            if (index % 10 == 0 && index != 0) {
                System.out.println();
            }
        } 

        // Printing out execution time.
        System.out.println("\n\nExecution Time: " + (stopTime - startTime) + " nanoseconds.\n");

        // Performing selection sort algorithm.
        copyArray = Arrays.copyOf(array, ARRAY_SIZE);
        startTime = System.nanoTime();
        int[] bubbleSortArray = bubbleSort(array);
        stopTime = System.nanoTime();

        System.out.println("##################################################");
        System.out.println("#                  BUBBLE SORT                   #");
        System.out.println("##################################################\n");

        System.out.println("Printing out first 100 elements:\n");

        // Printing out first 100 elements of sorted array.
        for (int index = 0; index < 100; index++) {
            System.out.print(bubbleSortArray[index] + ", ");
            if (index % 10 == 0 && index != 0) {
                System.out.println();
            }
        } 

        // Printing out execution time.
        System.out.println("\n\nExecution Time: " + (stopTime - startTime) + " nanoseconds.\n");

        // Performing selection sort algorithm.
        copyArray = Arrays.copyOf(array, ARRAY_SIZE);
        startTime = System.nanoTime();
        mergeSort(copyArray, 0, ARRAY_SIZE - 1);
        stopTime = System.nanoTime();

        System.out.println("##################################################");
        System.out.println("#                   MERGE SORT                   #");
        System.out.println("##################################################\n");

        System.out.println("Printing out first 100 elements:\n");

        // Printing out first 100 elements of sorted array.
        for (int index = 0; index < 100; index++) {
            System.out.print(copyArray[index] + ", ");
            if (index % 10 == 0 && index != 0) {
                System.out.println();
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
     *  1. Generate and return a random number from 0 to 50_000.
     */
    public static int randomInt() {
        return (int) (Math.random() * 50_000);
    }

    /**
     * Function Name: insertionSort
     * @param array (int[])
     * @return      (int[])
     * 
     * Inside the Function:
     *  1. From left to right, compare the current element with its predecessor.
     *  2. If the current element is smaller than the predecessor, swap it.
     *  3. Continue until the predecessor is smaller than the current element.
     *  4. Return sorted array.
     * 
     * Citation: https://www.geeksforgeeks.org/insertion-sort/
     */
    public static int[] insertionSort(int[] array) {
        for (int index = 1; index < ARRAY_SIZE; ++index) {
            int currElement = array[index];
            int j = index - 1;

            while (j >= 0 && array[j] > currElement) {
                array[j + 1] = array[j];
                j = j - 1;
            }

            array[j + 1] = currElement;
        }

        return array;
    }

    /**
     * Function Name: selectionSort
     * @param array (int[])
     * @return      (int[])
     * 
     * Inside the Function:
     *  1. Selects the smallest element from the unsorted array. and swaps it.
     *  2. Repeats this process for the remaining unsorted array.
     *  3. Return sorted array.
     * 
     * Citation: https://www.geeksforgeeks.org/selection-sort/
     */
    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < ARRAY_SIZE - 1; i++) {
            int min = i;
            for (int j = i + 1; j < ARRAY_SIZE; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }

            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }

        return array;
    }

    /**
     * Function Name: bubbleSort
     * @param array (int[])
     * @return      (int[])
     * 
     * Inside the Function:
     *  1. Traverse and compare adjacent elements from left to right.
     *  2. Place the higher element to the right.
     *  3. Continue this process until all larger elements are found.
     *  4. Return sorted array.
     * 
     * Citation: https://www.geeksforgeeks.org/bubble-sort/
     */
    public static int[] bubbleSort(int[] array) {
        int i, j, temp;
        boolean swapped;

        for (i = 0; i < ARRAY_SIZE - 1; i++) {
            swapped = false;
            for (j = 0; j < ARRAY_SIZE - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

            if (swapped == false) {
                break;
            }
        }

        return array;
    }

    /**
     * Function Name: merge
     * @param array (int[])
     * @param left  (int)
     * @param mid   (int)
     * @param right (int)
     * 
     * Inside the Function:
     *  1. Calculate sizes for merging subarrays.
     *  2. Create and copy data to temporary arrays.
     *  3. Merge subarrays.
     * 
     * Citation: https://www.geeksforgeeks.org/merge-sort/
     */
    public static void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
 
        // Create temporary subarrays.
        int L[] = new int[n1];
        int R[] = new int[n2];
 
        // Copy left half of data to temporary subarray.
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }

        // Copy right half of data to temporary subarray.
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }

        // Initial indices of subarrays and merged array.
        int i = 0, j = 0, k = l;
 
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }

            k++;
        }
 
        // Copy remaining elements to the left subarray.
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        // Copy remaining elements to the right subarray.
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    /**
     * Function Name: mergeSort
     * @param array (int[])
     * @param left  (int)
     * @param right (int)
     * 
     * Inside the Function:
     *  1. Calculate midpoint of array.
     *  2. Perform divide and conquer method until array is sorted.
     * 
     * Citation: https://www.geeksforgeeks.org/merge-sort/
     */
    public static void mergeSort(int arr[], int l, int r) {
        if (l < r) {
 
            // Calculate midpoint of array.
            int m = l + (r - l) / 2;
 
            // Sort left and right halves of split array.
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
 
            // Merge sorted halves together.
            merge(arr, l, m, r);
        }
    }
}
