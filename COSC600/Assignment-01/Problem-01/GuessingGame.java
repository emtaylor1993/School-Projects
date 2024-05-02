/**
 * COSC600 Assignment 1, Problem #1 - Guessing Game
 * @author Emmanuel Taylor
 * 
 * Description:
 *      Uses the Binary Search Algorithm to find an integer number from
 *      1 to 1_000_000 for 100 rounds and calculates the average number
 *      of guess trials for all 100 random numbers.
 * 
 * Packages Used:
 *      None
 * 
 * Functions Called:
 *      randomInt, binarySearch
 * 
 */

public class GuessingGame {
    public static void main(String[] args) {
        final int ARRAY_SIZE = 1_000_000;
        final int ROUND_SIZE = 100;

        int[] array = new int[ARRAY_SIZE];
        int[] guessesArray = new int[ROUND_SIZE];
        int trialNumber = 1;
        int guessSum = 0;

        // Populate an integer array with values from 1 to 1_000_000.
        for (int index = 0; index < ARRAY_SIZE; index++) {
            array[index] = index + 1;
        }

        // Call binarySearch on 100 different random numbers ranging from 1 to 1_000_000.
        while (trialNumber <= ROUND_SIZE) {
            int randomNumber = randomInt();
            guessesArray[trialNumber - 1] = binarySearch(array, randomNumber, trialNumber); 
            trialNumber++;
        }

        // Summing the number of guesses during each trial run.
        for (int index = 0; index < guessesArray.length; index++) {
            guessSum += guessesArray[index];
        }

        double average = guessSum / guessesArray.length;
        System.out.println("\nThe average number of guessing trials for " + ARRAY_SIZE + " random numbers is " + average);
    }

    /**
     * Function Name: randomInt
     * @return (int)
     * 
     * Inside the Function:
     *  1. Generate a random number from 1 to 1_000_000.
     */
    public static int randomInt() {
        return (int) (Math.random() * 1_000_000) + 1;
    }

    /**
     * Function Name: binarySearch
     * @param array  (int [])
     * @param number (int)
     * @return       (int)
     * 
     * Inside the Function:
     *  1. Calculate the lower and upper bounds.
     *  2. While the number hasn't been found, determine which half
     *     it is in while updating the corresponding bound.
     *  3. Return the numGuesses it took to find the number.
     */
    public static int binarySearch(int[] array, int number, int trials) {
        boolean isFound = false;
        int lowerBound = array[0];
        int upperBound = array[array.length - 1];
        int numGuesses = 0;

        System.out.println("\nGuess-" + trials);

        while (isFound == false) {
            numGuesses++;
            int midPoint = lowerBound + (upperBound - lowerBound) / 2;

            // The number is found!
            if ((array[midPoint] - 1) == number) {
                System.out.println("The number is found. It is " + number);
                return numGuesses;
            }

            // The number is in the left most half.
            if ((array[midPoint] - 1) > number) {
                System.out.println("The number is lower than " + array[midPoint - 1]);
                upperBound = midPoint - 1;
            }

            // The number is in the right most half.
            if ((array[midPoint] - 1) < number) {
                System.out.println("The number is higher than " + array[midPoint - 1]);
                lowerBound = midPoint + 1;
            }
        }

        // Should never reach here. 
        return -1;
    }
}
