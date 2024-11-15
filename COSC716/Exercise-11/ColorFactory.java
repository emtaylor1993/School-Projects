/**
 * COLOR FACTORY
 * 
 * @author Emmanuel Taylor
 * @author Vincent Gruse
 * @author Leo Tangban
 * 
 * @description
 *    This class serves as a concrete factory to create and return instances
 *    of Color objects. It implements the getColor method from the AbstractFactory
 *    class.
 * 
 * @packages
 *    N/A
 */

public class ColorFactory extends AbstractFactory {
    @Override
    public Color getColor(String colorType) {
        if (colorType.equalsIgnoreCase("RED")) {
            return new Red();
        } else if (colorType.equalsIgnoreCase("GREEN")) {
            return new Green();
        } else if (colorType.equalsIgnoreCase("BLUE")) {
            return new Blue();
        } else {
            return null;
        }
    }

    @Override
    public Shape getShape(String shapeType) {
        return null;
    }
}