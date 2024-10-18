/**
 * LIGHTS ON COMMAND
 * 
 * @author Emmanuel Taylor
 * @author Leo Tangban
 * @author Vincent Gruse
 * 
 * @description
 *      This class represents the command to turn on the Light. It implements
 *      the execute method from the Command interface which turns on the Light.
 * 
 * @packages
 *      None
 */

public class LightsOnCommand implements Command {
    private Light light;

    /**
     * Constructor Name: LightsOnCommand
     * @param light
     * 
     * Generates a LightsOnCommand object.
     */
    public LightsOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
