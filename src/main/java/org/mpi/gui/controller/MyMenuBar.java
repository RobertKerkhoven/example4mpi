package org.mpi.gui.controller;


import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class MyMenuBar extends JMenuBar {

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
}


