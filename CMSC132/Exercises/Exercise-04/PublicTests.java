import org.junit.*;
import static org.junit.Assert.*;

public class PublicTests {
    @Test public void testPublic1() {
        BST b = new BST();
        b.insert(123);
        assertEquals("123", b.toString());
    }

    @Test public void testPublic2() {
        BST b = new BST();
        assertTrue(b.insert(123));
    }

    @Test public void testPublic3() {
        BST b = new BST();
        b.insert(123);
        assertFalse(b.insert(123));
        assertEquals("123", b.toString());
    }

    @Test public void testPublic4() {
        BST b = new BST();
        b.insert(20);
        b.insert(10);
        assertEquals("10 20", b.toString());   
    }

    @Test public void testPublic5() {
        BST b = new BST();
        b.insert(20);
        b.insert(30);
        assertEquals("20 30", b.toString());
    }

    @Test public void testPublic6() {
        BST b = new BST();
        b.insert(20);
        b.insert(30);
        b.insert(10);
        assertEquals("10 20 30", b.toString());
    }

    @Test public void testPublic7() {
        BST b = new BST();
        b.insert(20);
        b.insert(30);
        b.insert(10);
        b.insert(40);
        assertEquals("10 20 30 40", b.toString());
    }

    @Test public void testPublic8() {
        BST b = new BST();
        b.insert(50);
        b.insert(30);
        b.insert(10);
        b.insert(80);
        b.insert(60);
        b.insert(90);
        b.insert(40);
        b.insert(20);
        b.insert(70);
        assertEquals("10 20 30 40 50 60 70 80 90", b.toString());
    }
}