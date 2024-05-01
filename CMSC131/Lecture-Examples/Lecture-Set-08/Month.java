public class Month {
	private String name;
	private Day[][] days;
	private int startingPosition;  

	private static final String[] WEEKDAYS = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

	public Month(String name, int daysInMonth, int startingPosition) {
		this.name = name;
		this.startingPosition = startingPosition;

		int numDaysNeeded = startingPosition + daysInMonth;
		int rowsNeeded = (numDaysNeeded - 1) / 7 + 1;

		days = new Day[rowsNeeded][7];

		int dateCounter = 1 - startingPosition;
		
		for (int row = 0; row < rowsNeeded; row++) {
			for (int col = 0; col < 7; col++) {
				if (dateCounter < 1 || dateCounter > daysInMonth) { // unused portion
					days[row][col] = new Day("Unused", 0);
				} else {
					days[row][col] = new Day(WEEKDAYS[col], dateCounter);
				}
				
				dateCounter++;
			}
		}
	}

	public void addAppointment(int date, String a) {
		int dateCounter = date + startingPosition - 1;
		int row = dateCounter / 7;
		int col = dateCounter % 7;
		days[row][col].addAppointment(a);
	}

	public String toString() {
		String s = name + "\n";
		
		for (int i = 0; i < days.length; i++) {
			for (int j = 0; j < days[i].length; j++) {
				s += "    " + days[i][j] + "\n";
			}
			
			s += "\n";
		}
		
		return s;
	}
}
