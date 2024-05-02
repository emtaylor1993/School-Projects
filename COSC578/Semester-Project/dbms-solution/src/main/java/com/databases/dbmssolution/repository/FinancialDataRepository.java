/**
 * FINANCIAL DATA REPOSITORY CLASS
 * 
 * @author Emmanuel Taylor
 * @author Kwaku Addow
 * @author So Ra Jang
 * @author Leonard Tangban
 * @author Keith Maina
 * 
 * @description
 *    This class represents the repository to hold FinancialData objects
 *    that are intially loaded into the database.
 * 
 * @packages
 *    Spring Framework Data Repository (CrudRepository)
 *    DBMS Solution Entity (FinancialData)
 */

package com.databases.dbmssolution.repository;

import org.springframework.data.repository.CrudRepository;
import com.databases.dbmssolution.entity.FinancialData;

public interface FinancialDataRepository extends CrudRepository<FinancialData, Long> {
    
}
