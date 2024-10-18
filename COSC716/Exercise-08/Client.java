/**
 * CLIENT
 * 
 * @author Emmanuel Taylor
 * @author Leo Tangban
 * @author Vincent Gruse
 * 
 * @description
 *      This class represents a Client to create instances of the Receiver classes
 *      (Light, GarageDoor), creating instances of their commands, and using the
 *      invoker class (RemoteControl) to trigger these commands.
 * 
 * @packages
 *      None
 */

public class Client {
    public static void main(String[] args) {
        // Create an instance of the invoker.
        RemoteControl remoteControl = new RemoteControl();

        // Create instances of the receiver classes.
        Light light = new Light();
        GarageDoor garageDoor = new GarageDoor();

        // Create instances of receiver commands.
        Command lightsOn = new LightsOnCommand(light);
        Command lightsOff = new LightsOffCommand(light);
        Command garageDoorOpen = new GarageDoorOpenCommand(garageDoor);
        Command garageDoorClose = new GarageDoorCloseCommand(garageDoor);

        // Turn the light ON.
        remoteControl.setCommand(lightsOn);
        remoteControl.pressButton();

        // Turn the light OFF.
        remoteControl.setCommand(lightsOff);
        remoteControl.pressButton();

        // Open the GarageDoor.
        remoteControl.setCommand(garageDoorOpen);
        remoteControl.pressButton();

        // Close the GarageDoor.
        remoteControl.setCommand(garageDoorClose);
        remoteControl.pressButton();
    }
}
