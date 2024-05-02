// import everything so that different map types could be used
import java.util.*;

public class CourseList {
	Map<String, ArrayList<String>> courses = new HashMap<String, ArrayList<String>>();

	public void addCourse(String student, String course) {
		ArrayList<String> schedule = new ArrayList<String>();
		if (courses.containsKey(student))
			courses.get(student).add(course);
		else {
			schedule.add(course);
			courses.put(student, schedule);
		}
	}

	public boolean isTaking(String student, String course) {
		if(courses.containsKey(student)){
			return courses.get(student).contains(course);
		} else
			return false;
	}

	public int numEnrolled(String course) {
		int count = 0;
		for (String student : courses.keySet()) {
			if (courses.get(student).contains(course))
				count++;
		}
		
		return count;
	}
}