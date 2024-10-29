/**
 * DOG
 * 
 * @author Emmanuel Taylor
 * 
 * @description
 *      This class represents a Dog that inherits the sound method
 *      from the Animal abstract class.
 * 
 * @packages
 *      N/A
 */

public class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("The dog is barking now.");
    }
}
