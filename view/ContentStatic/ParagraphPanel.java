/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinalp1.view.ContentStatic;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;


/**
 *
 * @author Admin
 */
public class ParagraphPanel extends JPanel{
    
    // Constructor de la clase ParagraphPanel
    public ParagraphPanel() {
    
    // Establece el tamaño preferido del panel (550 píxeles de ancho, 300 de alto)
    setPreferredSize(new Dimension(550, 300));
    
    // Elimina el fondo del panel, haciéndolo transparente
    setBackground(null);
    
    // Crea un JTextPane para mostrar el texto en formato HTML
    JTextPane label = new JTextPane();
    
    // Hace que el JTextPane no sea editable por el usuario
    label.setEditable(false);
    
    // Establece el fondo del JTextPane en color blanco
    label.setBackground(Color.WHITE);
    
    // Permite que el JTextPane interprete el contenido como HTML
    label.setContentType("text/html");
    
    // Establece el texto con formato HTML, aplicando diferentes estilos
    label.setText("<html>"
                    + "<p style='color: #000000; font-size: 32px; font-family: Impact; line-height: 1.0; text-align: center;'>SCAN QR CODE</p>"
                    + "<p style='color: #444444; font-size: 18px;'>1. Crea una cuenta (en caso de que no la tengas).</p>"
                    + "<p style='color: #444444; font-size: 18px;'>2. Introduce tu correo y contraseña.</p>"
                    + "<p style='color: #FF0000; font-size: 18px;'>3. Escanea tu QR, ¡y PUM!</p>"
                    + "<p style='color: #444444; font-size: 18px;'>4. Obtendrás los datos.</p>"
                 + "</html>");
    
    // Agrega el JTextPane al panel
    add(label);
}

}
