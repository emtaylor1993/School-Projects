/**
 * SUBMIT ORDER COMMAND
 * 
 * @author Emmanuel Taylor
 * 
 * @description
 *    This class implements the command to allow the user to place an order
 *    by selecting a menu item.
 * 
 * @packages
 *    Java Utilities (Scanner)
 */

import java.util.Scanner;

public class SubmitOrderCommand implements Command {
    private Orders orders;
    private Inventory inventory;
    Scanner scanner = new Scanner(System.in);

    public SubmitOrderCommand(Orders orders, Inventory inventory) {
        this.orders = orders;
        this.inventory = inventory;
    }

    @Override
    public void execute() {
        System.out.println("Enter the item number to order: ");
        int itemNumber = scanner.nextInt();

        if (inventory.getStock(itemNumber) > 0) {
            orders.addOrderItem(new OrderItem(itemNumber));
            inventory.updateStock(itemNumber, 1);
            System.out.println("Order submitted!");   
        } else {
            System.out.println("Item is out of stock.");
        }
    }
}