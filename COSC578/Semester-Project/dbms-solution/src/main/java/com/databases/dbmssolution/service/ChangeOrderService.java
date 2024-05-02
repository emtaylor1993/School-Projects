/**
 * CHANGE ORDER SERVICE INTERFACE
 * 
 * @author Emmanuel Taylor
 * @author Kwaku Addow
 * @author So Ra Jang
 * @author Leonard Tangban
 * @author Keith Maina
 * 
 * @description
 *    This class represents the service interface to be implemented
 *    by the ChangeOrder service.
 * 
 * @packages
 *    Java Utilities (List)
 *    DBMS Solution Entity (ChangeOrder)
 */

package com.databases.dbmssolution.service;

import java.util.List;
import com.databases.dbmssolution.entity.ChangeOrder;

public interface ChangeOrderService {
    ChangeOrder getChangeOrder(Long coNumber);
    ChangeOrder saveChangeOrder(ChangeOrder changeOrder);
    void deleteChangeOrder(Long coNumber);
    List<ChangeOrder> getChangeOrders();
}
