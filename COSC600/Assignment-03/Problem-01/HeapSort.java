/**
 * COSC600 Assignment 3, Problem #1 - Heap Sort
 * @author Emmanuel Taylor
 * 
 * Description:
 *      This program will perform the Heap Sort algorithm on a
 *      Binary Heap of 5000 random numbers ranging from 0 to 50000
 *      by inserting each element one at a time into an initially
 *      empty binary heap and by using the linear time build heap
 *      algorithm.
 * 
 * Packages Used:
 *      Java Utilities (Arrays)
 * 
 * Functions Called:
 *      randomInt, heapSort, heapify, insert, linearHeapSort
 * 
 * Citations: 
 *      https://www.geeksforgeeks.org/heap-sort/
 *      https://www.geeksforgeeks.org/insertion-and-deletion-in-heaps/
 */
import java.util.Arrays;

public class HeapSort {
    final static int ARRAY_SIZE = 5_000;
    static int SWAPS = 0;
  
    public static void main(String[] args) {
        int[] binaryHeap = new int[ARRAY_SIZE];

        // Create array of random elements.
        for (int i = 0; i < binaryHeap.length; i++) {
            binaryHeap[i] = randomInt();
        }

        // Perform heapSort algorithm.
        int[] heapCopy = Arrays.copyOf(binaryHeap, ARRAY_SIZE);
        long startTime = System.nanoTime();
        heapSort(heapCopy);
        long stopTime = System.nanoTime();

        System.out.println("##################################################");
        System.out.println("#                   HEAP SORT                    #");
        System.out.println("##################################################\n");

        // Printing out the first 50 elements.
        System.out.println("First 50 elements: (" + SWAPS + " swaps)");
        for (int i = 0; i < 50; i++) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.print(heapCopy[i] + ", ");
        }

        // Printing out execution time.
        System.out.println("\n\nExecution Time: " + (stopTime - startTime) + " nanoseconds.\n");

        // Perform linear time build heapSort algorithm.
        heapCopy = Arrays.copyOf(binaryHeap, ARRAY_SIZE);
        SWAPS = 0;
        startTime = System.nanoTime();
        linearHeapSort(heapCopy);
        stopTime = System.nanoTime();

        System.out.println("##################################################");
        System.out.println("#                LINEAR HEAP SORT                #");
        System.out.println("##################################################\n");

        // Printing out the first 50 elements.
        System.out.println("First 50 elements: (" + SWAPS + " swaps)");
        for (int i = 0; i < 50; i++) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.print(heapCopy[i] + ", ");
        }

        // Printing out execution time.
        System.out.println("\n\nExecution Time: " + (stopTime - startTime) + " nanoseconds.\n");
    }

    /**
     * Function Name: randomInt
     * @return (int)
     * 
     * Inside the Function:
     *  1. Generate a random number from 0 to 50_000.
     */
    public static int randomInt() {
        return (int) (Math.random() * 50_000);
    }

    /**
     * Function Name: insert
     * @param array (int[])
     * @param n     (int)
     * @param key   (int)
     * 
     * Inside the Function:
     *  1. Increase heap size by 1.
     *  2. Insert element at the end of the heap.
     *  3. Heapify the increased size heap.
     * 
     * Citation: https://www.geeksforgeeks.org/insertion-and-deletion-in-heaps/
     */
    public static void insert(int[] array, int n, int key) {
        n = n + 1;
        array[n - 1] = key;
        heapify(array, n, n - 1);
    }

    /**
     * Function Name: heapSort
     * @param array
     * 
     * Inside the Function:
     *  1. Build heap and heapify one by one.
     *  2. Extract minimum element from heap.
     *  3. Heapify reduced heap.
     * 
     * Citations: https://www.geeksforgeeks.org/heap-sort/
     */
    public static void heapSort(int[] array) {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            insert(array, ARRAY_SIZE - 1, array[i]);
        }

        for (int i = ARRAY_SIZE - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
    }

    /**
     * Function Name: linearHeapSort
     * @param array (int[])
     * 
     * Inside the Function:
     *  1. Build heap in linear time.
     *  2. Extract minimum element from heap 
     *  3. Heapify reduced heap.
     * 
     * Citations: https://www.geeksforgeeks.org/heap-sort/
     */
    public static void linearHeapSort(int[] array) {
        int N = ARRAY_SIZE;

        for (int i = N / 2 - 1; i >= 0; i--) {
            heapify(array, N, i);
        }

        for (int i = N - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
    }

    /**
     * Function Name: heapify
     * @param array (int[])
     * @param N     (int)
     * @param i     (int)
     * 
     * Inside the Function:
     *  1. Initialize the root.
     *  2. Check whether left or right children are larger than the root.
     *  3. Recursively heapify subtree.
     * 
     * Citations: https://www.geeksforgeeks.org/heap-sort/
     */
    public static void heapify(int[] array, int N, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < N && array[l] > array[largest]) {
            largest = l;
        }

        if (r < N && array[r] > array[largest]) {
            largest = r;
        }

        if (largest != i) {
            SWAPS++;
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            heapify(array, N, largest);
        }
    }
}
