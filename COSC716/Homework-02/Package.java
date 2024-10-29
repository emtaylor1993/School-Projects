/**
 * PACKAGE
 * 
 * @author Emmanuel Taylor
 * 
 * @description
 *      This class represents a Package object that implements the
 *      Measurable interface. It returns a String containing its weight
 *      in pounds and objects.
 * 
 * @packages
 *      N/A
 */

public class Package implements Measurable {
    private double weightLbs;
    private double weightOz;

    public Package(double weightLbs, double weightOz) {
        this.weightLbs = weightLbs;
        this.weightOz = weightOz;
    }

    @Override
    public String getMeasure() {
        return "The Package weighs " + weightLbs + " in pounds and " + weightOz + " in ounces.";
    }
}
