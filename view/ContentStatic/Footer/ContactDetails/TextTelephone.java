/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinalp1.view.ContentStatic.Footer.ContactDetails;

import javax.swing.JTextPane;

/**
 *
 * @author Admin
 */
public class TextTelephone extends JTextPane {
    
     // Constructor de la clase TextTelephone
    public TextTelephone() {
    
    // Hace que el campo de texto no sea editable
    setEditable(false);
    
    // Establece el fondo como nulo (transparente)
    setBackground(null);
    
    // Define el tipo de contenido como HTML, permitiendo el uso de etiquetas HTML en el texto
    setContentType("text/html");
    
    // Establece el texto con formato HTML, aplicando estilo de color, tamaño de fuente y familia tipográfica
    setText("<html><p style='color: #000000; font-size: 10px; font-family: Papyrus; line-height: 1.0;'>809-635-0234</p>");
    }

}
