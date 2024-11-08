/**
 * WINDOWS BUTTON
 * 
 * @author Emmanuel Taylor
 * @author Ata Tangban
 * @author Vincent Gruse
 * 
 * @description
 *      This class is a concrete implementation of the Button interface. It
 *      represents buttons designed for Windows GUI applications.
 * 
 * @packages
 *      Java Extension - Swing (JButton, JFrame, JPanel)
 */

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WindowsButton implements Button {

    private JPanel panel;
    private JFrame frame;
    private JButton button;

    public WindowsButton() {
        frame = new JFrame();
        panel = new JPanel();
        button = new JButton("Test Button");

        button.addActionListener(e -> onClick());
        panel.add(button);
        frame.add(panel);
        frame.setSize(200, 200);
    }

    @Override
    public void render() {
        frame.setVisible(true);
    }

    @Override
    public void onClick() {
        System.out.println("Click! Windows Button says - 'Hello World!'");
    }
}