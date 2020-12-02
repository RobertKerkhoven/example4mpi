package org.mpi.gui.controller.content;

import chrriis.dj.nativeswing.common.UIUtils;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

@Component
public class VideoContent extends JPanel implements ActionListener {

    private JWebBrowser webBrowser;

    VideoContent() {
        NativeInterface.open();
        UIUtils.setPreferredLookAndFeel();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
//                JFrame frame = new JFrame("YouTube Viewer");
//                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//                frame.getContentPane().add(createContent_1(), BorderLayout.CENTER);
//                frame.setSize(400, 300);
//                frame.setLocationByPlatform(true);
//                frame.setVisible(true);

                //add(createContent());
                add(createContent_1());
            }
        });
        NativeInterface.runEventPump();
        // don't forget to properly close native components
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                NativeInterface.close();
            }
        }));
    }


    public  JComponent createContent_1() {
        JPanel contentPane = new JPanel(new BorderLayout());
        JPanel webBrowserPanel = new JPanel(new BorderLayout());
        webBrowserPanel.setBorder(BorderFactory.createTitledBorder("Native Web Browser component"));
         webBrowser = new JWebBrowser();
        this.webBrowser.navigate("https://youtu.be/hjeSOxi3uPg"); //Magic
        webBrowserPanel.add(webBrowser, BorderLayout.CENTER);
        webBrowserPanel.setPreferredSize(new Dimension(800,600));
        contentPane.add(webBrowserPanel, BorderLayout.CENTER);
        // Create an additional bar allowing to show/hide the menu bar of the web browser.
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 4, 4));
        JCheckBox menuBarCheckBox = new JCheckBox("Menu Bar", webBrowser.isMenuBarVisible());
        menuBarCheckBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                webBrowser.setMenuBarVisible(e.getStateChange() == ItemEvent.SELECTED);
            }
        });
        buttonPanel.add(menuBarCheckBox);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        return contentPane;
    }

    public  JPanel createContent_2() {
        JPanel contentPane = new JPanel(new BorderLayout());
        JPanel webBrowserPanel = new JPanel(new BorderLayout());
        webBrowserPanel.setPreferredSize(new Dimension(800,600));
        this.setWebBrowser(new JWebBrowser());
        webBrowserPanel.add(getWebBrowser(), BorderLayout.CENTER);
        this.getWebBrowser().setBarsVisible(false);
        this.getWebBrowser().navigate("https://youtu.be/hjeSOxi3uPg");
        contentPane.add(webBrowserPanel, BorderLayout.CENTER);
        return contentPane;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Magic

        if (e.getActionCommand().equals("Youtube")) {
            //goto google
            this.getWebBrowser().navigate("https://youtu.be/hjeSOxi3uPg");
        }
        if (e.getActionCommand().equals("Google")) {
            //goto google
            this.getWebBrowser().navigate("https://www.google.com");
        }
        if (e.getActionCommand().equals("Nu")) {
            //goto google
            this.getWebBrowser().navigate("https://www.nu.nl");
        }

    }

    public JWebBrowser getWebBrowser() {
        return webBrowser;
    }

    public void setWebBrowser(JWebBrowser webBrowser) {
        this.webBrowser = webBrowser;
    }
}
