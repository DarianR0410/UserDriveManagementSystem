/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinalp1.view.ContentStatic;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.ImageIcon;


/**
 *
 * @author Admin
 */
public class RedQrPanel extends JPanel{
   
    // Constructor de la clase RedQrPanel
    public RedQrPanel() {
    
    // Establece el tamaño preferido del panel (500 píxeles de ancho, 300 de alto)
    setPreferredSize(new Dimension(500, 300));
    
    // Configura el fondo del panel en color blanco
    setBackground(Color.WHITE);
    
    // Crea un JLabel para mostrar una imagen
    JLabel imagenOne;
    
    // Inicializa el JLabel con un icono cargado desde los recursos del proyecto
    imagenOne = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("resources/QR Design.png")));
    
    // Agrega la imagen al panel
    add(imagenOne);
    }

     
     

}
