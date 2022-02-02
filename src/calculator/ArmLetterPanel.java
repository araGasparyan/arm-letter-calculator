package calculator;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Ara Gasparyan
 */
class ArmLetterPanel extends JPanel {
    public JTextField TF;
 
    // Editor of button clicking
    private ArmLetterBtnAction BtnPressed;

    public ArmLetterBtnAction getBtnPressed() {
        return BtnPressed;
    }

    // List of buttons names
    private static String [] BtnTxt = {
        "Ա","Բ","Գ","Դ","Ե","Զ","Է","Ը","Թ","CL","CN",
            "Ժ","Ի","Լ","Խ","Ծ","Կ","Հ","Ձ","Ղ","+","-",
            "Ճ","Մ","Յ","Ն","Շ","Ո","Չ","Պ","Ջ","*","/",
        "Ռ","Ս","Վ","Տ","Ր","Ց","ՈՒ","Փ","Ք","del","=",
            "0","1","2","3","4","5","6","7","8","9","C"
    };

    public static String[] getBtnTxt() {
        return BtnTxt;
    }

    public ArmLetterPanel(int W, int H) {
        
        // The sizes of buttons and area between them
        int w = W / 13, h = 30, sx = w / 6, sy = 10;
       
        // Turn off Layout manager (components of panel have to be positioned on panel BY-HAND)
        setLayout(null);
       
        // Set position and sizes of panel
        setBounds(0, 0, W, H);
        TF = new JTextField();
        
        // Align text in text field to right
        TF.setHorizontalAlignment(JTextField.RIGHT);
        
        // Position and sizes of field
        TF.setBounds(sx, sy,10 * sx + 11 * w, h);
        
        // Do not edit field
        TF.setEditable(false);

        add(TF);
        
        // Creation of editor of button click
        BtnPressed = new ArmLetterBtnAction(TF);

        for (int i = 0; i < BtnTxt.length; i++) {
            addBtn(sx + (w + sx) * (i % 11),(2 * sy + h) + (sy + h) * (i / 11), w, h, BtnTxt[i], BtnPressed, i);
        }
    }
    
    
    void addBtn(int i, int j, int w, int h, String txt, ActionListener AcList, int k) {
        // Create button
        JButton b = new JButton(txt);

        // Size and position of the button
        b.setBounds(i, j, w, h);
         
        // When the button pressed there is not any selection of the button (when false)
        b.setFocusPainted(false);
         
        // Filling red of C
        if( k == 54) b.setForeground(Color.red);
         
        //Adding an action listener
        b.addActionListener(AcList);

        add(b);
    }
}
