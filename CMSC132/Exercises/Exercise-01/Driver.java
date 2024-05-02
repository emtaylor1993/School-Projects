import java.util.Iterator;

public class Driver {
    public static void main(String args[]) {
        Section discussion= new Section("0101");
        Iterator<Student> iter;

        discussion.addStudent(new Student("Mary", 10010, 3.7));
        discussion.addStudent(new Student("Bob",  22244, 2.8));
        discussion.addStudent(new Student("Laura", 17654, 2.1));
        discussion.addStudent(new Student("Albert", 34434, 3.4));

        iter = discussion.iterator();

        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}