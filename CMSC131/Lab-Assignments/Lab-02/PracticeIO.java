import java.util.Scanner;

/* This program will give you practice in Input/Output
 * as long as you do each of the tasks described 
 * below 
 * Your goal is to fill in the code required at the word HERE 
 * (possibly multiple lines for a single HERE)
 * Use the paragraph before the HERE to know exactly 
 * what that code needs to do
 * */

/* This project will not be tested on the submit server,
 * but do remember to submit it before you leave the lab section today
 * so it can be graded by your TA.
 */
public class PracticeIO {
	public static void main(String[] args) {
		Scanner inStream = new Scanner(System.in);
	
		System.out.println("Enter your full name " + "in the form: Firstname Middlename Lastname");
		// This portion assumes the user will type three words 
		// which are space delimited.
		// Write the variable declarations for 3 variables to store the
		// three parts of the name and the input line(s) to read them
		String first = inStream.next();
		String second = inStream.next();
		String last = inStream.next();
		
		// Print the name in the form: lastname, firstname
		System.out.println(last + ", " + first);
		System.out.println();
		//---------------------------------------------------------------------------------
		 
		System.out.println("Enter year you were born: ");
		 
		// This portion assumes the user will type an integer
		// representing the four digit year of their birth.
		// You may assume the current year is 2010.
		// Write the variable declarations for 1 variable to store the year
		// followed by the input line to read it
		int birthyear = inStream.nextInt();
		inStream.nextLine();
		int age = 2010 - birthyear;
		 
		// Print the approximate age of the person 
		// (assuming no difference depending on the current Month)  
		System.out.println("You are " + age + " years old.");
		System.out.println();
		//---------------------------------------------------------------------------------
		 
		System.out.println("Enter the city and state (or country) " + "where you were born on one line: ");
		// This portion assumes the user will type the location of their birth.
		// This will be a multi-word answer that should be read 
		//and stored as a single String
		// Write the variable declaration for 1 variable to store the location
		// followed by the input line to read it
		String birthPlace = inStream.nextLine();
		 
		// Print that the person was born in what year at what location in a
		// single sentence 
		System.out.println("You were born in " + birthPlace);
		//------------------------------------------------------------------------------
		 
		System.out.println("Enter your birth weight");
		//This portion assumes the user will type the weight they were at birth.
		//This will be a floating point value and should be stored as a single float.
		//Write the variable declaration for 1 float variable
		//followed by the input line to read it
		float birthWeight = inStream.nextFloat();
		 
		//Print the first name and the weight of that person on one line
		System.out.println(first + " " + birthWeight);
		 
		//----------------------------------------
		// Then add a section that prompts for and reads the name of a sibling
		// (in the same format as the first task in this exercise),
		// and then prompts for and reads their birth year 
		// (in the same format as the second task),
		System.out.println("Enter a sibling's full name in the format: First, Middle, Last.");
		String siblingFirst = inStream.next();
		String siblingMiddle = inStream.next();
		String siblingLast = inStream.next();
		System.out.println("What year was your sibling born?");
		int siblingYear = inStream.nextInt();
		int siblingAge = 2010 - siblingYear;
		 
		//Then print a line saying who is older
		if (siblingAge > age) {
			System.out.println(siblingLast + ", " + siblingFirst);
		} else {
			System.out.println(last + ", " + first);
		}
		
		//Then print a line saying who comes first alphabetically by first name
		if (first.compareTo(siblingFirst) > 0) {
			System.out.println(siblingFirst + " comes first alphabetically.");
		} else {
			System.out.println(first + " comes first alphabetically.");
		}

        inStream.close();
	}
}