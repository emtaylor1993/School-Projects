/**
 * GATES
 * 
 * @author Emmanuel Taylor
 * @author Leo Tangban
 * @author Vincent Gruse
 * 
 * @description
 *      This class represents the Gates observer class for the Observer Design Pattern.
 *      It implements the AlarmListener interface and closes the gates.
 * 
 * @packages
 *      None
 */

public class Gates implements AlarmListener {
    @Override
    public void alarm() {
        System.out.println("Gates closed.");
    }
}
