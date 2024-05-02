/**
 * COSC600 Assignment 2, Problem #1 - Maximum Subsequence Sum
 * @author Emmanuel Taylor
 * 
 * Description:
 *      This program will compare four different Maximum Subsequence Sum
 *      algorithms and displaying the execution time to solve the problem
 *      with various sizes of Arrays with numbers from -5000 to 5000.
 * 
 * Packages Used:
 *      Random, ExecutorService, Executors, Future, TimeUnit, TimeoutException, Math
 * 
 * Functions Called:
 *      randomNumber, maxSubSum1, maxSubSum2, maxSubSum3, maxSubSumRec, maxSubSum4
 * 
 */
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.lang.Math;

public class MaximumSubsequenceSum {
    public static void main(String[] args) {
        final int[] ARRAY_SIZES = {5_000, 10_000, 50_000, 100_000, 200_000};
        int maxSum = 0;

        // Run each of the four algorithms for size 5_000, 10_000, 50_000, 100_000, and 200_000.
        for (int sizeIndex = 0; sizeIndex < ARRAY_SIZES.length; sizeIndex++) {
            System.out.println("##################################### SIZE " + ARRAY_SIZES[sizeIndex] + " #####################################");
            
            // Populate the subsequence array with random numbers.
            int[] subsequenceArray = new int[ARRAY_SIZES[sizeIndex]];
            for (int index = 0; index < ARRAY_SIZES[sizeIndex]; index++) {
                subsequenceArray[index] = randomNumber();
            }

            ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
            Future<Integer> alg1 = executor.submit(() -> maxSubSum1(subsequenceArray));

            // Algorithm 1
            System.out.println("Running Cubic Maximum Contiguous Subsequence Sum Algorithm:");
            long startTime = System.nanoTime();
            try {
                maxSum = alg1.get(15, TimeUnit.MINUTES);
                long stopTime = System.nanoTime();
                System.out.println("The maximum subsequence sum is: " + maxSum);
                System.out.println("Execution Time: " + (stopTime - startTime) + " nanoseconds.\n");
            } catch (TimeoutException e) {
                long stopTime = System.nanoTime();
                alg1.cancel(true);
                System.out.println("The maximum subsequence sum is: N/A");
                System.out.println("The function was terminated due to 15 minute time limit.");
                System.out.println("Execution Time: " + (stopTime - startTime) + " nanoseconds.\n");
            } catch (Exception e) {
                alg1.cancel(true);
                System.out.println("Something occurred beyond the scope of this assignment.");
            }

            executor.shutdownNow();

            // Algorithm 2
            System.out.println("Running Quadratic Maximum Contiguous Subsequence Sum Algorithm:");
            startTime = System.nanoTime();
            maxSum = maxSubSum2(subsequenceArray);
            long stopTime = System.nanoTime();
            System.out.println("The maximum subsequence sum is: " + maxSum);
            System.out.println("Execution Time: " + (stopTime - startTime) + " nanoseconds.\n");

            // Algorithm 3
            System.out.println("Running Recursive Maximum Contiguous Subsequence Sum Algorithm:");
            startTime = System.nanoTime();
            maxSum = maxSubSum3(subsequenceArray);
            stopTime = System.nanoTime();
            System.out.println("The maximum subsequence sum is: " + maxSum);
            System.out.println("Execution Time: " + (stopTime - startTime) + " nanoseconds.\n");

            // Algorithm 4
            System.out.println("Running Linear Maximum Contiguous Subsequence Sum Algorithm:");
            startTime = System.nanoTime();
            maxSum = maxSubSum4(subsequenceArray);
            stopTime = System.nanoTime();
            System.out.println("The maximum subsequence sum is: " + maxSum);
            System.out.println("Execution Time: " + (stopTime - startTime) + " nanoseconds.\n\n");
        }

        System.exit(1);
    }

    /**
     * Function Name: randomNumber
     * @return (int)
     * 
     * Inside the Function:
     *  1. Set upper and lower bounds.
     *  2. Return a random number in between the bounds.
     */
    public static int randomNumber() {
        int max = 5000, min = -5000;
        return new Random().nextInt(max - min) + min;
    }

    /**
     * Function Name: maxSubSum1
     * @param array (int[])
     * @return      (int)
     * 
     * Inside the Function:
     *  1. Run the cubic maximum contiguous subsequence sum algorithm.
     */
    public static int maxSubSum1(int[] array) {
        int maxSum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                int thisSum = 0;
                for (int k = i; k <= j; k++) {
                    thisSum += array[k];
                }

                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }
        }
        return maxSum;
    }

    /**
     * Function Name: maxSubSum2
     * @param array (int[])
     * @return      (int)
     * 
     * Inside the Function:
     *  1. Run the quadratic maximum contiguous subsequence sum algorithm.
     */
    public static int maxSubSum2(int[] array) {
        int maxSum = 0;
        for (int i = 0; i < array.length; i++) {
            int thisSum = 0;
            for (int j = i; j < array.length; j++) {
                thisSum += array[j];
                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }
        }
        return maxSum;
    }

    /**
     * Function Name: maxSumRec
     * @param array (int[])
     * @param left  (int)
     * @param right (int)
     * @return      (int)
     * 
     * Inside the Function:
     *  1. Perform the divide-and-conquer maximum contiguous subsequence
     *     sum algorithm.
     */
    private static int maxSumRec(int[] array, int left, int right) {

        // Base Case.
        if (left == right) {
            if (array[left] > 0) {
                return array[left];
            } else {
                return 0;
            }
        }

        int center = (left + right) / 2;
        int maxLeftSum = maxSumRec(array, left, center);
        int maxRightSum = maxSumRec(array, center + 1, right);

        int maxLeftBorderSum = 0, leftBorderSum = 0;
        for (int i = center; i >= left; i--) {
            leftBorderSum += array[i];
            if (leftBorderSum > maxLeftBorderSum) {
                maxLeftBorderSum = leftBorderSum;
            }
        }

        int maxRightBorderSum = 0, rightBorderSum = 0;
        for(int i = center + 1; i <= right; i++) {
            rightBorderSum += array[i];
            if (rightBorderSum > maxRightBorderSum) {
                maxRightBorderSum = rightBorderSum;
            }
        }

        return Math.max(maxLeftSum, Math.max(maxRightSum, maxLeftBorderSum + maxRightBorderSum));
    }

    /**
     * Function Name: maxSubSum3
     * @param array (int[])
     * @return      (int)
     * 
     * Inside the Function:
     *  1. Calls recursive helper function.
     */
    public static int maxSubSum3(int[] array) {
        return maxSumRec(array, 0, array.length - 1);
    }

    /**
     * Function Name: maxSubSum4
     * @param array (int[])
     * @return      (int)
     * 
     * Inside the Function:
     *  1. Perform the linear-time maximum contiguous subsequence sum algorithm.
     */
    public static int maxSubSum4(int[] array) {
        int maxSum = 0, thisSum = 0;
        for (int i = 0; i < array.length; i++) {
            thisSum += array[i];
            if (thisSum > maxSum) {
                maxSum = thisSum;
            } else if (thisSum < 0) {
                thisSum = 0;
            }
        }
        return maxSum;
    }
}
