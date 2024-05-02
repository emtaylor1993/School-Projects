/**
 * FINANCIAL DATA NOT FOUND EXCEPTION CLASS
 * 
 * @author Emmanuel Taylor
 * @author Kwaku Addow
 * @author So Ra Jang
 * @author Leonard Tangban
 * @author Keith Maina
 * 
 * @description
 *    This class represents a custom exception to be thrown if a financial ID
 *    cannot be found.
 */

package com.databases.dbmssolution.exception;

public class FinancialDataNotFoundException extends RuntimeException {
    public FinancialDataNotFoundException(Long financialId) {
        super("The financial ID '" + financialId + "' does not exist in our records.");
    }
}
