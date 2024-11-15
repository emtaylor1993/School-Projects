/**
 * MENU
 * 
 * @author Emmanuel Taylor
 * 
 * @description
 *    This class holds and manages a list of MenuItem objects.
 * 
 * @packages
 *    Java Utilities (ArrayList, List)
 */

import java.util.ArrayList;
import java.util.List;

public class Menu implements InventoryObserver {
    private List<MenuItem> items;

    public Menu() {
        items = new ArrayList<MenuItem>();
        items.add(new MenuItem(1, "Roast Beef", 15.99));
        items.add(new MenuItem(2, "Chicken Korma", 12.49));
        items.add(new MenuItem(3, "Jiaozi", 10.99));
    }

    public List<MenuItem> getItems() {
        return items;
    }

    @Override
    public void update(Menu menu) {
        System.out.println("Inventory updated! Refreshing menu...");
    }
}