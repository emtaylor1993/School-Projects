/**
 * GARAGE DOOR CLOSE COMMAND
 * 
 * @author Emmanuel Taylor
 * @author Leo Tangban
 * @author Vincent Gruse
 * 
 * @description
 *      This class represents the command to close the GarageDoor. It implements
 *      the execute method from the Command interface which closes the GarageDoor.
 * 
 * @packages
 *      None
 */

public class GarageDoorCloseCommand implements Command {
    private GarageDoor garageDoor;

    /**
     * Constructor Name: GarageDoorCloseCommand
     * @param garageDoor (GarageDoor)
     * 
     * Generates a GarageDoorCloseCommand object.
     */
    public GarageDoorCloseCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.close();
    }
}
