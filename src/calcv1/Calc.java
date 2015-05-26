package calcv1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

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
        
        // Telestes
        bAdd=new JButton("+");
        bAdd.addActionListener(new ActionListener(){        // New ActionListener 
            @Override
            public void actionPerformed(ActionEvent e) {    
                tv = Integer.parseInt(results.getText());   // Apothikeuoume prwto arithmo
                results.setText("0");                       // Midenizoume to Textfield
                JButton bAdd=(JButton) e.getSource();       // Pairnoume ton telesti
                bv2=String.valueOf(bAdd.getText());         // Apothikeuoume telesti
            }
        });
        
        bSub=new JButton("-");
        bSub.addActionListener(new ActionListener(){        // New ActionListener 
            @Override
            public void actionPerformed(ActionEvent e) {
                tv = Integer.parseInt(results.getText());   // Apothikeuoume prwto arithmo
                results.setText("0");                       // Midenizoume to Textfield
                JButton bSub=(JButton) e.getSource();       // Pairnoume ton telesti
                bv2=String.valueOf(bSub.getText());         // Apothikeuoume telesti
            }
        });
        
        bMult=new JButton("*");
        bMult.addActionListener(new ActionListener(){       // New ActionListener 
            @Override
            public void actionPerformed(ActionEvent e) {
                tv = Integer.parseInt(results.getText());   // Apothikeuoume prwto arithmo
                results.setText("0");                       // Midenizoume to Textfield
                JButton bMult=(JButton) e.getSource();      // Pairnoume ton telesti
                bv2=String.valueOf(bMult.getText());        // Apothikeuoume telesti
            }
        });
        
        bDiv=new JButton("/");
        bDiv.addActionListener(new ActionListener(){        // New ActionListener 
            @Override
            public void actionPerformed(ActionEvent e) {
                tv = Integer.parseInt(results.getText());   // Apothikeuoume prwto arithmo
                results.setText("0");                       // Midenizoume to Textfield
                JButton bDiv=(JButton) e.getSource();       // Pairnoume ton telesti
                bv2=String.valueOf(bDiv.getText());         // Apothikeuoume telesti
            }
        });
        
        bDec=new JButton("C");
        bDec.addActionListener(new ActionListener(){        // New ActionListener 
            @Override
            public void actionPerformed(ActionEvent e) {
                results.setText("0");                       // Midenizoume to Textfield
                tv = 0;                                     // Midenizoume prwto arithmo
                bv2 = "0";                                  // Midenizoume ton telesti
            }
        });
        
        bEq=new JButton("=");
        bEq.addActionListener(new ActionListener(){             // New ActionListener 
            @Override
            public void actionPerformed(ActionEvent e) {
                int tv2 = Integer.parseInt(results.getText());  // Apothikeuoume deutero arithmo
                if (bv2 == "+") {                               // Telestis +
                    tv += tv2;                                  // Prosthesi
                    results.setText(String.valueOf(tv));        // Emfanisi Apotelesmatos
                } else if (bv2 == "-") {                        // Telestis -
                    tv -= tv2;                                  // Afairesi
                    results.setText(String.valueOf(tv));        // Emfanisi Apotelesmatos
                } else if (bv2 == "*") {                        // Telestis *
                    tv *= tv2;                                  // Pollaplasiasmos
                    results.setText(String.valueOf(tv));        // Emfanisi Apotelesmatos
                } else if (bv2 == "/") {                        // Diairesi
                    if (tv2 == 0) {                             // Elegxos gia 0 ston paranomasti
                        results.setText("Error");               // Emfanisi ERROR 
                    } else {                
                        tv /= tv2;                              // Diairesi
                        results.setText(String.valueOf(tv));    // Emfanisi Apotelesmatos
                    }
                }
            }
        });
        
        // Prosthetoume ta Koumpia
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

    public static void main(String[] args) {                // Main Class
        new Calc().setVisible(true);                        // To kanoume Orato
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String lez=results.getText();                       // Lezanta = Text Field
        int val=Integer.valueOf(lez);                       // Value = Lezanta = Integer Text Field
        JButton b=(JButton) e.getSource();                  // Pairnoume timi apo to JButton
        int bv=Integer.valueOf(b.getText());                // ButtonValue = Akeraios B = timi JButton
        val=val*10+bv;                                      // Kanoume to textfield * 10 kai prosthetoume ton ButtonValue
        lez=String.valueOf(val);                            // Lezanta = String Timi Value
        results.setText(lez);                               // Tupwnoume th Lezanta
    }
    
    private JPanel buttonPanel, calcPanel;                  // ButtonPanel, Calculator Panel
    private JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9; // Buttons Arithmwn
    private JButton bAdd, bSub, bMult, bDiv, bDec, bEq;     // Buttons Telestwn
    private JTextField results;                             // Apotelesmata Text Field
    public String bv2;                                      // Button Value
    public Integer tv;                                      // TextField Value
    
}
