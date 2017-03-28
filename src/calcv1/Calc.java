package calcv1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class Calc extends JFrame implements ActionListener{

    public Calc() {
        initComponents();
    }

    private void initComponents() {
        calcPanel = new JPanel(new BorderLayout());
        buttonPanel = new JPanel(new GridLayout(4, 4));
        results = new JTextField("0");
        calcPanel.add(buttonPanel);
        calcPanel.add(results, BorderLayout.NORTH);
        add(calcPanel);

        // Buttons
        b0 = new JButton("0");
        b0.addActionListener(this);
        b1 = new JButton("1");
        b1.addActionListener(this);
        b2 = new JButton("2");
        b2.addActionListener(this);
        b3 = new JButton("3");
        b3.addActionListener(this);
        b4 = new JButton("4");
        b4.addActionListener(this);
        b5 = new JButton("5");
        b5.addActionListener(this);
        b6 = new JButton("6");
        b6.addActionListener(this);
        b7 = new JButton("7");
        b7.addActionListener(this);
        b8 = new JButton("8");
        b8.addActionListener(this);
        b9 = new JButton("9");
        b9.addActionListener(this);
        
        // Operator
        bAdd=new JButton("+");
        bAdd.addActionListener(new ActionListener(){        // New ActionListener 
            @Override
            public void actionPerformed(ActionEvent e) {    
                tv = Integer.parseInt(results.getText());   // Save first number
                results.setText("0");                       // Clear TextField
                JButton bAdd=(JButton) e.getSource();       // Take Operator
                bv2=String.valueOf(bAdd.getText());         // Save Operator
            }
        });
        
        bSub=new JButton("-");
        bSub.addActionListener(new ActionListener(){        // New ActionListener 
            @Override
            public void actionPerformed(ActionEvent e) {
                tv = Integer.parseInt(results.getText());   // Save first number
                results.setText("0");                       // Clear TextField
                JButton bSub=(JButton) e.getSource();       // Take Operator
                bv2=String.valueOf(bSub.getText());         // Save Operator
            }
        });
        
        bMult=new JButton("*");
        bMult.addActionListener(new ActionListener(){       // New ActionListener 
            @Override
            public void actionPerformed(ActionEvent e) {
                tv = Integer.parseInt(results.getText());   // Save first number
                results.setText("0");                       // Clear Textfield
                JButton bMult=(JButton) e.getSource();      // Take Operator
                bv2=String.valueOf(bMult.getText());        // Save Operator
            }
        });
        
        bDiv=new JButton("/");
        bDiv.addActionListener(new ActionListener(){        // New ActionListener 
            @Override
            public void actionPerformed(ActionEvent e) {
                tv = Integer.parseInt(results.getText());   // Save first number
                results.setText("0");                       // Clear Textfield
                JButton bDiv=(JButton) e.getSource();       // Take Operator
                bv2=String.valueOf(bDiv.getText());         // Save Operator
            }
        });
        
        bDec=new JButton("C");
        bDec.addActionListener(new ActionListener(){        // New ActionListener 
            @Override
            public void actionPerformed(ActionEvent e) {
                results.setText("0");                       // Clear Textfield
                tv = 0;                                     // Clear First Number
                bv2 = "0";                                  // Clear Operator
            }
        });
        
        bEq=new JButton("=");
        bEq.addActionListener(new ActionListener(){             // New ActionListener 
            @Override
            public void actionPerformed(ActionEvent e) {
                int tv2 = Integer.parseInt(results.getText());  // Save Second Number
                if (bv2 == "+") {                               // Operator +
                    tv += tv2;                                  // Sum
                    results.setText(String.valueOf(tv));        // Show result
                } else if (bv2 == "-") {                        // Operator -
                    tv -= tv2;                                  // Substraction
                    results.setText(String.valueOf(tv));        // Show Result
                } else if (bv2 == "*") {                        // Operator *
                    tv *= tv2;                                  // Multiply
                    results.setText(String.valueOf(tv));        // Show Result
                } else if (bv2 == "/") {                        // Division
                    if (tv2 == 0) {                             // Check for 0
                        results.setText("Error");               // Show ERROR 
                    } else {                
                        tv /= tv2;                              // Division
                        results.setText(String.valueOf(tv));    // Show result
                    }
                }
            }
        });
        
        buttonPanel.add(b7);
        buttonPanel.add(b8);
        buttonPanel.add(b9);
        buttonPanel.add(bAdd);
        buttonPanel.add(b4);
        buttonPanel.add(b5);        
        buttonPanel.add(b6);
        buttonPanel.add(bSub);        
        buttonPanel.add(b1);
        buttonPanel.add(b2);        
        buttonPanel.add(b3);
        buttonPanel.add(bMult); 
        buttonPanel.add(b0);
        buttonPanel.add(bDec);        
        buttonPanel.add(bEq);
        buttonPanel.add(bDiv);    
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    public static void main(String[] args) {
        new Calc().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String lez=results.getText();                       // Lezanta = Text Field
        int val=Integer.valueOf(lez);                       // Value = Lezanta = Integer Text Field
        JButton b=(JButton) e.getSource();                  // Take number from JButton
        int bv=Integer.valueOf(b.getText());                // ButtonValue = Integer B = Value JButton
        val=val*10+bv;                                      // textfield * 10 + ButtonValue
        lez=String.valueOf(val);                            // Lezanta = String Value
        results.setText(lez);                               // Print Lezanta
    }
    
    private JPanel buttonPanel, calcPanel;                  // ButtonPanel, Calculator Panel
    private JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9; // Buttons Numbers
    private JButton bAdd, bSub, bMult, bDiv, bDec, bEq;     // Buttons Operators
    private JTextField results;                             // Results Text Field
    public String bv2;                                      // Button Value
    public Integer tv;                                      // TextField Value
    
}
