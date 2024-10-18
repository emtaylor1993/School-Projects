/**
 *  REMOTE CONTROL
 * 
 * @author Emmanuel Taylor
 * @author Leo Tangban
 * @author Vincent Gruse
 * 
 * @description
 *      This class represents an invoker. As the invoker, this class is responsible for
 *      triggering the commands of each receiver. It does not know the details of the commands
 *      or receivers but stores a command and calls execute().
 * 
 * @packages
 *      None
 */

public class RemoteControl {
    private Command command;

    /**
     * Function Name: setCommand
     * @param command (Command)
     * 
     * This function simply sets the command that
     * will be executed.
     */
    public void setCommand(Command command) {
        this.command = command;
    }

    /**
     * Function Name: pressButton
     * 
     * Simulates pressing a button to execute the
     * stored command.
     */
    public void pressButton() {
        command.execute();
    }
}
