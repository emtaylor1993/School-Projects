/**
 * ABSTRACT FACTORY
 * 
 * @author Emmanuel Taylor
 * @author Vincent Gruse
 * @author Leo Tangban
 * 
 * @description
 *    This class provides an interface for creating families of related
 *    dependent objects without specifying their concrete classes.
 * 
 * @packages
 *    N/A
 */

public abstract class AbstractFactory {
    abstract Color getColor(String color);
    abstract Shape getShape(String shape);
}