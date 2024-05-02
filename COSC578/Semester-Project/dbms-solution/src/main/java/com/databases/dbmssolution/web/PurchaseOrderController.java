/**
 * PURCHASE ORDER CONTROLLER ENTRY POINT
 * 
 * @author Emmanuel Taylor
 * @author Kwaku Addow
 * @author So Ra Jang
 * @author Leonard Tangban
 * @author Keith Maina
 * 
 * @description
 *    This class handles web requests for the Purchase Order view.
 * 
 * @packages
 *    Java Utilities (ArrayList, List)
 *    Java Validation (Valid)
 *    Spring Framework Beans (Autowired)
 *    Spring Framework Stereotype (Controller)
 *    Spring Framework UI (Model)
 *    Spring Framework Validation (BindingResult)
 *    Spring Framework Web Bind Annotation (GetMapping, PostMapping, RequestParam)
 *    DBMS Solution (PurchaseOrder, PurchaseOrderService)
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
import com.databases.dbmssolution.entity.PurchaseOrder;
import com.databases.dbmssolution.service.PurchaseOrderService;

@Controller
public class PurchaseOrderController {

    @Autowired
    PurchaseOrderService purchaseOrderService;

    @GetMapping("/purchase_orders")
    public String getPurchaseOrderView(Model model) {
        model.addAttribute("purchaseOrders", purchaseOrderService.getPurchaseOrders());
        return "purchase_orders";
    }

    @GetMapping("/purchase_order_results")
    public String getPurchaseOrderResultsView(Model model, @RequestParam(required = false) String username) {
        List<PurchaseOrder> results = new ArrayList<PurchaseOrder>();
        List<PurchaseOrder> purchaseOrders = purchaseOrderService.getPurchaseOrders();
        for (int i = 0; i < purchaseOrders.size(); i++) {
            if (purchaseOrders.get(i).getEmployee().getUsername().equals(username)) {
                results.add(purchaseOrders.get(i));
            }
        }
        model.addAttribute("results", results);
        return "purchase_order_results";
    }

    @GetMapping("/purchase_order_search")
    public String getPurchaseOrderSearch(Model model) {
        model.addAttribute("purchaseOrders", purchaseOrderService.getPurchaseOrders());
        return "purchase_order_search";
    }

    @GetMapping("/purchase_order_form")
    public String getPurchaseOrderForm(Model model, @RequestParam(required = false) Long poNumber) {
        int index = getPurchaseOrderIndex(poNumber);
        model.addAttribute("purchaseOrder", index == -1000 ? new PurchaseOrder() : purchaseOrderService.getPurchaseOrders().get(index));
        return "purchase_order_form";
    }

    @GetMapping("/deletePurchaseOrder")
    public String deletePurchaseOrder(@RequestParam(required = false) Long poNumber) {
        purchaseOrderService.deletePurchaseOrder(poNumber);
        return "redirect:/purchase_orders";
    }

    @PostMapping("/submitPurchaseOrder")
    public String submitPurchaseOrderForm(@Valid PurchaseOrder purchaseOrder, BindingResult result) {
        if (result.hasErrors()) return "purchase_order_form";
        int index = getPurchaseOrderIndex(purchaseOrder.getPoNumber());
        if (index == -1000) {
            purchaseOrderService.savePurchaseOrder(purchaseOrder);
        } else {
            purchaseOrderService.getPurchaseOrders().set(index, purchaseOrder);
        }

        return "redirect:/purchase_orders";
    }

    public int getPurchaseOrderIndex(Long poNumber) {
        for (int i = 0; i < purchaseOrderService.getPurchaseOrders().size(); i++) {
            if (purchaseOrderService.getPurchaseOrders().get(i).getPoNumber().equals(poNumber)) return i;
        }
        return -1000;
    }
}