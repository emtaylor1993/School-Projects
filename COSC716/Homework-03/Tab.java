/**
 * TAB
 * 
 * @author Emmanuel Taylor
 * 
 * @description
 *    This class serves as the base class responsible for calculating and 
 *    generating base bill details. It also serves as the core of the Decorator
 *    Pattern which allows additional features such as service charges to be
 *    dynamically applied.
 * 
 * @packages
 *    Java Utilities (List)
 */

import java.util.List;

public class Tab {
    public String[] generateTab(Orders orders, Menu menu) {
        List<OrderItem> orderItems = orders.getOrderItems();
        List<MenuItem> menuItems = menu.getItems();
        double total = 0;

        String[] tabDetails = new String[orderItems.size() + 1];
        int index = 0;

        for (OrderItem orderItem : orderItems) {
            for (MenuItem menuItem : menuItems) {
                if (menuItem.getItemNumber() == orderItem.getItemNumber()) {
                    tabDetails[index++] = menuItem.getDescription() + " - $" + menuItem.getPrice();
                    total += menuItem.getPrice();
                }
            }
        }

        tabDetails[index] = "Total: $" + total;
        return tabDetails;
    }
}