/**
 * SQUARE
 * 
 * @author Emmanuel Taylor
 * @author Vincent Gruse
 * @author Leo Tangban
 * 
 * @description
 *    This class serves as a concrete implementation of the Shape interface in 
 *    the Abstract Factory design pattern. It represents specific behavior and
 *    characteristics of the shape Square.
 * 
 * @packages
 *    N/A
 */

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square.draw() method.");
    }
}