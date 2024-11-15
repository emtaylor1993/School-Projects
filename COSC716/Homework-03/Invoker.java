/**
 * INVOKER
 * 
 * @author Emmanuel Taylor
 * 
 * @description
 *    This class invokes commands dynamically based on user input.
 * 
 * @packages
 *    N/A
 */

public class Invoker {
    public void executeCommand(Command command) {
        command.execute();
    }
}