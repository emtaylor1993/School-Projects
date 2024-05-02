/**
 * FINANCIAL DATA SERVICE INTERFACE
 * 
 * @author Emmanuel Taylor
 * @author Kwaku Addow
 * @author So Ra Jang
 * @author Leonard Tangban
 * @author Keith Maina
 * 
 * @description
 *    This class represents the service interface to be implemented
 *    by the FinancialData service.
 * 
 * @packages
 *    Java Utilities (List)
 *    DBMS Solution Entity (FinancialData)
 */

package com.databases.dbmssolution.service;

import java.util.List;
import com.databases.dbmssolution.entity.FinancialData;

public interface FinancialDataService {
    FinancialData getFinancialData(Long financialId);
    FinancialData saveFinancialData(FinancialData financialData);
    void deleteFinancialData(Long financialId);
    List<FinancialData> getAllFinancialData();
}
