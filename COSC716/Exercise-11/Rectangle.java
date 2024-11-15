/**
 * RECTANGLE
 * 
 * @author Emmanuel Taylor
 * @author Vincent Gruse
 * @author Leo Tangban
 * 
 * @description
 *    This class serves as a concrete implementation of the Shape interface in 
 *    the Abstract Factory design pattern. It represents specific behavior and
 *    characteristics of the shape Rectangle.
 * 
 * @packages
 *    N/A
 */

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle.draw() method.");
    }
}