/**
 * MAIN
 * 
 * @author Emmanuel Taylor
 * 
 * @description
 *    This class demonstrates the use of the Command, Decorator and Observer
 *    Design Patterns.
 * 
 * @packages
 *    N/A
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Orders orders = new Orders();
        Inventory inventory = new Inventory();
        inventory.addObserver(menu);
        Invoker invoker = new Invoker();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose from the options below:\n");
            System.out.println("1. Display Menu");
            System.out.println("2. Submit Order");
            System.out.println("3. Display Tab");
            System.out.println("4. Exit\n");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println();
                    invoker.executeCommand(new DisplayMenuCommand(menu));
                    break;
                case 2:
                    System.out.println();
                    invoker.executeCommand(new SubmitOrderCommand(orders, inventory));
                    break;
                case 3:
                    System.out.println();
                    invoker.executeCommand(new DisplayTabCommand(orders, menu));
                    break;
                case 4:
                    System.out.println();
                    scanner.close();
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println();
                    System.out.println("Invalid Option. Please choose from 1-4.");
            }
        }
    }
}