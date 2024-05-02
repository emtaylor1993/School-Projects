/**
 * EMPLOYEE SERVICE INTERFACE
 * 
 * @author Emmanuel Taylor
 * @author Kwaku Addow
 * @author So Ra Jang
 * @author Leonard Tangban
 * @author Keith Maina
 * 
 * @description
 *    This class represents the service interface to be implemented
 *    by the Employee service.
 * 
 * @packages
 *    Java Utilities (List)
 *    DBMS Solution Entity (Employee)
 */

package com.databases.dbmssolution.service;

import java.util.List;
import com.databases.dbmssolution.entity.Employee;

public interface EmployeeService {
    Employee getEmployee(Long employeeId);
    Employee saveEmployee(Employee employee);
    void deleteEmployee(Long employeeId);
    List<Employee> getEmployees();
}
