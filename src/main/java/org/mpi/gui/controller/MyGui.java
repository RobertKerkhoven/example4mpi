package org.mpi.gui.controller;

import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

@Component
public class MyGui extends JPanel  {
    private JPanel panel = new JPanel(new GridBagLayout());

    public MyGui() {

        setLayout(new GridLayout(1, 2));
        add(createLeftPane());
        add(createRightPane());

    }

    protected JPanel createLeftPane() {

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.setBackground(Color.RED);

        JPanel content = new JPanel(new GridBagLayout());
        content.setOpaque(false);

        JPanel view3D = new JPanel();
        view3D.setBackground(Color.DARK_GRAY);
        JPanel view2D = new JPanel();
        view2D.setBackground(Color.PINK);
        JPanel viewIsometric = new JPanel();
        viewIsometric.setBackground(Color.YELLOW);
        JPanel viewData = new JPanel();
        viewData.setBackground(Color.MAGENTA);

        JPanel top = new JPanel(new GridLayout(0, 2));
        top.setBorder(new LineBorder(Color.GREEN, 2));
        top.add(view3D);
        top.add(view2D);

        JPanel bottom = new JPanel(new GridLayout(2, 0));
        bottom.add(viewIsometric);
        bottom.add(new JScrollPane(viewData));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weighty = 0.5f;
        gbc.weightx = 1f;
        gbc.fill = GridBagConstraints.BOTH;

        content.add(top, gbc);
        content.add(bottom, gbc);

        panel.add(content);
        panel.add(new JLabel("Character name"), BorderLayout.NORTH);

        return  panel;

    }

    protected JPanel createRightPane() {

        JPanel panel = new JPanel();
        panel.setBackground(Color.BLUE);

        return panel;

    }

    public JPanel generate() {



        panel.add(new Button("test"));
        return panel;
    }


}
