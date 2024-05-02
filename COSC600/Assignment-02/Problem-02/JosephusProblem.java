/**
 * COSC600 Assignment 2, Problem #2 - Josephus Problem
 * @author Emmanuel Taylor
 * 
 * Description:
 *      This program will will simulate the Josephus Problem by repeatedly
 *      moving the n-th name from a given list of soldiers until only one
 *      survivor remains.
 * 
 * Packages Used:
 *      ArrayList, Scanner
 * 
 * Functions Called:
 *      performKills
 * 
 */
import java.util.ArrayList;
import java.util.Scanner;

public class JosephusProblem {

    // When running with command line arguments, use the following: 
    // java JosephusProblem 10 Andy Shawna Jianjia Adam Jacob Wesley Zahari Thomas Chris Ben 3 > JosephusProblem.txt
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> queue = new ArrayList<String>();

        System.out.println("############## JOSEPHUS PROBLEM ##############\n");

        // Get number of soldiers.
        System.out.print("How many soldiers? ");
        int numSoldiers = input.nextInt();

        // **** These lines were used when running with command line arguments ****
        // System.out.println("How many soldiers? " + Integer.parseInt(args[0]));
        // int numSoldiers = Integer.parseInt(args[0]);
        
        // Get names of soldiers and enqueue them.
        System.out.println("\nType " + numSoldiers + " soldiers' names: ");
        for (int index = 0; index < numSoldiers; index++) {
            queue.add(input.next() + " (" + (index + 1) + ")");
        }

        // **** These lines were used when running with command line arguments ****
        // System.out.println("\nType " + numSoldiers + " soldiers' names: ");
        // for (int index = 1; index < 11; index++) {
        //     System.out.println(args[index]);
        //     queue.add(args[index] + " (" + (index) + ")");
        // }

        // Get position to kill soldiers.
        System.out.print("\nEnter the position: ");
        int position = input.nextInt();

        // **** These lines were used when running with command line arguments ****
        // System.out.println("\nEnter the position: " + Integer.parseInt(args[11]));
        // int position = Integer.parseInt(args[11]);

        // Display eliminated soldiers.
        System.out.println("\nEliminating order: ");
        performKills(queue, position - 1, 0);
        input.close();
    }

    /**
     * Function Name: performKills
     * @param queue      (ArrayList<String>)
     * @param position   (int)
     * @param kill_index (int)
     * 
     * Inside the Function:
     *  1. Print the name of the killed soldier before removing them from the queue.
     *  2. Recursively kill soldiers until only one remains.
     *  3. Print out the survivor to join the Romans.
     */
    public static void performKills(ArrayList<String> queue, int position, int killIndex) {
        if (queue.size() == 1) {
            System.out.println("\nThe survivor is " + queue.get(0));
            return;
        }

        // Implementation of "Circular Array" by resetting front of "Queue"
        killIndex = (killIndex + position) % queue.size();
        System.out.println(queue.get(killIndex));
        queue.remove(killIndex);

        // Keep killing until only one person remains.
        performKills(queue, position, killIndex);
    }
}
