/**
 * HTML BUTTON
 * 
 * @author Emmanuel Taylor
 * 
 * @description
 *      This class is an implementation of the Button interface. It represents
 *      a button that can be rendered in HTML format.
 * 
 * @packages
 *      None
 */

public class HtmlButton implements Button {
    @Override
    public void render() {
        System.out.println("<button>Test Button</button>");
    }

    @Override
    public void onClick() {
        System.out.println("Click! Button says - 'Hello World'");
    }
}
