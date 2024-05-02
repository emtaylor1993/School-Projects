/**
 * EMPLOYEE SERVICE IMPLEMENTATION CLASS
 * 
 * @author Emmanuel Taylor
 * @author Kwaku Addow
 * @author So Ra Jang
 * @author Leonard Tangban
 * @author Keith Maina
 * 
 * @description
 *    This class represents the Employee entity and it's attributes
 *    to be represented in the DBMS.
 * 
 * @packages
 *    Java Utilities (List, Optional)
 *    Spring Framework Stereotype (Service)
 *    DBMS Solution (Employee, EmployeeNotFoundException, EmployeeRepository)
 *    Lombok (AllArgsConstructor)
 */

package com.databases.dbmssolution.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.databases.dbmssolution.entity.Employee;
import com.databases.dbmssolution.exception.EmployeeNotFoundException;
import com.databases.dbmssolution.repository.EmployeeRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository;

    @Override
    public Employee getEmployee(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return unwrapEmployee(employee, id);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> getEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    static Employee unwrapEmployee(Optional<Employee> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new EmployeeNotFoundException(id);
    }
}
