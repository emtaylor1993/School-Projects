/**
 * CHANGE ORDER CONTROLLER ENTRY POINT
 * 
 * @author Emmanuel Taylor
 * @author Kwaku Addow
 * @author So Ra Jang
 * @author Leonard Tangban
 * @author Keith Maina
 * 
 * @description
 *    This class handles web requests for the Change Order view.
 * 
 * @packages
 *    Java Utilities (ArrayList, List)
 *    Java Validation (Valid)
 *    Spring Framework Beans (Autowired)
 *    Spring Framework Stereotype (Controller)
 *    Spring Framework UI (Model)
 *    Spring Framework Validation (BindingResult)
 *    Spring Framework Web Bind Annotation (GetMapping, PostMapping, RequestParam)
 *    DBMS Solution (ChangeOrder, ChangeOrderService)
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
import com.databases.dbmssolution.entity.ChangeOrder;
import com.databases.dbmssolution.service.ChangeOrderService;

@Controller
public class ChangeOrderController {

    @Autowired
    ChangeOrderService changeOrderService;

    @GetMapping("/change_orders")
    public String getChangeOrderView(Model model) {
        model.addAttribute("changeOrders", changeOrderService.getChangeOrders());
        return "change_orders";
    }

    @GetMapping("/change_order_results")
    public String getChangeOrderResultsView(Model model, @RequestParam(required = false) String username) {
        List<ChangeOrder> results = new ArrayList<ChangeOrder>();
        List<ChangeOrder> changeOrders = changeOrderService.getChangeOrders();
        for (int i = 0; i < changeOrders.size(); i++) {
            if (changeOrders.get(i).getEmployee().getUsername().equals(username)) {
                results.add(changeOrders.get(i));
            }
        }
        model.addAttribute("results", results);
        return "change_order_results";
    }

    @GetMapping("/change_order_search")
    public String getChangeOrderSearch(Model model) {
        model.addAttribute("changeOrders", changeOrderService.getChangeOrders());
        return "change_order_search";
    }

    @GetMapping("/change_order_form")
    public String getChangeOrderForm(Model model, @RequestParam(required = false) Long coNumber) {
        int index = getChangeOrderIndex(coNumber);
        model.addAttribute("changeOrder", index == -1000 ? new ChangeOrder() : changeOrderService.getChangeOrders().get(index));
        return "change_order_form";
    }

    @GetMapping("/deleteChangeOrder")
    public String deleteChangeOrder(@RequestParam(required = false) Long coNumber) {
        changeOrderService.deleteChangeOrder(coNumber);
        return "redirect:/change_orders";
    }

    @PostMapping("/submitChangeOrder")
    public String submitChangeOrderForm(@Valid ChangeOrder changeOrder, BindingResult result) {
        if (result.hasErrors()) return "change_order_form";
        int index = getChangeOrderIndex(changeOrder.getCoNumber());
        if (index == -1000) {
            changeOrderService.saveChangeOrder(changeOrder);
        } else {
            changeOrderService.getChangeOrders().set(index, changeOrder);
        }

        return "redirect:/change_orders";
    }

    public int getChangeOrderIndex(Long coNumber) {
        for (int i = 0; i < changeOrderService.getChangeOrders().size(); i++) {
            if (changeOrderService.getChangeOrders().get(i).getCoNumber().equals(coNumber)) return i;
        }
        return -1000;
    }
}