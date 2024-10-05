/**
 * CLIENT CLASS
 * 
 * @author Vincent Gruse
 * @author Ata Tangban
 * @author Emmanuel Taylor
 * 
 * @description
 *      This class contains the implementation of the Client class
 *      to test the functionality of the PrinterManager.
 * 
 * @packages
 *      N/A
 */

package Singleton;

public class Client {
	public static void main(String[] args) {
        PrinterManager printerManager = PrinterManager.getInstance();

        // Assign some print jobs
        printerManager.assignJob("Print Document 1");
        printerManager.assignJob("Print Document 2");
        printerManager.assignJob("Print Document 3");

        // Show the status of all printers
        printerManager.showStatus();

        // Attempt to assign another job (should fail if all printers are busy)
        printerManager.assignJob("Print Document 4");

        // Show status again to verify
        printerManager.showStatus();

        // Get another reference to PrinterManager (same instance)
        PrinterManager printerManager2 = PrinterManager.getInstance();

        // Verify that printerManager2 is the same instance as printerManager
        printerManager2.showStatus();  // Should show the same status

        // Reset all printers
        printerManager.resetPrinters();

        // Show status after reset
        printerManager.showStatus();
	}
}