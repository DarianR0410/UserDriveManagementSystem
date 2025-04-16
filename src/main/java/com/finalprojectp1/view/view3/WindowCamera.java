/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.finalprojectp1.view.view3;

import javax.swing.JFrame;
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