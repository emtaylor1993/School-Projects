/**
 * PRINTER MANAGER CLASS
 * 
 * @author Vincent Gruse
 * @author Ata Tangban
 * @author Emmanuel Taylor
 * 
 * @description
 *      This class contains the implementation of the Singleton
 *      Printer Manager.
 * 
 * @packages
 *      N/A
 */

package Singleton;

public class PrinterManager {
    private static PrinterManager instance;
    private Printer[] printers; 

    /**
     * Constructor Name: PrinterManager()
     * 
     * Private PrinterManager constructor.
     */
    private PrinterManager() {
        printers = new Printer[3];
        printers[0] = new Printer();
        printers[1] = new Printer();
        printers[2] = new Printer();
    }

    /**
     * Function Name: getInstance
     * @return (PrinterManager)
     * 
     * This function is the public static accessor for the
     * PrinterManager instance.
     */
    public static PrinterManager getInstance() {
        if (instance == null) {
            synchronized (PrinterManager.class) {
                if (instance == null) {
                    instance = new PrinterManager();
                }
            }
        }

        return instance;
    }

    /**
     * Function Name: assignJob
     * @param job (String)
     * 
     * Assigns jobs to printers if they are available.
     */
    public void assignJob(String job) {
        for (Printer printer : printers) {
            if (!printer.isBusy()) {
                printer.setBusy(true);
                printer.setPrintJob(job);
                System.out.println("Job \"" + job + "\" assigned to printer.");
                return;
            }
        }
        System.out.println("No available printers to assign the job: \"" + job + "\".");
    }

    /**
     * Function Name: showStatus
     * 
     * Prints the status of each printer.
     */
    public void showStatus() {
        System.out.println("Printer Status: ");
        for (int i = 0; i < printers.length; i++) {
            Printer printer = printers[i];
            System.out.println("\tPrinter " + (i + 1) + " is " + (printer.isBusy() ? "busy" : "available") + " with job: \"" + printer.getPrintJob() + "\".");
        }
    }

    /**
     * Function Name: resetPrinters
     * 
     * Resets the status of each printer.
     */
    public void resetPrinters() {
        for (Printer printer : printers) {
            printer.setBusy(false);
            printer.setPrintJob("");
        }
        System.out.println("All printers have been reset to available state.");
    }
}
