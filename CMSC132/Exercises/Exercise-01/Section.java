import java.util.ArrayList;
import java.util.Iterator;
public class Section implements Iterable<Student> {
    private String sectionNumber;
    private ArrayList<Student> studentList;

    public Section(String sectionNumber) {
        this.sectionNumber = sectionNumber;
        studentList = new ArrayList<Student>();
    }

    public void addStudent(Student s) {
        studentList.add(s);
    }

    public String getSectionNumber() {
        return sectionNumber;
    }

    public Iterator<Student> iterator() {
        return new MyIterator(studentList);
    }
}