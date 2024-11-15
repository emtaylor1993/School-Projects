/**
 * RED
 * 
 * @author Emmanuel Taylor
 * @author Vincent Gruse
 * @author Leo Tangban
 * 
 * @description
 *    This class serves as a concrete implementation of the Color interface in 
 *    the Abstract Factory design pattern. It represents specific behavior and
 *    characteristics of the color Red.
 * 
 * @packages
 *    N/A
 */

public class Red implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Red.fill() method.");
    }
}