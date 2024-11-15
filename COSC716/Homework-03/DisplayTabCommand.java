/**
 * DISPLAY TAB COMMAND
 * 
 * @author Emmanuel Taylor
 * 
 * @description
 *    This class is a command in the Command Pattern that will process the
 *    current tab, chains a decorator and displays the final tab will all
 *    modifications applied.
 * 
 * @packages
 *    N/A
 */

public class DisplayTabCommand implements Command {
    private Orders orders;
    private Menu menu;

    public DisplayTabCommand(Orders orders, Menu menu) {
        this.orders = orders;
        this.menu = menu;
    }

    @Override
    public void execute() {
        Tab tab = new Tab();
        // Apply a $5 service charge as an example
        PricingDecorator serviceChargeDecorator = new ServiceChargeDecorator(tab, 5);

        String[] tabDetails = serviceChargeDecorator.generateTab(orders, menu);
        for (String detail : tabDetails) {
            System.out.println(detail);
        }
    }
}