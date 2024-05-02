/**
 * EMPLOYEE REPOSITORY CLASS
 * 
 * @author Emmanuel Taylor
 * @author Kwaku Addow
 * @author So Ra Jang
 * @author Leonard Tangban
 * @author Keith Maina
 * 
 * @description
 *    This class represents the repository to hold Employee objects
 *    that are intially loaded into the database.
 * 
 * @packages
 *    Spring Framework Data Repository (CrudRepository)
 *    DBMS Solution Entity (Employee)
 */

package com.databases.dbmssolution.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.databases.dbmssolution.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    Optional<Employee> findByUsername(String username);
}