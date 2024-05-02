/**
 * INVENTORY REST CONTROLLER CLASS
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
 *    Java Utilities (List)
 *    Spring Framework Beans (Autowired)
 *    Spring Framework HTTP (HttpStatus, ResponseEntity)
 *    Spring Framework Web Bind Annotation (DeleteMapping, GetMapping, PathVariable, PostMapping, RequestBody, RequestMapping, RestController)
 *    DBMS Solution (Inventory, InventoryService)
 *    Lombok (AllArgsConstructor)
 */

package com.databases.dbmssolution.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.databases.dbmssolution.entity.Inventory;
import com.databases.dbmssolution.service.InventoryService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/inv")
public class InventoryRestController {
    
    @Autowired
    InventoryService inventoryService;

    @GetMapping("/{partNumber}")
    public ResponseEntity<Inventory> getInventory(@PathVariable Long partNumber) {
        return new ResponseEntity<>(inventoryService.getInventory(partNumber), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Inventory> saveInventory(@RequestBody Inventory inventory) {
        return new ResponseEntity<>(inventoryService.saveInventory(inventory), HttpStatus.CREATED);
    }

    @DeleteMapping("/{partNumber}")
    public ResponseEntity<HttpStatus> deleteInventory(@PathVariable Long partNumber) {
        inventoryService.deleteInventory(partNumber);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Inventory>> getAllInventory() {
        return new ResponseEntity<>(inventoryService.getAllInventory(), HttpStatus.OK);
    }
}