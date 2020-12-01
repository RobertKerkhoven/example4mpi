package org.mpi.gui.controller.menubar;


import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class MyMenuBar extends JMenuBar implements ActionListener {

    public MyMenuBar(){

        //Creating the MenuBar and adding components
        JMenu m1 = new JMenu("File");
        JMenu m2 = new JMenu("Help");

        JMenuItem m11 = new JMenuItem("Open");
        JMenuItem m22 = new JMenuItem("Save as");
        m1.add(m11);
        m1.add(m22);

        add(m1);
        add(m2);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Invisible")) {
            this.setVisible(false);
        }
        if (e.getActionCommand().equals("Visible")) {
            this.setVisible(true);
        }

    }
}


