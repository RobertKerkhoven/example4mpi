package org.mpi.gui.controller.leftsidebar;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class LeftSideMenuPanel extends JPanel {

    public JRadioButton buttonOne;
    public JRadioButton buttonTwo;
    public JRadioButton buttonThree;

    public JRadioButton buttonInvisible;
    public JRadioButton buttonVisible;

    public JRadioButton buttonRed;
    public JRadioButton buttonBlue;

    LeftSideMenuPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(Box.createVerticalGlue());


        //... Create the buttons.
        buttonOne   = new JRadioButton("Youtube", true);
        buttonTwo    = new JRadioButton("Google");
        buttonThree = new JRadioButton("Nu");

        buttonInvisible = new JRadioButton("Invisible");
        buttonVisible = new JRadioButton("Visible",true);

        buttonRed = new JRadioButton("Red");
        buttonBlue = new JRadioButton("Blue",true);


        //... Create a button group and add the buttons.
        ButtonGroup bgroup = new ButtonGroup();
        ButtonGroup bgroupMenu = new ButtonGroup();
        ButtonGroup bgroupColor = new ButtonGroup();

        bgroup.add(buttonOne);
        bgroup.add(buttonTwo);
        bgroup.add(buttonThree);

        bgroupMenu.add(buttonInvisible);
        bgroupMenu.add(buttonVisible);

        bgroupColor.add(buttonRed);
        bgroupColor.add(buttonBlue);

        //... Arrange buttons vertically in a panel
        JPanel radioPanelUrls = new JPanel();

        radioPanelUrls.setLayout(new GridLayout(3, 1));
        radioPanelUrls.add(buttonOne);
        radioPanelUrls.add(buttonTwo);
        radioPanelUrls.add(buttonThree);

        JPanel radioPanelMenu = new JPanel();

        radioPanelMenu.setLayout(new GridLayout(2, 1));
        radioPanelMenu.add(buttonInvisible);
        radioPanelMenu.add(buttonVisible);

        JPanel radioPanelColor = new JPanel();

        radioPanelColor.setLayout(new GridLayout(2, 1));
        radioPanelColor.add(buttonRed);
        radioPanelColor.add(buttonBlue);


        //... Add a titled border to the button panel.
        radioPanelUrls.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Choose Url:"));

        radioPanelMenu.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Menu:"));

        radioPanelColor.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Color:"));



        //... Set window attributes.
        add(radioPanelUrls);  // Button panel is only content.
        add(radioPanelMenu);
        add(radioPanelColor);
    }


}
