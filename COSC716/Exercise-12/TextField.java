/**
 * TEXT FIELD CLASS
 * 
 * @author Emmanuel Taylor
 * 
 * @description
 *      This class represents a concrete implementation of the Widget interface.
 *      It consists of a simple text field widget with a specified width and
 *      height.
 * 
 * @packages
 *      None
 */

public class TextField implements Widget {
    private int width;
    private int height;

    public TextField(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("This is a TextField with width: " + width + " and height: " + height);
    }
}
