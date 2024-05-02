/**
 * COSC600 Assignment 1, Problem #2 - Decimal to Binary Conversion
 * @author Emmanuel Taylor
 * 
 * Description:
 *      Converts an entered positive decimal into a binary string
 *      representation using a recursion.
 * 
 * Packages Used:
 *      Scanner
 * 
 * Functions Called:
 *      convert
 * 
 */

import java.util.Scanner;

public class DecimalToBinaryConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive decimal number: ");
        int number = scanner.nextInt();
        String binary = convert(number);
        System.out.println("\nThe binary number is " + binary);
        scanner.close();
    }

    /**
     * Function Name: convert
     * 
     * @param decimal (int)
     * @return        (String)
     * 
     * Inside the Function:
     *  1. Divides decimal by 2.
     *  2. Stores the remainder for each bit.
     *  3. Continues recursively until decimal == 0.
     */
    public static String convert(int decimal) {
        if (decimal == 0) {
            return "";
        } else {
            return convert(decimal / 2) + String.valueOf(decimal % 2) + " ";
        }
    }
}
