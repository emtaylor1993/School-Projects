/**
 * INVENTORY NOT FOUND EXCEPTION CLASS
 * 
 * @author Emmanuel Taylor
 * @author Kwaku Addow
 * @author So Ra Jang
 * @author Leonard Tangban
 * @author Keith Maina
 * 
 * @description
 *    This class represents a custom exception to be thrown if an inventory part #
 *    cannot be found.
 */

package com.databases.dbmssolution.exception;

public class InventoryNotFoundException extends RuntimeException {
    public InventoryNotFoundException(Long partNumber) {
        super("The part number '" + partNumber + "' does not exist in our records.");
    }
}
