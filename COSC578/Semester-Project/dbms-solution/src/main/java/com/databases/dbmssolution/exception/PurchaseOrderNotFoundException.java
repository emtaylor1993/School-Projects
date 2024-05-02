/**
 * PURCHASE ORDER NOT FOUND EXCEPTION CLASS
 * 
 * @author Emmanuel Taylor
 * @author Kwaku Addow
 * @author So Ra Jang
 * @author Leonard Tangban
 * @author Keith Maina
 * 
 * @description
 *    This class represents a custom exception to be thrown if a Purchase Order #
 *    cannot be found.
 */

package com.databases.dbmssolution.exception;

public class PurchaseOrderNotFoundException extends RuntimeException {
    public PurchaseOrderNotFoundException(Long poNumber) {
        super("The PO number '" + poNumber + "' does not exist in our records.");
    }
}
