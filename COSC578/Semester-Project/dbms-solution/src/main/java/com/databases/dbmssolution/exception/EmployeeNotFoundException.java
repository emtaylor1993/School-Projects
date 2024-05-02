/**
 * EMPLOYEE NOT FOUND EXCEPTION CLASS
 * 
 * @author Emmanuel Taylor
 * @author Kwaku Addow
 * @author So Ra Jang
 * @author Leonard Tangban
 * @author Keith Maina
 * 
 * @description
 *    This class represents a custom exception to be thrown if an employee ID
 *    cannot be found.
 */

package com.databases.dbmssolution.exception;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(Long employeeId) {
        super("The employee ID '" + employeeId + "' does not exist in our records.");
    }
}
