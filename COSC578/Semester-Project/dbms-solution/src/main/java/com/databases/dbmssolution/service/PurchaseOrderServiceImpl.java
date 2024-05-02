/**
 * PURCHASE ORDER SERVICE IMPLEMENTATION CLASS
 * 
 * @author Emmanuel Taylor
 * @author Kwaku Addow
 * @author So Ra Jang
 * @author Leonard Tangban
 * @author Keith Maina
 * 
 * @description
 *    This class represents the PurchaseOrder entity and it's attributes
 *    to be represented in the DBMS.
 * 
 * @packages
 *    Java Utilities (List, Optional)
 *    Spring Framework Stereotype (Service)
 *    DBMS Solution (PurchaseOrder, PurchaseOrderNotFoundException, PurchaseOrderRepository)
 *    Lombok (AllArgsConstructor)
 */

package com.databases.dbmssolution.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.databases.dbmssolution.entity.PurchaseOrder;
import com.databases.dbmssolution.exception.PurchaseOrderNotFoundException;
import com.databases.dbmssolution.repository.PurchaseOrderRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
    PurchaseOrderRepository purchaseOrderRepository;
    
    @Override
    public PurchaseOrder getPurchaseOrder(Long poNumber) {
        Optional<PurchaseOrder> purchaseOrder = purchaseOrderRepository.findById(poNumber);
        return unwrapPurchaseOrder(purchaseOrder, poNumber);
    }

    @Override
    public PurchaseOrder savePurchaseOrder(PurchaseOrder purchaseOrder) {
        return purchaseOrderRepository.save(purchaseOrder);
    }

    @Override
    public void deletePurchaseOrder(Long poNumber) {
        purchaseOrderRepository.deleteById(poNumber);
    }

    @Override
    public List<PurchaseOrder> getPurchaseOrders() {
        return (List<PurchaseOrder>) purchaseOrderRepository.findAll();
    }

    static PurchaseOrder unwrapPurchaseOrder(Optional<PurchaseOrder> entity, Long poNumber) {
        if (entity.isPresent()) return entity.get();
        else throw new PurchaseOrderNotFoundException(poNumber);
    }
}
