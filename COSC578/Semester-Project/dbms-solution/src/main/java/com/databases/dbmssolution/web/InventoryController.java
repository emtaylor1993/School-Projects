/**
 * INVENTORY CONTROLLER ENTRY POINT
 * 
 * @author Emmanuel Taylor
 * @author Kwaku Addow
 * @author So Ra Jang
 * @author Leonard Tangban
 * @author Keith Maina
 * 
 * @description
 *    This class handles web requests for the Employee view.
 * 
 * @packages
 *    Java Utilities (ArrayList, List)
 *    Java Validation (Valid)
 *    Spring Framework Beans (Autowired)
 *    Spring Framework Stereotype (Controller)
 *    Spring Framework UI (Model)
 *    Spring Framework Validation (BindingResult)
 *    Spring Framework Web Bind Annotation (GetMapping, PostMapping, RequestParam)
 *    DBMS Solution (Inventory, InventoryService)
 */

package com.databases.dbmssolution.web;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.databases.dbmssolution.entity.Inventory;
import com.databases.dbmssolution.service.InventoryService;

@Controller
public class InventoryController {

    @Autowired
    InventoryService inventoryService;
    
    @GetMapping("/inventory")
    public String getInventoryView(Model model) {
        model.addAttribute("inventory", inventoryService.getAllInventory());
        return "inventory";
    }

    @GetMapping("/inventory_results")
    public String getInventoryResultsView(Model model, @RequestParam(required = false) String username) {
        List<Inventory> results = new ArrayList<Inventory>();
        List<Inventory> inventory = inventoryService.getAllInventory();
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getEmployee().getUsername().equals(username)) {
                results.add(inventory.get(i));
            }
        }
        model.addAttribute("results", results);
        return "inventory_results";
    }

    @GetMapping("/inventory_search")
    public String getInventorySearch(Model model) {
        model.addAttribute("inventory", inventoryService.getAllInventory());
        return "inventory_search";
    }

    @GetMapping("/inventory_form")
    public String getInventoryForm(Model model, @RequestParam(required = false) Long partNumber) {
        int index = getInventoryIndex(partNumber);
        model.addAttribute("inventory", index == -1000 ? new Inventory() : inventoryService.getAllInventory().get(index));
        return "inventory_form";
    }

    @GetMapping("/deleteInventory")
    public String deleteInventory(@RequestParam(required = false) Long partNumber) {
        inventoryService.deleteInventory(partNumber);
        return "redirect:/inventory";
    }

    @PostMapping("/submitInventory")
    public String submitInventoryForm(@Valid Inventory inventory, BindingResult result) {
        if (result.hasErrors()) return "inventory_form";
        int index = getInventoryIndex(inventory.getPartNumber());
        if (index == -1000) {
            inventoryService.saveInventory(inventory);
        } else {
            inventoryService.getAllInventory().set(index, inventory);
        }

        return "redirect:/inventory";
    }

    public int getInventoryIndex(Long partNumber) {
        for (int i = 0; i < inventoryService.getAllInventory().size(); i++) {
            if (inventoryService.getAllInventory().get(i).getPartNumber().equals(partNumber)) return i;
        }
        return -1000;
    }
}
