/**
 * LIGHTS OFF COMMAND
 * 
 * @author Emmanuel Taylor
 * @author Leo Tangban
 * @author Vincent Gruse
 * 
 * @description
 *      This class represents the command to turn off the Light. It implements
 *      the execute method from the Command interface which turns off the Light.
 * 
 * @packages
 *      None
 */

public class LightsOffCommand implements Command {
    private Light light;

    /**
     * Constructor Name: LightsOffCommand
     * @param light
     * 
     * Generates a LightsOffCommand object.
     */
    public LightsOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
}
