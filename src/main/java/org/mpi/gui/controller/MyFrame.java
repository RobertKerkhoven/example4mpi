package org.mpi.gui.controller;

import org.mpi.gui.controller.content.MyContent;
import org.mpi.gui.controller.content.VideoContent;
import org.mpi.gui.controller.leftsidebar.LeftSideMenuPanel;
import org.mpi.gui.controller.menubar.MyMenuBar;
import org.mpi.util.Multiply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


@Controller
public class MyFrame extends JFrame implements ActionListener {

    @Autowired
    MyContent myContent;

    @Autowired
    MyMenuBar myMenuBar;

    @Autowired
    LeftSideMenuPanel leftSideMenuPanel;

    @Autowired
    VideoContent videoContent;

    public JButton testButton = new JButton("test button");
    public JDialog dialog;

    public MyFrame() {
        setTitle("Test GUI");
        setLayout(new BorderLayout());

    }

    @PostConstruct
    public void init() {
        // setup panels and tabs, including myGui.generate()
        createAndShowGUI();

        createDialog();

        setJMenuBar(myMenuBar);

        setLocationRelativeTo(null);
        setVisible(true);
        pack();

    }

    private void createDialog() {

        dialog = new JDialog();
        JLabel label = new JLabel("Please wait for calculation..");
        label.setSize(new Dimension(100,100));
        dialog.setLocationRelativeTo(null);
        dialog.setTitle("Please Wait...");
        dialog.add(label);
        JPanel panel = new JPanel();
        JTextField tf = new JTextField(40);
        Multiply m = new Multiply(3,4);
        tf.setText(m.getString());
        panel.add(tf);
        dialog.add(panel);
        dialog.pack();
    }

    public void createAndShowGUI() {


        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(testButton, BorderLayout.NORTH);
        add(new JButton("test1"), BorderLayout.SOUTH);
        add(leftSideMenuPanel, BorderLayout.WEST);


        add(new JButton("test3"), BorderLayout.EAST);
        add(videoContent, BorderLayout.CENTER);


        initActionListeners();

    }

    private void initActionListeners() {

        leftSideMenuPanel.buttonOne.addActionListener(videoContent);
        leftSideMenuPanel.buttonTwo.addActionListener(videoContent);
        leftSideMenuPanel.buttonThree.addActionListener(videoContent);

        leftSideMenuPanel.buttonInvisible.addActionListener(myMenuBar);
        leftSideMenuPanel.buttonVisible.addActionListener(myMenuBar);

        leftSideMenuPanel.buttonRed.addActionListener(this);
        leftSideMenuPanel.buttonBlue.addActionListener(this);

        testButton.addActionListener(this);


    }


    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println(e.getActionCommand());

        if (e.getActionCommand().equals("Red")) {
            testButton.setBackground(Color.RED);

        }

        if (e.getActionCommand().equals("Blue")) {
            testButton.setBackground(Color.BLUE);

        }

        if (e.getActionCommand().equals("test button")) {
            JDialog d = new JDialog();
            dialog.setVisible(true);

        }

    }


}
