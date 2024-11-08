/**
 * WINDOWS DIALOG
 * 
 * @author Emmanuel Taylor
 * @author Ata Tangban
 * @author Vincent Gruse
 * 
 * @description
 *      This class is a concrete creator for the Factory Design Pattern. It extends
 *      the base class to create/render Windows-specific buttons.
 * 
 * @packages
 *      None
 */

public class WindowsDialog extends Dialog {
    @Override
    public Button createButton() {
      return new WindowsButton();
    } 
  }