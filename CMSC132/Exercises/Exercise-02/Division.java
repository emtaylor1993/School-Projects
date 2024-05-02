import java.util.Scanner;

public class Division {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        String x;
        boolean isDumb;
        int y = 132, number = 0, answer = 0;
	  
        System.out.print("Enter number: ");
	  
        do {
            try	{
	            x = input.next();
	            isDumb = false;
	            number = Integer.parseInt(x);
	            answer = y / number;
            } catch (NumberFormatException f) {
	            System.out.print("Invalid number- try again.  Enter number: ");
	            isDumb = true;
            } catch (ArithmeticException e) {
	            System.out.print("Division by zero- try again.  Enter number: ");
	            isDumb = true;
            }
        }
	  
        while (isDumb == true);
            System.out.print("The whole number of times 132 can be divided by " + number + " is " + answer + ".");
        
        input.close();
    }
}