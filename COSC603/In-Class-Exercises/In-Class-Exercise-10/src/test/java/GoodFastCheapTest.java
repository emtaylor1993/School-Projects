/**
 * GOOD FAST CHEAP TEST
 * 
 * @author Emmanuel Taylor
 * @author Andy Nguyen
 * 
 * @description
 *    This class contains JUnit tests for the methods of the
 *    GetFastCheap class.
 * 
 * @packages
 *    GoodFastCheap
 *    JUnit (assertFalse, assertTrue, Test)
 */

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import com.example.GoodFastCheap;

public class GoodFastCheapTest {

    @Test
    public void testGoodFastTrue() {
        GoodFastCheap gfc = new GoodFastCheap();
        gfc.makeGood();
        gfc.makeFast();
        assertTrue(gfc.satisfactory());
    }

    @Test
    public void testOnlyFastFalse() {
        GoodFastCheap gfc = new GoodFastCheap();
        gfc.makeFast();
        assertFalse(gfc.satisfactory());
    }

    @Test
    public void testOnlyGoodFalse() {
        GoodFastCheap gfc = new GoodFastCheap();
        gfc.makeGood();
        assertFalse(gfc.satisfactory());
    }

    @Test
    public void testGoodCheapTrue() {
        GoodFastCheap gfc = new GoodFastCheap();
        gfc.makeGood();
        gfc.makeCheap();
        assertTrue(gfc.satisfactory());
    }

    @Test
    public void testOnlyCheapFalse() {
        GoodFastCheap gfc = new GoodFastCheap();
        gfc.makeCheap();
        assertFalse(gfc.satisfactory());
    }

    @Test
    public void testGoodOnlyFalse() {
        GoodFastCheap gfc = new GoodFastCheap();
        gfc.makeGood();
        assertFalse(gfc.satisfactory());
    }

    @Test
    public void fastCheapTrue() {
        GoodFastCheap gfc = new GoodFastCheap();
        gfc.makeFast();
        gfc.makeCheap();
        assertTrue(gfc.satisfactory());
    }

    @Test
    public void testFastOnlyFast() {
        GoodFastCheap gfc = new GoodFastCheap();
        gfc.makeFast();
        assertFalse(gfc.satisfactory());
    }
}
