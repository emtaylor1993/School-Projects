/**
 * COSC600 Assignment 1, Problem #3 - Word Puzzle Solver
 * @author Emmanuel Taylor
 * 
 * Description:
 *      Find the words in wordlist.txt in a two-dimensional array of characters
 *      and display their positions in the array.
 * 
 * Packages Used:
 *      BufferedReader, File, FileReader, IOException, ArrayList
 * 
 * Functions Called:
 *      readPuzzleInput, readWordList, solvePuzzle
 * 
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class WordPuzzleSolver {
    public static final int PUZZLE_SIZE = 50;
    public static final int[] X_DIRECTIONS = {-1, -1, -1, 0, 0, 1, 1, 1};
    public static final int[] Y_DIRECTIONS = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        char[][] puzzle = readPuzzleInput("puzzleinput.txt");
        String[] words = readWordList("wordlist.txt");
        System.out.println("\n############################################ WORD PUZZLE SOLVER ############################################\n");
        long startTime = System.nanoTime();
        char[][] output = solvePuzzle(puzzle, words);
        long stopTime = System.nanoTime();

        // Displaying the contents of puzzleinput.txt
        for (int row = 0; row < PUZZLE_SIZE; row++) {
            for (int col = 0; col < PUZZLE_SIZE; col++) {
                System.out.print(puzzle[row][col] + " ");
            }
            System.out.println();
        }
        
        System.out.println("\n############################################ WORDS LIST ############################################\n");

        // Displaying the contents of wordlist.txt
        for (int index = 0; index < words.length; index++) {
            System.out.println(
                words[index].charAt(0) + 
                words[index].substring(1, words[index].length()).toLowerCase()
            );
        }

        System.out.println("\n############################################ SOLVED PUZZLE ############################################\n");

        // Displaying the final output with all found words.
        for (int row = 0; row < PUZZLE_SIZE; row++) {
            for (int col = 0; col < PUZZLE_SIZE; col++) {
                System.out.print(output[row][col] + " ");
            }
            System.out.println();
        }

        System.out.println("Execution time was " + (stopTime - startTime) + " nanoseconds.\n");
    }

    /**
     * Function Name: readPuzzleInput
     * 
     * @param filePath      (String)
     * @param size          (int)
     * @return              (char[][])
     * @throws IOException
     * 
     * Inside the Function:
     *  1. Create a File object out of the path given.
     *  2. Create a BufferedReader object to read File contents.
     *  3. Store each String of characters in the current index position.
     *  4. Return the char[][] array.
     */
    public static char[][] readPuzzleInput(String filePath) throws IOException {
        File file = new File(filePath);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        char[][] puzzle = new char[PUZZLE_SIZE][PUZZLE_SIZE];
        String string;
        int index = 0;
        while ((string = reader.readLine()) != null) {
            try {
                puzzle[index] = string.toCharArray();
                index++;
            } catch (ArrayIndexOutOfBoundsException exception) {
                break;
            }
        }
        reader.close();
        return puzzle;
    }

    /**
     * Function Name: readWordList 
     * 
     * @param filePath      (String)
     * @return              (String[])
     * @throws IOException
     * 
     * Inside the Function:
     *  1. Create a File object out of the path given.
     *  2. Create a BufferedReader object to read File contents.
     *  3. Add each word to the String ArrayList.
     *  4. Convert the ArrayList to an Array and return.
     */
    public static String[] readWordList(String filePath) throws IOException {
        File file = new File(filePath);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        ArrayList<String> words = new ArrayList<String>();
        String string;
        while ((string = reader.readLine()) != null) {
            words.add(string.toUpperCase());
        }
        reader.close();
        return words.toArray(new String[words.size()]);
    }

    /**
     * Function Name: solvePuzzle
     * 
     * @param puzzle (char[][])
     * @param words  (String[])
     * @return       (char[][])
     * 
     * Inside the Function:
     *  1. Initialize the 2D output array.
     *  2. For each word, traverse the 2D array to match the first character.
     *  3. Check for successive characters in all 8 directions.
     *  4. If a word is matched, replace the positions in the output array.
     *  5. Continue until each word is found.
     */
    public static char[][] solvePuzzle(char[][] puzzle, String[] words) {
        char[][] output = new char[PUZZLE_SIZE][PUZZLE_SIZE];

        // Initializing the output puzzle to be filled with empty spaces to
        // be overwritten by each found character of a word.
        for (int row = 0; row < PUZZLE_SIZE; row++) {
            for (int col = 0; col < PUZZLE_SIZE; col++) {
                output[row][col] = ' ';
            }
        }

        // For each word, traverse the 2D puzzle array until there is a match for the first
        // character of the current word.
        for (int wordsIndex = 0; wordsIndex < words.length; wordsIndex++) {
            for (int row = 0; row < PUZZLE_SIZE; row++) {
                for (int col = 0; col < PUZZLE_SIZE; col++) {
                    
                    // For each character match, store the position in a positionHolder to replace the
                    // positions in the 2D output array if the word is matched.
                    if (puzzle[row][col] == words[wordsIndex].charAt(0)) {
                        int[][] positionHolder = new int[words[wordsIndex].length()][2];
                        positionHolder[0][0] = row;
                        positionHolder[0][1] = col;

                        // Check matches for each successive character in all 8 possible directions.
                        for (int directionIndex = 0; directionIndex < X_DIRECTIONS.length; directionIndex++) {
                            int newXPosition = row + X_DIRECTIONS[directionIndex];
                            int newYPosition = col + Y_DIRECTIONS[directionIndex];
                            int charIndex;
                            int positionIndex = 1;

                            // For each character, ignore those that are out of the array bounds and ones that are
                            // not matches for the word.
                            for (charIndex = 1; charIndex < words[wordsIndex].length(); charIndex++) {
                                if (newXPosition < 0 || newXPosition >= PUZZLE_SIZE || newYPosition < 0 || newYPosition >= PUZZLE_SIZE) {
                                    break;
                                }

                                if (puzzle[newXPosition][newYPosition] != words[wordsIndex].charAt(charIndex)) {
                                    break;
                                }

                                positionHolder[positionIndex][0] = newXPosition;
                                positionHolder[positionIndex][1] = newYPosition;
                                positionIndex++;
                                newXPosition += X_DIRECTIONS[directionIndex];
                                newYPosition += Y_DIRECTIONS[directionIndex];
                            }

                            // If the entire word was matched, replace the positions in the 2D output array with those in the 
                            // positionHolder array.
                            if (charIndex == words[wordsIndex].length()) {
                                for (int index = 0; index < words[wordsIndex].length(); index++) {
                                    output[positionHolder[index][0]][positionHolder[index][1]] = words[wordsIndex].charAt(index);
                                }
                            }
                        }
                    }
                }
            }
        }

        return output;
    }
}
