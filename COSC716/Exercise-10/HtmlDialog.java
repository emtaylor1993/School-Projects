/**
 * HTML DIALOG
 * 
 * @author Emmanuel Taylor
 * 
 * @description
 *      This class is a concrete creator for the Factory Design Pattern.
 *      It extends the base class to create/render HTML-specific buttons.
 * 
 * @packages
 *      None
 */

public class HtmlDialog extends Dialog {
    @Override
    public Button createButton() {
        return new HtmlButton();
    } 
}