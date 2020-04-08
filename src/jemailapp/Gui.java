/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jemailapp;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author simon
 */
class Gui {

    JFrame frame = new JFrame("E-Mail made in Java");
    JPanel main = new JPanel();
    JButton bSenden = new JButton("Senden");
    JTextField tfBetreff = new JTextField("Betreff"), tfAbsender = new JTextField("Absender");
    JTextArea taNachricht = new JTextArea("Nachricht");
    JScrollPane scpNachrichten = new JScrollPane(taNachricht);

    public Gui() {
        setup();
        bSenden.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Absender: " + tfAbsender.getText() + "\nBetreff: " + tfBetreff.getText() + "\nNachricht: " + taNachricht.getText());
                tfBetreff.setText("Betreff");
                taNachricht.setText("Nachricht");
                checkEMailAddressValid(tfAbsender.getText());
            }

            private boolean checkEMailAddressValid(String address) {
                boolean isValid = false;
                String[] parts = address.split("@");
                if (parts.length == 2) {
                    String username = parts[0].toLowerCase(), domain = parts[1].toLowerCase();
                    if (domain.matches("[a-z]+\\.[a-z]+")) {
                        System.out.println(domain);
                        if (username.matches("[a-z,0-9,\\.,!,#,$,%,&,',*,+,-,/,=,?,\\^,_,`,{,|,},~,]+")) { //todo check is correct
                            if (username.matches("[a-z]+")) {
                                System.err.println("Lame username...");
                            } else if (username.matches("[a-z,0-9]+")) {
                                System.err.println("This is more interesting");
                            }
                        }else{
                            System.err.println("Username has wrong format");
                        }
                    } else {
                        System.err.println("Domain has wrong format");
                    }

                } else {
                    System.err.println("The E-Mail-Address has a wrong format");
                }
                System.out.println(Arrays.toString(parts));
                return isValid;
            }
        });
    }

    private void setup() {
        tfBetreff.setMaximumSize(new Dimension(10000, 100));
        tfAbsender.setMaximumSize(new Dimension(10000, 100));
        frame.setMinimumSize(new Dimension(300, 250));
        main.add(tfAbsender);
        main.add(tfBetreff);
        main.add(scpNachrichten);
        main.add(bSenden);

        frame.setVisible(true);
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        frame.add(main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
    }
}
