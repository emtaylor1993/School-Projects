/**
 * FINANCIAL DATA SERVICE IMPLEMENTATION CLASS
 * 
 * @author Emmanuel Taylor
 * @author Kwaku Addow
 * @author So Ra Jang
 * @author Leonard Tangban
 * @author Keith Maina
 * 
 * @description
 *    This class represents the FinancialData entity and it's attributes
 *    to be represented in the DBMS.
 * 
 * @packages
 *    Java Utilities (List, Optional)
 *    Spring Framework Stereotype (Service)
 *    DBMS Solution (FinancialData, FinancialDataNotFoundException, FinancialDataRepository)
 *    Lombok (AllArgsConstructor)
 */

package com.databases.dbmssolution.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.databases.dbmssolution.entity.FinancialData;
import com.databases.dbmssolution.exception.FinancialDataNotFoundException;
import com.databases.dbmssolution.repository.FinancialDataRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FinancialDataServiceImpl implements FinancialDataService {
    FinancialDataRepository financialDataRepository;

    @Override
    public FinancialData getFinancialData(Long id) {
        Optional<FinancialData> financialData = financialDataRepository.findById(id);
        return unwrapFinancialData(financialData, id);
    }

    @Override
    public FinancialData saveFinancialData(FinancialData financialData) {
        return financialDataRepository.save(financialData);
    }

    @Override
    public void deleteFinancialData(Long id) {
        financialDataRepository.deleteById(id);
    }

    @Override
    public List<FinancialData> getAllFinancialData() {
        return (List<FinancialData>) financialDataRepository.findAll();
    }

    static FinancialData unwrapFinancialData(Optional<FinancialData> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new FinancialDataNotFoundException(id);
    }
}
