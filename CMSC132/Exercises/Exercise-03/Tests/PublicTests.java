package Tests;

import Car.Car;
import Factorial.Factorial;
import java.util.Iterator;
import org.junit.*;
import static org.junit.Assert.*;

public class PublicTests {
    @Test public void testPublic1() {
        assertEquals(Car.makeHybridCar().toString(), "Ford 1000");
    }

    @Test public void testPublic2() {
        Car c = Car.makeHybridCar();

        c.start();
        c.start();
        c.start();

        assertEquals(c.toString(), "Ford 925");
    }

    @Test public void testPublic3() {
        Factorial f = new Factorial(2, 5);

        // the String class trim() method removes leading and trailing
        // whitespace, so the tests will pass even if your string returned by
        // toString() happens to have a space at the end
        assertEquals(f.toString().trim(), "2 6 24 120");
    }

    @Test public void testPublic4() {
        Factorial f = new Factorial(10, 10);
   
    assertEquals(f.toString().trim(), "3628800");
    }

    @Test public void testPublic5() {
        Factorial f = new Factorial(1, 1);

        assertEquals(f.toString().trim(), "1");
    }

    @Test public void testPublic6() {
        Factorial f = new Factorial(10, 5);

        assertEquals(f.toString().trim(), "");
    }

    // this test tests the iterator explicitly, although it should be called
    // from the toString() methods in the three tests above
    @Test public void testPublic7() {
        Factorial f = new Factorial(5, 8);
        Iterator<Integer> iter = f.iterator();
        String answer = "";

        while (iter.hasNext())
            answer += iter.next() + " ";

        assertEquals(answer.trim(), "120 720 5040 40320");
    }
}