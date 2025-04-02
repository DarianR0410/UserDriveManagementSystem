package com.finalprojectp1.view.ContentStatic.Footer;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JTextPane;

/**
 *
 * @author Admin
 */
public class NavigationPanel extends JPanel {

    public NavigationPanel() {

        setPreferredSize(new Dimension(100, 200));
        //setBorder(new LineBorder(Color.BLUE, 4, true));
        setBackground(null);

        JTextPane text = new JTextPane();
        text.setBackground(null);
        text.setEditable(false);
        text.setContentType("text/html");

        text.setText("<html>"
                + "<body>"
                + "<p style='text-align: center; color: #000000; font-size: 10px; margin-bottom: 0.1px; font-family: Impact'>Navigation</p>"
                + "<p style='color: #444444; font-size: 10px; margin-bottom: 0.1px;'>Home</p>"
                + "<p style='color: #444444; font-size: 10px; margin-bottom: 0.1px;'>About us</p>"
                + "<p style='color: #444444; font-size: 10px; margin-bottom: 0.1px;'>Contact us</p>"
                + "<p style='color: #444444; font-size: 10px; margin-bottom: 0.1px;'>History </p>"
                + "</body>"
                + "</html>");

        add(text);

    }
}
