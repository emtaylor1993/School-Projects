/**
 * SERVICE CHARGE DECORATOR
 * 
 * @author Emmanuel Taylor
 * 
 * @description
 *    This class is a concrete decorate that adds a fixed service charge 
 *    to the tab.
 * 
 * @packages
 *    N/A
 */

public class ServiceChargeDecorator extends PricingDecorator {
    private double serviceCharge;

    public ServiceChargeDecorator(Tab tab, double serviceCharge) {
        super(tab);
        this.serviceCharge = serviceCharge;
    }

    @Override
    public String[] generateTab(Orders orders, Menu menu) {
        String[] originalTab = tab.generateTab(orders, menu);
        double total = Double.parseDouble(originalTab[originalTab.length - 1].split("\\$")[1]);
        double finalTotal = total + serviceCharge;

        String[] newTab = new String[originalTab.length];
        System.arraycopy(originalTab, 0, newTab, 0, originalTab.length - 1);
        newTab[originalTab.length - 1] = "Total after adding service charge of $" + serviceCharge + ": $" + String.format("%.2f", finalTotal);
        return newTab;
    }
}