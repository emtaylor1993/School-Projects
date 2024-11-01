/**
 * LIGHTS
 * 
 * @author Emmanuel Taylor
 * @author Leo Tangban
 * @author Vincent Gruse
 * 
 * @description
 *      This class represents the Lights observer class for the Observer Design Pattern.
 *      It implements the AlarmListener interface and turns on the lights.
 * 
 * @packages
 *      None
 */

public class Lighting implements AlarmListener {
    @Override
    public void alarm() {
        System.out.println("Lights up.");
    }
}
