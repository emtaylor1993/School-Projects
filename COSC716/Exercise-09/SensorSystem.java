/**
 * SENSOR SYSTEM
 * 
 * @author Emmanuel Taylor
 * @author Leo Tangban
 * @author Vincent Gruse
 * 
 * @description
 *      This class represents the SesnorSystem publisher class for the Observer Design Pattern.
 *      It notifies all observers when an event occurs.
 * 
 * @packages
 *      Java Utilities (ArrayList)
 */

import java.util.ArrayList;

public class SensorSystem {
    private ArrayList<AlarmListener> listeners = new ArrayList<AlarmListener>();

    /**
     * Function Name: register
     * @param alarmListener (AlarmListener)
     * 
     * Adds an alarmListener to the list of listeners.
     */
    public void register(AlarmListener alarmListener) {
        listeners.add(alarmListener);
    }

    /**
     * Function Name: soundTheAlarm
     * 
     * Loops through the list of listeners and notifies each.
     */
    public void soundTheAlarm() {
        for (AlarmListener listener : listeners) {
            listener.alarm();
        }
    }
}
