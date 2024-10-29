/**
 * RECTANGLE
 * 
 * @author Emmanuel Taylor
 * 
 * @description
 *      This class represents a Rectangle object that implements the
 *      Measurable interface. It returns a String containing its height
 *      and width in inches.
 * 
 * @packages
 *      N/A
 */

public class Rectangle implements Measurable {
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public String getMeasure() {
        return "The Rectangle is " + height + " inches in height, and " + width + " inches wide.";
    }
}
