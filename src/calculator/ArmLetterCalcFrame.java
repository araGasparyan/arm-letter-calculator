package calculator;

import javax.swing.*;

/**
 * @author Ara Gasparyan
 */
public class ArmLetterCalcFrame extends JFrame {

    public ArmLetterCalcFrame() {
            // Frame size
            int w = 732, h = 300;

            // Title of the Frame
            setTitle("Armenian Letter Calculator");

            // Creation of a panel with buttons
            ArmLetterPanel panel = new ArmLetterPanel(w, h);
            add(panel);

            // Sizes and position of Frame
            setBounds(100, 100, w, h);

            // Do not change the sizes of the Frame
            setResizable(false);

            // To make visible the Frame
            setVisible(true);

            // Close the frame by clicking on close button
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
