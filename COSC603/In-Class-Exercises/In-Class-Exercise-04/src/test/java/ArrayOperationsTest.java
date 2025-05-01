/**
 * ARRAY OPERATIONS TEST
 * 
 * @author Emmanuel Taylor
 * @author Andy Nguyen
 * 
 * @description
 *    This class contains JUnit tests for three methods in this class. We are
 *    attempting to reach 100% statement and branch coverage.
 * 
 * @packages
 *    ArrayOperations
 *    JUnit (assertEquals, Before, Test)
 */

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.example.ArrayOperations;

public class ArrayOperationsTest {

   /****************************************
    * ArrayOperations.numZero
    ***************************************/
   @Test
   public void testNumZero() {
      int[] testInput = {1, 0, 0, 0};
      int n = ArrayOperations.numZero(testInput);
      assertEquals("There are three zeros.", 3, n);
   }

   @Test(expected = NullPointerException.class)
   public void testNumZeroNullPointerException() {
      int[] testInput = null;
      ArrayOperations.numZero(testInput);
   }

   @Test
   public void testNumZeroNoZeros() {
      int[] testInput = {1, 1, 1, 1};
      int n = ArrayOperations.numZero(testInput);
      assertEquals("There are no zeros.", 0, n);
   }

   /****************************************
    * ArrayOperations.findLast
    ***************************************/
   @Test
   public void testFindLastContains() {
      int[] testInput = {3, 2, 5};
      int y = 2;
      int n = ArrayOperations.findLast(testInput, y);
      assertEquals("The last occurrence is in position 1.", 1, n);
   }

   @Test
   public void testFindLastDoesNotContains() {
      int[] testInput = {3, 2, 5};
      int y = 1000;
      int n = ArrayOperations.findLast(testInput, y);
      assertEquals("There is no occurrence.", -1, n);
   }

   @Test(expected = NullPointerException.class)
   public void testFindLastNullPointerException() {
      int[] testInput = null;
      int y = 2;
      ArrayOperations.findLast(testInput, y);
   }

   /****************************************
    * ArrayOperations.countPositive
    ***************************************/
   @Test
   public void testCountPositiveAllPositive() {
      int[] testInput = {1, 2, 3, 4};
      int n = ArrayOperations.countPositive(testInput);
      assertEquals("There are four positive numbers.", 4, n);
   }

   @Test
   public void testCountPositiveAllNegative() {
      int[] testInput = {-1, -2, -3, -4};
      int n = ArrayOperations.countPositive(testInput);
      assertEquals("There are no positive numbers.", 0, n);
   }

   @Test(expected = NullPointerException.class) 
   public void testCountPositiveNullPointerException() {
      int[] testInput = null;
      ArrayOperations.countPositive(testInput);
   }
}