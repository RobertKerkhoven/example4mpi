package org.mpi.gui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

@Controller
public class MyFrame extends JFrame {

    @Autowired
    MyGui myGui;


    JLabel label;

    @PostConstruct
    public void init() {
        // setup panels and tabs, including myGui.generate()
        createAndShowGUI();
        //pack();
    }

    public void createAndShowGUI() {


        var quitButton = new JButton("Quit");

        quitButton.addActionListener((ActionEvent event) -> {
            System.exit(0);
        });

//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        try {
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (UnsupportedLookAndFeelException e) {
//            e.printStackTrace();
//        }
        setTitle("Test GUI");

        setLayout(new BorderLayout());
        add(myGui);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

//        createLayout(quitButton);
//        createLayout(myGui.generate());



//        setSize(300, 200);
//        setLocationRelativeTo(null);



    }

    private void createLayout(JComponent... arg) {

        var pane = getContentPane();
        var gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
        );
    }


    private static void placeComponents(JPanel panel) {

        /* We don’t introduce much in the layout part
         * Set the layout here to null
         */
        panel.setLayout(null);

        // Create JLabel
        JLabel userLabel = new JLabel("User:");
        /* This method defines the location of the component.
         * setBounds(x, y, width, height)
         * x and y specify the new position of the upper left corner, and the new size is specified by width and height.
         */
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        /*
         * Create text fields for user input
         */
        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        // Enter the text field of the password
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        /*
         *This is similar to the text field used for input
         * However, the entered information will be replaced by dots for security including passwords
         */
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        // Create login button
        JButton loginButton = new JButton("login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);
    }


//    private void initUI() {
//
//        var quitButton = new JButton("Quit");
//
//        quitButton.addActionListener((ActionEvent event) -> {
//            System.exit(0);
//        });
//
//        createLayout(quitButton);
//
//        setTitle("Quit button");
//        setSize(300, 200);
//        setLocationRelativeTo(null);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//    }
//
//    private void createLayout(JComponent... arg) {
//
//        var pane = getContentPane();
//        var gl = new GroupLayout(pane);
//        pane.setLayout(gl);
//
//        gl.setAutoCreateContainerGaps(true);
//
//        gl.setHorizontalGroup(gl.createSequentialGroup()
//                .addComponent(arg[0])
//        );
//
//        gl.setVerticalGroup(gl.createSequentialGroup()
//                .addComponent(arg[0])
//        );
//    }
}
