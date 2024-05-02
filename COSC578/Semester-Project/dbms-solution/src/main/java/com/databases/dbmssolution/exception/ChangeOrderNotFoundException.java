/**
 * CHANGE ORDER NOT FOUND EXCEPTION CLASS
 * 
 * @author Emmanuel Taylor
 * @author Kwaku Addow
 * @author So Ra Jang
 * @author Leonard Tangban
 * @author Keith Maina
 * 
 * @description
 *    This class represents a custom exception to be thrown if a Change Order #
 *    cannot be found.
 */

package com.databases.dbmssolution.exception;

public class ChangeOrderNotFoundException extends RuntimeException {
    public ChangeOrderNotFoundException(Long coNumber) {
        super("The CO Number: '" + coNumber + "' does not exist in our records.");
    }
}
