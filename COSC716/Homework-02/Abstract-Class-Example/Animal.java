/**
 * ANIMAL
 * 
 * @author Emmanuel Taylor
 * 
 * @description
 *      This abstract class represents an Animal object that other
 *      classes can inherit from.
 * 
 * @packages
 *      N/A
 */

public abstract class Animal {
    abstract void sound();

    public void sleep() {
        System.out.println("The animal is sleeping now.");
    }
}