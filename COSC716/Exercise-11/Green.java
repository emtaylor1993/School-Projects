/**
 * GREEN
 * 
 * @author Emmanuel Taylor
 * @author Vincent Gruse
 * @author Leo Tangban
 * 
 * @description
 *    This class serves as a concrete implementation of the Color interface in 
 *    the Abstract Factory design pattern. It represents specific behavior and
 *    characteristics of the color Green.
 * 
 * @packages
 *    N/A
 */

public class Green implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Green.fill() method.");
    }
}