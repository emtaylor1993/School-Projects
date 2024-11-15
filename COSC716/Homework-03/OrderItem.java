/**
 * ORDER ITEM
 * 
 * @author Emmanuel Taylor
 * 
 * @description
 *    This class represents a single item in an order that will be
 *    identified by its item number.
 * 
 * @packages
 *    N/A
 */

public class OrderItem {
    private int itemNumber;

    public OrderItem(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public int getItemNumber() {
        return itemNumber;
    }
}