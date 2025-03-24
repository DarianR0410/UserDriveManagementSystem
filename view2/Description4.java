/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinalp1.view2;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JTextPane;

/**
 *
 * @author Admin
 */
public class Description4 extends JPanel {
    
    // Constructor de la clase Description4
    public Description4() {
    
    // Establece el tamaño preferido del panel (525 píxeles de ancho, 200 de alto)
    setPreferredSize(new Dimension(525, 200));
    
    // Configura el fondo del panel en color blanco
    setBackground(Color.WHITE);
    
    // Asegura que el fondo del panel sea opaco
    setOpaque(true);
    
    // Crea un JTextPane para mostrar texto con formato HTML
    JTextPane description = new JTextPane();
    
    // Hace que el JTextPane no sea editable por el usuario
    description.setEditable(false);
    
    // Deshabilita el cursor dentro del JTextPane (evita que el usuario lo seleccione)
    description.setCaret(null);
    
    // Establece el fondo del JTextPane en color blanco
    description.setBackground(Color.WHITE);
    
    // Permite que el JTextPane interprete el contenido como HTML
    description.setContentType("text/html");
    
    // Define el texto con formato HTML para aplicar estilos y estructura
    description.setText("<html>"
                          + "<p style='color: #444444; font-size: 18px;'>Somos un equipo de desarrolladores apasionados</p>"
                          + "<p style='color: #444444; font-size: 18px;'>por la productividad y la tecnología,</p>"
                          + "<p style='color: #444444; font-size: 18px;'>comprometidos con ofrecerte la suficiente</p>"
                          + "<p style='color: #444444; font-size: 18px;'>confianza y la mejor experiencia.</p>"
                          + "</html>");
    
    // Agrega el JTextPane al panel
    add(description);
}

}
