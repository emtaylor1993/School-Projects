mport org.junit.*;
import static org.junit.Assert.*;

public class PublicTests {
    @Test public void testPublic1() {
        CourseList list = courseList1();

        assertEquals(0, list.numEnrolled("CMSC 123"));
    }

    @Test public void testPublic2() {
        CourseList list = courseList1();

        assertFalse(list.isTaking("Johnny", "CMSC 321"));
    }

    @Test public void testPublic3() {
        CourseList list = courseList2();

        assertEquals(0, list.numEnrolled("CMSC 123"));
    }

    @Test public void testPublic4() {
        CourseList list = courseList2();

        assertEquals(1, list.numEnrolled("CMSC 732"));
    }

    @Test public void testPublic5() {
        CourseList list = courseList2();

        assertTrue(list.isTaking("Ethar", "CMSC 732"));
        assertFalse(list.isTaking("Johnny", "CMSC 732"));
    }

    @Test public void testPublic6() {
        CourseList list = courseList3();

        assertEquals(0, list.numEnrolled("CMSC 123"));
    }

    @Test public void testPublic7() {
        CourseList list = courseList3();

        assertTrue(list.isTaking("Leo", "MATH 345"));
        assertFalse(list.isTaking("Leo", "CMSC 456"));
        assertFalse(list.isTaking("Leonardo", "CMSC 678"));
    }

    @Test public void testPublic8() {
        CourseList list = courseList3();

        assertEquals(2, list.numEnrolled("CMSC 456"));
        assertEquals(3, list.numEnrolled("CMSC 567"));
        assertEquals(2, list.numEnrolled("CMSC 678"));
        assertEquals(1, list.numEnrolled("CMSC 700"));
        assertEquals(1, list.numEnrolled("CMSC 789"));
        assertEquals(1, list.numEnrolled("CMSC 800"));
        assertEquals(1, list.numEnrolled("MATH 345"));
    }

    @Test public void testPublic9() {
        CourseList list = courseList3();

        assertTrue(list.isTaking("Ethar", "CMSC 456"));
        assertTrue(list.isTaking("Ethar", "CMSC 567"));
        assertTrue(list.isTaking("Ethar", "CMSC 567"));
        assertTrue(list.isTaking("Johnny", "CMSC 456"));
        assertTrue(list.isTaking("Josh", "CMSC 567"));
        assertTrue(list.isTaking("Josh", "CMSC 700"));
        assertTrue(list.isTaking("Josh", "CMSC 789"));
        assertTrue(list.isTaking("Josh", "CMSC 800"));
        assertTrue(list.isTaking("Leo", "CMSC 567"));
        assertTrue(list.isTaking("Leo", "CMSC 678"));
        assertTrue(list.isTaking("Leo", "MATH 345"));  
    }

    @Test public void testPublic10() {
        CourseList list = courseList3();

        assertFalse(list.isTaking("Ethar", "CMSC 700"));
        assertFalse(list.isTaking("Ethar", "CMSC 789"));
        assertFalse(list.isTaking("Ethar", "CMSC 800"));
        assertFalse(list.isTaking("Ethar", "MATH 345"));
        assertFalse(list.isTaking("Johnny", "CMSC 567"));
        assertFalse(list.isTaking("Johnny", "CMSC 678"));
        assertFalse(list.isTaking("Johnny", "CMSC 700"));
        assertFalse(list.isTaking("Johnny", "CMSC 789"));
        assertFalse(list.isTaking("Johnny", "CMSC 800"));
        assertFalse(list.isTaking("Johnny", "MATH 345"));
        assertFalse(list.isTaking("Josh", "CMSC 456"));
        assertFalse(list.isTaking("Josh", "CMSC 678"));
        assertFalse(list.isTaking("Josh", "MATH 345"))
        assertFalse(list.isTaking("Leo", "CMSC 456"));
        assertFalse(list.isTaking("Leo", "CMSC 700"));
        assertFalse(list.isTaking("Leo", "CMSC 789"));
        assertFalse(list.isTaking("Leo", "CMSC 800"));
    }

    //private utility methods ////////////////////////////////////////////
    public CourseList courseList1() {
        return new CourseList();  // return an empty CourseList
    }

    public CourseList courseList2() {
        CourseList courseList= new CourseList();
        courseList.addCourse("Ethar", "CMSC 732");
        return courseList;
    }

    public CourseList courseList3() {
        CourseList courseList= new CourseList();
        courseList.addCourse("Ethar", "CMSC 678");
        courseList.addCourse("Josh", "CMSC 789");
        courseList.addCourse("Johnny", "CMSC 456");
        courseList.addCourse("Leo", "MATH 345");
        courseList.addCourse("Leo", "CMSC 567");
        courseList.addCourse("Ethar", "CMSC 456");
        courseList.addCourse("Josh", "CMSC 567");
        courseList.addCourse("Josh", "CMSC 700");
        courseList.addCourse("Josh", "CMSC 800");
        courseList.addCourse("Ethar", "CMSC 567");
        courseList.addCourse("Leo", "CMSC 678");

        return courseList;
    }
}