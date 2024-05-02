/**
 * INVENTORY SERVICE INTERFACE
 * 
 * @author Emmanuel Taylor
 * @author Kwaku Addow
 * @author So Ra Jang
 * @author Leonard Tangban
 * @author Keith Maina
 * 
 * @description
 *    This class represents the service interface to be implemented
 *    by the Inventory service.
 * 
 * @packages
 *    Java Utilities (List)
 *    DBMS Solution Entity (Inventory)
 */

package com.databases.dbmssolution.service;

import java.util.List;
import com.databases.dbmssolution.entity.Inventory;

public interface InventoryService {
    Inventory getInventory(Long partNumber);
    Inventory saveInventory(Inventory inventory);
    void deleteInventory(Long partNumber);
    List<Inventory> getAllInventory();
}
