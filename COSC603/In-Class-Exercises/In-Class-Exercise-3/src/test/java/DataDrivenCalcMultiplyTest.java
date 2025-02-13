/**
 * DATA DROVEM CALC MULTIPLY TEST
 * 
 * @author Emmanuel Taylor
 * @author Andy Nguyen
 * 
 * @description
 *    This class contains data-driven JUnit tests for the multiply method of the
 *    Calc class.
 * 
 * @packages
 *    Java Utilities (Arrays, Collection)
 *    JUnit (assertTrue, Test, RunWith, Parameterized, Parameters)
 *    Calc
 */

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.example.Calc;

/****************************************
* Question 7
***************************************/

@RunWith(Parameterized.class)
public class DataDrivenCalcMultiplyTest {
    public int a, b, product;

    public DataDrivenCalcMultiplyTest(int a, int b, int product) {
        this.a = a;
        this.b = b;
        this.product = product;
    }

    @Parameters
    public static Collection<Object[]> calcValues() {
        return Arrays.asList(new Object[][] {{2, 3, 6}, {-2, -3, 6}, {2, -3, -6}, {0, 3, 0}});
    }

    @Test
    public void multipliationTest() {
        assertTrue("Multiplication Test", product == Calc.multiply(a, b));
    }
}
