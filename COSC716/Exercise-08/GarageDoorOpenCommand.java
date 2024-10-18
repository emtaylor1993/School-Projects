/**
 * GARAGE DOOR OPEN COMMAND
 * 
 * @author Emmanuel Taylor
 * @author Leo Tangban
 * @author Vincent Gruse
 * 
 * @description
 *      This class represents the command to open the GarageDoor. It implements
 *      the execute method from the Command interface which opens the GarageDoor.
 * 
 * @packages
 *      None
 */

public class GarageDoorOpenCommand implements Command {
    private GarageDoor garageDoor;

    /**
     * Constructor Name: GarageDoorOpenCommand
     * @param garageDoor (GarageDoor)
     * 
     * Generates a GarageDoorOpenCommand object.
     */
    public GarageDoorOpenCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.open();
    }
}
