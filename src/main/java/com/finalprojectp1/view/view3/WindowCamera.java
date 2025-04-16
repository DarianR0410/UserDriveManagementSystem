package com.finalprojectp1.view.view3;

import javax.swing.JFrame;
import java.awt.BorderLayout;

/**
 *
 * @author Admin
 */
public class WindowCamera extends JFrame {

    public WindowCamera() {

        setTitle("Escáner QR");
        setSize(640, 480);
        setLocationRelativeTo(null); // Centrar
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

    }

}
