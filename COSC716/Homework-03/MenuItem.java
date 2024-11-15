/**
 * MENU ITEM
 * 
 * @author Emmanuel Taylor
 * 
 * @description
 *    This class represents individual menu items with attributes such as 
 *    item number, description and price.
 * 
 * @packages
 *    N/A
 */

public class MenuItem {
    private int itemNumber;
    private String description;
    private double price;

    public MenuItem(int itemNumber, String description, double price) {
        this.itemNumber = itemNumber;
        this.description = description;
        this.price = price;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }
}