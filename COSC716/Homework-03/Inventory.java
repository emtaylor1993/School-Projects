/**
 * INVENTORY
 * 
 * @author Emmanuel Taylor
 * 
 * @description
 *    This class manages the stock levels for menu items.
 * 
 * @packages
 *    Java Utilities (ArrayList, HashMap, List, Map)
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    private Map<Integer, Integer> stock;
    private List<InventoryObserver> observers;

    public Inventory() {
        stock = new HashMap<Integer, Integer>();
        observers = new ArrayList<InventoryObserver>();

        stock.put(1, 10);
        stock.put(2, 5);
        stock.put(3, 8);
    }

    public void addObserver(InventoryObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(InventoryObserver observer) {
        observers.remove(observer);
    }

    public void updateStock(int itemNumber, int quantity) {
        stock.put(itemNumber, stock.getOrDefault(itemNumber, 0) - quantity);
        notifyObservers();
    }

    public int getStock(int itemNumber) {
        return stock.getOrDefault(itemNumber, 0);
    }

    private void notifyObservers() {
        for (InventoryObserver observer : observers) {
            observer.update(new Menu());
        }
    }
}