import org.junit.*;
import static org.junit.Assert.*;

public class PublicTests {
    /*
     * The input is just a line with 4.
     */
    @Test public void testPublic1() {
        new TestCode().public1();
    }

    /*
     * The input is just a line with 8.
     */
    @Test public void testPublic2() {
        new TestCode().public2();
    }

    /*
     * The input is just a line with 1.
     */
    @Test public void testPublic3() {
        new TestCode().public3();
    }

    /*
     * The input is just a line with 132.
     */
    @Test public void testPublic4() {
        new TestCode().public4();
    }

    /*
     * The input is just a line with 133.
     */
    @Test public void testPublic5() {
        new TestCode().public5();
    }

    /*
     * The input is two lines (note that the first is not a valid integer):
     *
     * 12.34
     * 12
     */
    @Test public void testPublic6() {
        new TestCode().public6();
    }

    /*
     * The input is two lines:
     *
     * banana
     * 10
     */
    @Test public void testPublic7() {
        new TestCode().public6();
    }

    /*
     * The input is three lines:
     *
     * banana
     * boing
     * 10
     */
    @Test public void testPublic8() {
        new TestCode().public7();
    }

    /*
     * The input is two lines:
     *
     * 0
     * 16
     */
    @Test public void testPublic9() {
        new TestCode().public8();
    }

    /*
     * The input is six lines:
     *
     * 0
     * banana
     * 0
     * stillwrong
     * 0
     * 20
     */
    @Test public void testPublic10() {
        new TestCode().public9();
    }
}