/**
 * SCROLL DECORATOR CLASS
 * 
 * @author Emmanuel Taylor
 * 
 * @description
 *      This class represents a concrete implementation of the Decorator design
 *      pattern. It adds scrolling functionality to the given widget object without 
 *      altering its original interface.
 * 
 * @packages
 *      None
 */

public class ScrollDecorator extends Decorator {
    public ScrollDecorator(Widget widget) {
        super(widget);
    }

    @Override
    public void draw() {
        super.draw();
        System.out.println(" ScrollDecorator");
    }
}
