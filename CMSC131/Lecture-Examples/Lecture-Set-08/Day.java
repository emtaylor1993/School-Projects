public class Day {
	private String[] appointments;
	private String dayName;
	private int date;

	public Day(String dayName, int date) {
		this.dayName = dayName;
		this.date = date;
		appointments = new String[0];
	}

	public void addAppointment(String a) {
		String[] bigger = new String[appointments.length + 1];
		
		for (int i = 0; i < appointments.length; i++) {
			bigger[i] = appointments[i];
		}
		
		bigger[bigger.length - 1] = a;
		appointments = bigger;
	}

	public String toString() {
		if (dayName.equals("Unused")) {
			return "Unused";
		}
		
		String s = dayName + " " + date + "  Appointments: ";
		
		for (int i = 0; i < appointments.length; i++) {
			s += "  " + (i + 1) +  ". " + appointments[i];
		}
		
		return s;
	}
}
