/**
 * FACTORY PRODUCER
 * 
 * @author Emmanuel Taylor
 * @author Vincent Gruse
 * @author Leo Tangban
 * 
 * @description
 *    This class acts as a factory of factories and promotes modularity
 *    and flexibility.
 * 
 * @packages
 *    N/A
 */

public class FactoryProducer {
    public static AbstractFactory getFactory(String choice) {
        if (choice.equalsIgnoreCase("SHAPE")) {
            return new ShapeFactory();
        } else if (choice.equalsIgnoreCase("COLOR")) {
            return new ColorFactory();
        } 

        return null;
    }
}