/**
 * INVENTORY SERVICE IMPLEMENTATION CLASS
 * 
 * @author Emmanuel Taylor
 * @author Kwaku Addow
 * @author So Ra Jang
 * @author Leonard Tangban
 * @author Keith Maina
 * 
 * @description
 *    This class represents the Inventory entity and it's attributes
 *    to be represented in the DBMS.
 * 
 * @packages
 *    Java Utilities (List, Optional)
 *    Spring Framework Stereotype (Service)
 *    DBMS Solution (Inventory, InventoryNotFoundException, InventoryRepository)
 *    Lombok (AllArgsConstructor)
 */

package com.databases.dbmssolution.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.databases.dbmssolution.entity.Inventory;
import com.databases.dbmssolution.exception.InventoryNotFoundException;
import com.databases.dbmssolution.repository.InventoryRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class InventoryServiceImpl implements InventoryService {
    InventoryRepository inventoryRepository;

    @Override
    public Inventory getInventory(Long partNumber) {
        Optional<Inventory> inventory = inventoryRepository.findById(partNumber);
        return unwrapInventory(inventory, partNumber);
    }

    @Override
    public Inventory saveInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public void deleteInventory(Long partNumber) {
        inventoryRepository.deleteById(partNumber);
    }

    @Override
    public List<Inventory> getAllInventory() {
        return (List<Inventory>) inventoryRepository.findAll();
    }

    static Inventory unwrapInventory(Optional<Inventory> entity, Long partNumber) {
        if (entity.isPresent()) return entity.get();
        else throw new InventoryNotFoundException(partNumber);
    }
}
