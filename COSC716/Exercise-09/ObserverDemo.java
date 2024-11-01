/**
 * OBSERVER DEMO
 * 
 * @author Emmanuel Taylor
 * @author Leo Tangban
 * @author Vincent Gruse
 * 
 * @description
 *      This class acts as a Client to demonstrate the observer design pattern.
 * 
 * @packages
 *      None
 */

public class ObserverDemo {
    public static void main(String[] args) {
        SensorSystem sensorSystem = new SensorSystem();
        sensorSystem.register(new Gates());
        sensorSystem.register(new Lighting());
        sensorSystem.register(new Surveillance());
        sensorSystem.soundTheAlarm();      
    }
}
