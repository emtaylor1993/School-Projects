/**
 * INVENTORY OBSERVER
 * 
 * @author Emmanuel Taylor
 * 
 * @description
 *    This class defines the interface for defining the update method used
 *    by classes that observe inventory changes.
 * 
 * @packages
 *    N/A
 */

public interface InventoryObserver {
    void update(Menu menu);
}