import java.util.Scanner;

public class DateReader {
	public static int getYear(String d) {
		String yearString = d.substring(6, 10);  
		System.out.println("Done with substring method...");
		return Integer.parseInt(yearString);    
	}
	
	public static void main(String[] args) {
		String date = ""; 
		int year = 0;
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter date: (mm/dd/yyyy)");
			date = sc.next();
			year = getYear(date);
			
			if (year > 2009) {
                sc.close();
				throw new RuntimeException("year too big");
			}
			
			System.out.println("The year is " + year);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("index error");
		} catch(NumberFormatException e) {
			System.out.println("Number format problem");
			return;  
		} finally {
			System.out.println("Original string was: " + date);
		}
		
		System.out.println("At bottom of main method...");
		System.out.println("date: " + date + " has year: " + year);
        sc.close();
	}
}
