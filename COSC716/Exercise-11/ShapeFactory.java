/**
 * SHAPE FACTORY
 * 
 * @author Emmanuel Taylor
 * @author Vincent Gruse
 * @author Leo Tangban
 * 
 * @description
 *    This class serves as a concrete factory to create and return instances
 *    of Shape objects. It implements the getShape method from the AbstractFactory
 *    class.
 * 
 * @packages
 *    N/A
 */

public class ShapeFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shapeType) {
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else {
            return null;
        }
    }

    @Override
    public Color getColor(String colorType) {
        return null;
    }
}