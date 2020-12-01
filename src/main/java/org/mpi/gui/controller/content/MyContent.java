package org.mpi.gui.controller.content;

import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

@Component
public class MyContent extends JPanel  {
    private JPanel panel_1 = new JPanel(new BorderLayout());
    private JPanel panel_2 = new JPanel();

    public MyContent() {

        setLayout(new GridLayout(1, 2));
        //setPreferredSize(new Dimension(600, 600));
        add(createLeftPane());
        add(createRightPane());

    }

    protected JPanel createLeftPane() {

        panel_1.setMinimumSize(new Dimension(100, 600));
        panel_1.setMaximumSize(new Dimension(100, 600));
        panel_1.setPreferredSize(new Dimension(100, 600));
        panel_1.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel_1.setBackground(Color.RED);

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

        panel_1.add(content);
        panel_1.add(new JLabel("Character name"), BorderLayout.NORTH);

        return  panel_1;

    }

    protected JPanel createRightPane() {
        panel_2.setBackground(Color.BLUE);
        return panel_2;
    }
}
