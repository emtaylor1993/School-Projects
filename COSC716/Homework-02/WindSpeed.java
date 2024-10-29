/**
 * WIND SPEED
 * 
 * @author Emmanuel Taylor
 * 
 * @description
 *      This class represents a WindSpeed object that implements the
 *      Measurable interface. It returns a String containing its speed
 *      in miles per hour.
 * 
 * @packages
 *      N/A
 */

public class WindSpeed implements Measurable {
    private double speed;

    public WindSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public String getMeasure() {
        return "The Wind Speed is " + speed + " miles per hour.";
    }
}
