/**
 * CIRCLE
 * 
 * @author Emmanuel Taylor
 * @author Vincent Gruse
 * @author Leo Tangban
 * 
 * @description
 *    This class serves as a concrete implementation of the Shape interface in 
 *    the Abstract Factory design pattern. It represents specific behavior and
 *    characteristics of the shape Circle.
 * 
 * @packages
 *    N/A
 */

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle.draw() method.");
    }
}
