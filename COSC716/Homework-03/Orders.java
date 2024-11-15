/**
 * ORDERS
 * 
 * @author Emmanuel Taylor
 * 
 * @description
 *    This class is used to manage a collection of OrderItem objects.
 * 
 * @packages
 *    Java Utilities (ArrayList, List)
 */

import java.util.ArrayList;
import java.util.List;

public class Orders {
    private List<OrderItem> orderItems;

    public Orders() {
        orderItems = new ArrayList<OrderItem>();
    }

    public void addOrderItem(OrderItem item) {
        orderItems.add(item);
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
}