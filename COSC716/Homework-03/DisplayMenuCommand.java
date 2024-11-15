/**
 * DISPLAY MENU COMMAND
 * 
 * @author Emmanuel Taylor
 * 
 * @description
 *    This class implements the command to display the final bill with all
 *    applied modifications.
 * 
 * @packages
 *    N/A
 */

public class DisplayMenuCommand implements Command {
    private Menu menu;

    public DisplayMenuCommand(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        for (MenuItem item : menu.getItems()) {
            System.out.println(item.getItemNumber() + ". " + item.getDescription() + " - $" + item.getPrice());
        }
    }
}