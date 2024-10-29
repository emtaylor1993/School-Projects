/**
 * POLYMORPHISM DEMO
 * 
 * @author Emmanuel Taylor
 * 
 * @description
 *      This class represents a demonstration of the concept of Polymorphism
 *      by using an interface to handle printing the measurements of other
 *      object types.
 * 
 * @packages
 *      N/A
 */

public class PolymorphismDemo {
    public static void main(String[] args) {
        Measurable rectangle = new Rectangle(10, 10);
        Measurable pkg = new Package(10, 160);
        Measurable windSpeed = new WindSpeed(70);

        // Illustrates Polymorphism by using the Measurable method to handle
        // objects of other classes.
        printMeasurement(rectangle);
        printMeasurement(pkg);
        printMeasurement(windSpeed);
    }

    /**
     * Function: printMeasurement
     * @param measurable (Measurable)
     * 
     * Illustrates Polymorphism by using the Measurable class to print
     * measurements of other object classes.
     */
    public static void printMeasurement(Measurable measurable) {
        System.out.println(measurable.getMeasure());
    }
}
