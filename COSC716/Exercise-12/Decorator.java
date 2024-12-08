/**
 * DECORATOR CLASS
 * 
 * @author Emmanuel Taylor
 * 
 * @description
 *      This class represents an abstract implementation of the Decorator
 *      design pattern. It provides a base for concrete decorators to add
 *      functionality to a Widget object without altering its interface.
 * 
 * @packages
 *      None
 */

public abstract class Decorator implements Widget {
    protected Widget widget;

    public Decorator(Widget widget) {
        this.widget = widget;
    }

    @Override
    public void draw() {
        widget.draw();
    }
}
