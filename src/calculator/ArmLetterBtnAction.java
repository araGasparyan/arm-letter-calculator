package calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

/**
 * @author Ara Gasparyan
 */
public class ArmLetterBtnAction implements ActionListener {
    public JTextField TF;
    private String cmnd;
    private int result;
    private boolean nformat;
    private boolean number;
    private boolean command;
    private String str;
 
    public  String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    private void onStart() {
        number = true;
        nformat = true;
        cmnd = "C";
        result = 0;
        TF.setText("0");
        command = false;
    }

    // Method for calculation of the last operation
    private void convertNumber(){
        String stemp = TF.getText();
        TF.setText(NumbFromLetters.NumbConverter(stemp));
    }

    private void convertLetter() {
        String ntemp = TF.getText();
        TF.setText(NumbFromLetters.LettConverter(ntemp));
    }

    // Constructor of BtnAction
    public ArmLetterBtnAction(JTextField TF) {
        this.TF = TF;
        onStart();
    }

    private void del() {
        String temp = TF.getText();
        TF.setText(DeleteCharcater.SetNewString(temp));
    }

    private void calc() {
        try {
            int x;
            x = Integer.parseInt(TF.getText());

            if(cmnd.equals("*")) result *= x;
            else if (cmnd.equals("/")) result /= x;
            else if (cmnd.equals("-")) result -= x;
            else if (cmnd.equals("+")) result += x;
            else result = x;

            TF.setText(Integer.toString(result));
        } catch (Exception e) {
            TF.setText(Massage.Massage4Arm.getText());
        }
    }
      
    void step() {
        if (str.equals("C")) {
            onStart();
            return;
        }
            
        if ((TF.getText().startsWith("-"))) {
            return;
        }  
             
        if ((TF.getText().equals(Massage.Massage2Arm.getText()))
                || (TF.getText().equals(Massage.Massage3Arm.getText()))
                || (TF.getText().equals(Massage.Massage4Arm.getText()))) {

            return;
        }  

        if ((command) && (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"))) {
            return;
        }
                 
        if ((nformat) && (str.equals("+") || str.equals("-")
                || str.equals("*") || str.equals("/") || str.equals("="))) {

            calc();
            cmnd = str;

            if (!str.equals("=")) command=true;

            return;
        }
       
        
        if ((!nformat) && (str.equals("+") || str.equals("-") || str.equals("*")
                || str.equals("/") || str.equals("="))) {

            return;
        }
        
        if ((str.equals("del") && (!command))) {

            if (TF.getText().equals("0")) { return; }
            else if (TF.getText().equals(Massage.Massage1Arm.getText())) { return; }
            else {
                del();
                return;
            }
        }
        
        if ((TF.getText().equals(Massage.Massage1Arm.getText())) && (str.equals("CN"))) {
            TF.setText("0");

            return;
        }

        if ((str.equals("CN") && !nformat)) {
            convertNumber();
            nformat = true;

            return;
        }
     
        if ((str.equals("CN") && nformat)) return;

        if ((str.equals("CL") && nformat)) {
            if (TF.getText().equals("0")) {
                TF.setText(Massage.Massage1Arm.getText());
                return;
            }

            convertLetter();
            nformat=false;

            return;
        }
        
        if ((str.equals("CL") && !nformat)) return;
                
        for (int i=44; i < ArmLetterPanel.getBtnTxt().length-1; i++) {
            if ((str.equals(ArmLetterPanel.getBtnTxt()[i]))) {
                   number = true;
                   break;
            } else {
                number = false;
            }
        }
        
        if ((TF.getText().equals("0")) || (TF.getText().equals(Massage.Massage1Arm.getText()))) {
            TF.setText(str);

            for (int i=44; i<ArmLetterPanel.getBtnTxt().length-1; i++) {
                if ((str.equals(ArmLetterPanel.getBtnTxt()[i]))) {
                   nformat = true;
                   break;
                } else nformat = false;
            }

            command = false;

            return;
        } else if (number && nformat) {
            if (command) {
                TF.setText(str);
                command = false;

                return;
            } else {
                TF.setText(TF.getText() + str);
                command=false;

                return;
            }
        } else if ((!number) && (!nformat)) {
            TF.setText(TF.getText() + str);
            command = false;

            return;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // gives str value of the pressed button
        String str1 = e.getActionCommand();
        str = str1;

        step();
    }
}

  
