/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinalp1.view2;

import java.awt.Color;
import javax.swing.JFrame;



/**
 *
 * @author Admin
 */
public class AboutUs extends JFrame{
    
    // Constructor de la clase AboutUs, que extiende de JFrame
    public AboutUs() {
    
    // Establece el título de la ventana
    setTitle("Frame Principal");
    
    // Define el tamaño inicial de la ventana (1000x500 píxeles)
    setSize(1000, 500);
    
    // Establece el color de fondo de la ventana (aunque esto no afectará al JFrame directamente)
    setBackground(Color.WHITE);
    
    // Permite cerrar solo esta ventana sin afectar el resto de la aplicación
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
    // Centra la ventana en la pantalla
    setLocationRelativeTo(null);
    
    // Maximiza la ventana a pantalla completa
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    
    // Crea un panel principal y lo agrega al JFrame
    FatherPanel fatherPanel = new FatherPanel();
    add(fatherPanel);
}

}
