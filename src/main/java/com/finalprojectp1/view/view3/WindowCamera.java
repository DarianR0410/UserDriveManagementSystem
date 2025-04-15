/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.finalprojectp1.view.view3;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import java.awt.Dimension;
import javax.swing.JFrame;
import com.finalprojectp1.controller.ScanQRController;
import java.awt.BorderLayout;

/**
 *
 * @author Admin
 */
public class WindowCamera extends JFrame{
    
    public WindowCamera() {

      setTitle("Escáner QR");
      setSize(640, 480);
      setLocationRelativeTo(null); // Centrar
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setLayout(new BorderLayout()); 
        
    }

}