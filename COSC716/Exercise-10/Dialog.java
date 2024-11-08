/**
 * DIALOG
 * 
 * @author Emmanuel Taylor
 * 
 * @description
 *      This class acts as the creator in the Factory Design Pattern. It will
 *      provide an abstract base for different dialogs.
 * 
 * @packages
 *      None
 */

public abstract class Dialog {
    public void renderWindow() {
        Button okButton = createButton();
        okButton.render();
    }
    
    public abstract Button createButton(); 
}