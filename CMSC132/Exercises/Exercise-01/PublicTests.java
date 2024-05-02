import iterator.Student; 
import iterator.Section;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.junit.*;
import static org.junit.Assert.*;

public class PublicTests {
    @Test public void testPublic1() {
        Section disc132 = sampleSection();
        Iterator<Student> iter = disc132.iterator();
        assertTrue(iter.hasNext());
    }

    @Test public void testPublic2() {
        Section disc132 = sampleSection();
        Iterator<Student> iter = disc132.iterator();
        assertEquals("Name: Mary, ID: 10010, GPA: 3.7", iter.next().toString());
    }

    @Test public void testPublic3() {
        Section disc132 = sampleSection();
        Iterator<Student> iter = disc132.iterator();
        assertEquals("Name: Mary, ID: 10010, GPA: 3.7" + "Name: Bob, ID: 22244, GPA: 2.8", iter.next().toString() + iter.next());   
    }

    @Test public void testPublic4() {
        Section disc132 = sampleSection();
        Iterator<Student> iter = disc132.iterator();
        assertEquals("Name: Mary, ID: 10010, GPA: 3.7" + "Name: Bob, ID: 22244, GPA: 2.8" +
            "Name: Laura, ID: 17654, GPA: 2.1" + "Name: Albert, ID: 34434, GPA: 3.4",
            iter.next().toString() + iter.next() + iter.next() + iter.next());
    }

    @Test public void testPublic5() {
        Section disc132 = new Section("0201");
        Iterator<Student> iter = disc132.iterator();
        assertFalse(iter.hasNext());
    }

    @Test public void testPublic6() {
        Section disc132 = sampleSection();
        Iterator<Student> iter = disc132.iterator();
        String s = "";
        while (iter.hasNext())
            s += iter.next();
        assertEquals("Name: Mary, ID: 10010, GPA: 3.7" + "Name: Bob, ID: 22244, GPA: 2.8" +
            "Name: Laura, ID: 17654, GPA: 2.1" + "Name: Albert, ID: 34434, GPA: 3.4", s);
    }

    @Test(expected = NoSuchElementException.class) public void testPublic7() {
        Section disc132 = sampleSection();
        Iterator<Student> iter = disc132.iterator();
        while (true)
            iter.next();
    }

    // private utility method ////////////////////////////////////////////
    private Section sampleSection() {
        Section discussion= new Section("0101");

        discussion.addStudent(new Student("Mary", 10010, 3.7));
        discussion.addStudent(new Student("Bob",  22244, 2.8));
        discussion.addStudent(new Student("Laura", 17654, 2.1));
        discussion.addStudent(new Student("Albert", 34434, 3.4));

        return discussion;
    }
}