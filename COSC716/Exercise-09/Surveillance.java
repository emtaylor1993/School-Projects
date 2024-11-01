/**
 * SURVEILLANCE
 * 
 * @author Emmanuel Taylor
 * @author Leo Tangban
 * @author Vincent Gruse
 * 
 * @description
 *      This class represents the Surveillance observer class for the Observer Design Pattern.
 *      It implements the AlarmListener interface and activates the surveillance system.
 * 
 * @packages
 *      None
 */

public class Surveillance implements AlarmListener{
    @Override
    public void alarm() {
        System.out.println("Surveillance - by the numbers.");
    }
}
