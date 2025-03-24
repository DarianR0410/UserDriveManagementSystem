/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinalp1.view.ContentStatic.Footer.ContactDetails;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Admin
 */
public class LocationLogo extends JButton{
    
    // Constructor de la clase LocationLogo
    public LocationLogo() {
    
    // Elimina el borde del botón
    setBorder(null);
    
    // Hace que el botón sea opaco (no transparente)
    setOpaque(true);
    
    // Evita que el botón rellene su área de contenido (permite personalizar su apariencia)
    setContentAreaFilled(false);

    // Declaración de un JLabel para mostrar un icono
    JLabel logo;
    
    // Inicializa el JLabel con una imagen obtenida desde los recursos del proyecto
    logo = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("resources/icons8-location-24.png")));
    
    // Agrega el JLabel (con la imagen) al botón
    add(logo);
    }

}
