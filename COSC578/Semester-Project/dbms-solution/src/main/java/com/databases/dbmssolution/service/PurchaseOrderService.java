/**
 * PURCHASE ORDER SERVICE INTERFACE
 * 
 * @author Emmanuel Taylor
 * @author Kwaku Addow
 * @author So Ra Jang
 * @author Leonard Tangban
 * @author Keith Maina
 * 
 * @description
 *    This class represents the service interface to be implemented
 *    by the PurchaseOrder service.
 * 
 * @packages
 *    Java Utilities (List)
 *    DBMS Solution Entity (PurchaseOrder)
 */

package com.databases.dbmssolution.service;

import java.util.List;
import com.databases.dbmssolution.entity.PurchaseOrder;

public interface PurchaseOrderService {
    PurchaseOrder getPurchaseOrder(Long poNumber);
    PurchaseOrder savePurchaseOrder(PurchaseOrder purchaseOrder);
    void deletePurchaseOrder(Long poNumber);
    List<PurchaseOrder> getPurchaseOrders();
}
