/* Have you ever noticed that your dryer eats your socks? 
 * This example illustrates variables and the assignment
 * operator (=)    
 * Note that each variable is "declared" just ONCE!   */

public class VariablesExample {
    public static void main(String[] args) {
        int numberOfSocks;
        numberOfSocks = 27;     // An odd number of socks??? Crazy.
        System.out.print("The number of socks at the beginning is: ");
        System.out.println(numberOfSocks);
        System.out.println("OK, I'm going to put them in the dryer...");
        int socksLostInDryer = numberOfSocks / 3;    // I lose about a third each time
        numberOfSocks = numberOfSocks - socksLostInDryer;
        System.out.print("The number of socks lost was: ");
        System.out.println(socksLostInDryer);
        System.out.print("The number of socks is now: ");        
        System.out.println(numberOfSocks);
    }
}