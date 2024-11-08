/**
 * CLIENT
 * 
 * @author Emmanuel Taylor
 * 
 * @description
 *      This class is responsible for configuring and running the application
 *      which will determine which Dialog to use, based on the OS of the 
 *      machine.
 * 
 * @packages
 *      None
 */

public class Client {
    private static Dialog dialog;
    
    public static void main(String[] args) {
        configure();
        run(); 
    }
    
    /**
     * The concrete factory is usually chosen depending on configuration or
     * environment options.
     */
    static void configure() {
        // Check the operating system and assign the appropriate dialog type.
        if (System.getProperty("os.name").equals("Windows 11")) {
            dialog = new WindowsDialog();  
        } else {
            dialog = new HtmlDialog();  
        }
    }
    
    /**
     * All of the client code should work with factories and products through
     * abstract interfaces. This way it does not care which factory it works
     * with and what kind of product it returns.
     */
    static void run() {
        dialog.renderWindow();  
    }
}