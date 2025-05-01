/**
 * ARRAY OPERATIONS NUMZERO TEST
 * 
 * @author Emmanuel Taylor
 * @author Andy Nguyen
 * 
 * @description
 *    This class contains JUnit tests for the numZero method of the
 *    ArrayOperations class.
 * 
 * @packages
 *    ArrayOperations
 *    JUnit (assertEquals, Before, Test)
 */

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import com.example.ArrayOperations;

public class ArrayOperationsNumZeroTest {

   private int[] emptyArray;
   private int[] noZerosArray;
   private int[] twoZerosArray;
   private int[] firstIndexZeroArray;
   private int[] allZerosArray;
   private int[] threeZerosArray;
   private int[] nullArray;

   /****************************************
    * Question 4
    ***************************************/
   @Before
   public void setup() {
      emptyArray = new int[] {};
      noZerosArray = new int[] {1, 2, 3}; 
      twoZerosArray = new int[] {1, 2, 3, 4, 5, 0, 0}; 
      firstIndexZeroArray = new int[] {0, 1, 2, 3}; 
      allZerosArray = new int[] {0, 0, 0, 0}; 
      threeZerosArray = new int[] {1, 0, 0, 0}; 
      nullArray = null;
   }

   @After
   public void tearDown() {
      emptyArray = null;
      noZerosArray = null;
      twoZerosArray = null;
      firstIndexZeroArray = null;
      allZerosArray = null;
      threeZerosArray = null;
      nullArray = null;
   }

   @Test
   public void testNumZeroEmptyArray() {
      int n = ArrayOperations.numZero(emptyArray);
      assertEquals("0 zeros", 0, n);      
   }
   
   @Test
   public void testNumZeroArrayWithNoZeros() {
      int n = ArrayOperations.numZero(noZerosArray);
      assertEquals("0 zeros in an array with no zeros", 0, n);
   }

   /****************************************
    * Question 2
    ***************************************/
   
   @Test
   public void testNumZeroArrayWithZeros() {
      int n = ArrayOperations.numZero(twoZerosArray);
      assertEquals("2 zeros in an array with two zeros", 2, n);
   }

   @Test
   public void testNumZeroArrayWithZerosInFirstIndex() {
      int n = ArrayOperations.numZero(firstIndexZeroArray);
      assertEquals("1 zero in an array with one zero", 1, n);
   }

   @Test
   public void testNumZeroArrayWithAllZeros() {
      int n = ArrayOperations.numZero(allZerosArray);
      assertEquals("4 zeros in an array with four zeros", 4, n);
   }

   @Test
   public void testNumZeroArrayWithThreeZeros() {
      int n = ArrayOperations.numZero(threeZerosArray);
      assertEquals("3 zeros in an array with three zeros", 3, n);
   }

   /****************************************
    * Question 3
    ***************************************/

   @Test(expected = NullPointerException.class)
   public void testNumZeroArrayNullPointerException() {
      ArrayOperations.numZero(nullArray);
   }
}