/**
 * CHANGE ORDER SERVICE IMPLEMENTATION CLASS
 * 
 * @author Emmanuel Taylor
 * @author Kwaku Addow
 * @author So Ra Jang
 * @author Leonard Tangban
 * @author Keith Maina
 * 
 * @description
 *    This class represents the ChangeOrder entity and it's attributes
 *    to be represented in the DBMS.
 * 
 * @packages
 *    Java Utilities (List, Optional)
 *    Spring Framework Stereotype (Service)
 *    DBMS Solution (ChangeOrder, ChangeOrderNotFoundException, ChangeOrderRepository)
 *    Lombok (AllArgsConstructor)
 */

package com.databases.dbmssolution.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.databases.dbmssolution.entity.ChangeOrder;
import com.databases.dbmssolution.exception.ChangeOrderNotFoundException;
import com.databases.dbmssolution.repository.ChangeOrderRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ChangeOrderServiceImpl implements ChangeOrderService {
    ChangeOrderRepository changeOrderRepository;

    @Override
    public ChangeOrder getChangeOrder(Long coNumber) {
        Optional<ChangeOrder> changeOrder = changeOrderRepository.findById(coNumber);
        return unwrapChangeOrder(changeOrder, coNumber);
    }

    @Override
    public ChangeOrder saveChangeOrder(ChangeOrder changeOrder) {
        return changeOrderRepository.save(changeOrder);
    }

    @Override
    public void deleteChangeOrder(Long coNumber) {
        changeOrderRepository.deleteById(coNumber);
    }

    @Override
    public List<ChangeOrder> getChangeOrders() {
        return (List<ChangeOrder>) changeOrderRepository.findAll();
    }

    static ChangeOrder unwrapChangeOrder(Optional<ChangeOrder> entity, Long coNumber) {
        if (entity.isPresent()) return entity.get();
        else throw new ChangeOrderNotFoundException(coNumber);
    }
}
