/**
 * DATA DRIVEN CALC TEST
 * 
 * @author Paul Ammann
 * @author Jeff Offutt
 * @author Emmanuel Taylor
 * @author Andy Nguyen
 * 
 * @description
 *    This class contains JUnit tests for the methods of the
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

@RunWith (Parameterized.class)
public class DataDrivenCalcTest {
   public int a, b, sum;

   public DataDrivenCalcTest (int a, int b, int sum) {
      this.a = a;
      this.b = b;
      this.sum = sum; 
   }

   @Parameters
   public static Collection<Object[]> calcValues() {
      return Arrays.asList(new Object [][] {{1, 1, 2}, {2, 3, 5}}); 
   }

   @Test
   public void additionTest() {
      assertTrue("Addition Test", sum == Calc.add(a, b));
   }
}