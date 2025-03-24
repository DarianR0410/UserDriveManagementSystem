/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinalp1.view.ContentStatic.Footer.ContactDetails;


import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Admin
 */
public class ContactDetailsPanel extends JPanel{
    
    public ContactDetailsPanel(){
    
       // Dimensiones del panel
       setPreferredSize(new Dimension(800, 100));
       // Panel sin fondo
       setBackground(null);
       // Manager Layout del panel
       setLayout(new MigLayout("insets 25 0 0 0"));
       
       // Instancia de la clase del logo
       LocationLogo location = new LocationLogo();
       //Agregando la instancia y aplicandole un margen a la izquierda
        add(location, "gapleft 150");
        
       // Instancia del texto del logo  
       TextLocation textLocation = new TextLocation();
       // Agregando el texto y dandole un margen en la parte baja
        add(textLocation, "gapbottom 12");
        
       // Instancia de la clase del logo del telefono 
       TelephoneLogo telephone = new TelephoneLogo();
       // Agregando la instancia al panel y aplicandole margenes arriba y a la izquierda
        add(telephone, "gaptop 5, gapleft 10");
        
       // Instancia del numero de telefono 
       TextTelephone textTelephone = new TextTelephone();
       // Agregando la instancia
        add(textTelephone);
        
       // Instancia del logo de email     
       EmailLogo email = new EmailLogo();
       // agagrenadolo al panel con margenes arriba y a la izquierda
        add(email, "gaptop 5, gapleft 10");
        
       // Instancia del texto del correo 
       TextEmail textEmail = new TextEmail();
       // Agregando la instancia con un salto de linea
        add(textEmail, "wrap");
        
       // Instancia del separador
        JSeparator separatorHorizontal = new JSeparator(JSeparator.HORIZONTAL);
       // Aplicandole dimensiones al separador 
        separatorHorizontal.setPreferredSize(new Dimension(200, 200));
       // Aplicandole un color al separador
        separatorHorizontal.setForeground(Color.red);
       // Agregando el separador al panel con margen a la izquierda 
       // y expandiendolo por todo el eje horizontal
        add(separatorHorizontal,"gapleft 30, spanx, growx");
        
       
    }
}
