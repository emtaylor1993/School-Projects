/**
 * EMPLOYEE REST CONTROLLER CLASS
 * 
 * @author Emmanuel Taylor
 * @author Kwaku Addow
 * @author So Ra Jang
 * @author Leonard Tangban
 * @author Keith Maina
 * 
 * @description
 *    This class represents the Change Order entity and it's attributes
 *    to be represented in the DBMS.
 * 
 * @packages
 *    Java Utilities (List)
 *    Spring Framework Beans (Autowired)
 *    Spring Framework HTTP (HttpStatus, ResponseEntity)
 *    Spring Framework Web Bind Annotation (DeleteMapping, GetMapping, PathVariable, PostMapping, RequestBody, RequestMapping, RestController)
 *    DBMS Solution (ChangeOrder, ChangeOrderService)
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
import com.databases.dbmssolution.entity.ChangeOrder;
import com.databases.dbmssolution.service.ChangeOrderService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/co")
public class ChangeOrderRestController {
    
    @Autowired
    ChangeOrderService changeOrderService;

    @GetMapping("/{coNumber}")
    public ResponseEntity<ChangeOrder> getChangeOrder(@PathVariable Long coNumber) {
        return new ResponseEntity<>(changeOrderService.getChangeOrder(coNumber), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ChangeOrder> saveChangeOrder(@RequestBody ChangeOrder changeOrder) {
        return new ResponseEntity<>(changeOrderService.saveChangeOrder(changeOrder), HttpStatus.CREATED);
    }

    @DeleteMapping("/{coNumber}")
    public ResponseEntity<HttpStatus> deleteChangeOrder(@PathVariable Long coNumber) {
        changeOrderService.deleteChangeOrder(coNumber);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ChangeOrder>> getChangeOrders() {
        return new ResponseEntity<>(changeOrderService.getChangeOrders(), HttpStatus.OK);
    }
}
