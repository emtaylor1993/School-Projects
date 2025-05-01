/**
 * CALC OPERATIONS MULTIPLY TEST
 * 
 * @author Emmanuel Taylor
 * @author Andy Nguyen
 * 
 * @description
 *    This class contains traditional JUnit tests for the multiply method of the
 *    Calc class.
 * 
 * @packages
 *    JUnit (assertEquals, Test)
 *    Calc
 */

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.example.Calc;

public class CalcOperationsMultiplyTest {
    
    /****************************************
    * Question 6
    ***************************************/

    @Test
    public void testMultiplyingTwoPositiveNumbers() {
        int a = 2;
        int b = 3;
        assertEquals("2 * 3 = 6", 6, Calc.multiply(a, b));
    }

    @Test
    public void testMultiplyingTwoNegativeNumbers() {
        int a = -2;
        int b = -3;
        assertEquals("-2 * -3 = 6", 6, Calc.multiply(a, b));
    }

    @Test
    public void testMultiplyingPositiveNegativeNumbers() {
        int a = 2;
        int b = -3;
        assertEquals("2 * -3 = -6", -6, Calc.multiply(a, b));
    }

    @Test
    public void testMultiplyingByZero() {
        int a = 0;
        int b = 3;
        assertEquals("0 * 3 = 0", 0, Calc.multiply(a, b));
    }
}   
