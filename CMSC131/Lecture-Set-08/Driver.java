import java.util.Random;

public class Driver {
	public static void main(String[] args) {
		final String[] toDoList= {"eat", "sleep", "study", "take exam",
			"go skydiving", "fix toilet", "do laundry", "go to class",
			"submit project", "publish novel", "go to concert", 
			"visit Amsterdam"};

		Month m = new Month("November", 30, 2);
		final int NUM_APPOINTMENTS = 40;
		Random generator = new Random();
		
		for (int i = 0; i < NUM_APPOINTMENTS; i++) {
			int date = generator.nextInt(30) + 1;
			String toDo = toDoList[generator.nextInt(toDoList.length)];
			m.addAppointment(date, toDo);
		}
		
		System.out.println(m);
	}
}
