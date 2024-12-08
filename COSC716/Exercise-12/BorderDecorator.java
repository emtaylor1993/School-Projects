/**
 * BORDER DECORATOR CLASS
 * 
 * @author Emmanuel Taylor
 * 
 * @description
 *      This class represents a concrete implementation of the Decorator design
 *      pattern. It adds a border to the given widget object without altering its
 *      original interface.
 * 
 * @packages
 *      None
 */

public class BorderDecorator extends Decorator {
    public BorderDecorator(Widget widget) {
        super(widget);
    }

    @Override
    public void draw() {
        super.draw();
        System.out.println(" BorderDecorator");
    }
}
