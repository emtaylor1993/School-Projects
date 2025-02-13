/**
 * ARRAY OPERATIONS TEST
 * 
 * @author Emmanuel Taylor
 * @author Andy Nguyen
 * 
 * @description
 *    This class contains JUnit tests for the methods of the
 *    ArrayOperations class.
 * 
 * @packages
 *    ArrayOperations
 *    JUnit (assertEquals, assertFalse, assertNotNull, assertNull, assertTrue, Test)
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import com.example.ArrayOperations;

public class ArrayOperationsTest {
    @Test
    public void testCountPositiveWithAllPositives() {
        int[] x = {1, 2, 3, 4};
        int n = ArrayOperations.countPositive(x);
        assertEquals("", 4, n);
    }

    @Test
    public void testCountPositiveWithZeros() {
        int[] x = {-4, 2, 0, 2};
        int n = ArrayOperations.countPositive(x);
        assertTrue("", n == 2);
    }

    @Test
    public void testCountPositiveWithAllNegatives() {
        int[] x = {-4, -3, -2, -1};
        int n = ArrayOperations.countPositive(x);
        assertFalse("", n != 0);
    }

    @Test
    public void testCountPositiveWithAllZeros() {
        int[] x = {0, 0, 0, 0};
        int n = ArrayOperations.countPositive(x);
        assertNotNull(x);
        assertEquals("", 0, n);
    }

    @Test(expected = NullPointerException.class)
    public void testCountPositiveWithNullArray() {
        int[] x = null;
        assertNull(x);
        ArrayOperations.countPositive(x);
    }

    @Test
    public void testOddOrPosWithAllPositives() {
        int[] x = {1, 2, 3, 4};
        int n = ArrayOperations.oddOrPos(x);
        assertEquals("", 4, n);
    }

    @Test
    public void testOddOrPosWithAllZeros() {
        int[] x = {0, 0, 0, 0};
        int n = ArrayOperations.oddOrPos(x);
        assertTrue("", n == 0);
    }

    @Test
    public void testOddOrPosWithAllNegatives() {
        int[] x = {-4, -3, -2, -1};
        int n = ArrayOperations.oddOrPos(x);
        assertFalse("", n != 2);
    }

    @Test
    public void testOddOrPosNotNull() {
        int[] x = {0, 0, 0, 0};
        int n = ArrayOperations.oddOrPos(x);
        assertNotNull(x);
        assertEquals("", 0, n);
    }

    @Test(expected = NullPointerException.class)
    public void testOddOrPosNullArray() {
        int[] x = null;
        assertNull(x);
        ArrayOperations.oddOrPos(x);
    }
}
