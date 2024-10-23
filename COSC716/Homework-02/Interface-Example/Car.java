/**
 * CAR
 * 
 * @author Emmanuel Taylor
 * 
 * @description
 *      This class represents a Car that implements the interface Drivable.
 *      It provides its own implementation of the drive() method.
 * 
 * @packages
 *      N/A
 */

public class Car implements Drivable {

    // Fulfilling the contract by providing an implementation for
    // drive method.
    @Override
    public void drive() {
        System.out.println("The car is driving right now.");
    }
}
