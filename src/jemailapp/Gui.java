/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jemailapp;

import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author simon
 */
class Gui {

    JFrame frame = new JFrame("E-Mail made in Java");
    JPanel main = new JPanel();
    JButton bSenden = new JButton("Senden");
    JTextField tfBetreff = new JTextField("Betreff");

    public Gui() {
        setup();
        tfBetreff.addActionListener((ActionEvent e) -> {
            if(tfBetreff.getText()==""){
                tfBetreff.setText("Betreff");
            }
        });
    }

    private void setup() {
        main.add(tfBetreff);
        main.add(bSenden);

        frame.setVisible(true);
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        frame.add(main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
    }
}
