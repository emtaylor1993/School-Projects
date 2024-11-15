/**
 * PRICING DECORATOR
 * 
 * @author Emmanuel Taylor
 * 
 * @description
 *    This abstract class defines the structure for all decorators that can be 
 *    used to modify the tab.
 * 
 * @packages
 *    N/A
 */

public abstract class PricingDecorator {
    protected Tab tab;

    public PricingDecorator(Tab tab) {
        this.tab = tab;
    }

    public abstract String[] generateTab(Orders orders, Menu menu);
}