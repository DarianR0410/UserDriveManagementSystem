/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinalp1.controller;

import com.proyectofinalp1.view.menu.AboutUsButton;
import com.proyectofinalp1.view2.AboutUs;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Admin
 */
public class AboutUsController implements ActionListener{

    // Botón "About Us" al que se le asignará el controlador
    private final AboutUsButton aboutButton;
    
    // Instancia de la ventana o panel "AboutUs" que se mostrará cuando se haga clic en el botón
    private final AboutUs about = new AboutUs();
    
    // Constructor que recibe el botón y lo asigna al atributo de la clase
    public AboutUsController(AboutUsButton aboutButton) {
        this.aboutButton = aboutButton;
    }
    
    // Método que se ejecuta cuando se detecta un evento de acción (clic en el botón)
    @Override
    public void actionPerformed(ActionEvent e) {
        // Muestra la ventana o panel de "About Us"
        about.setVisible(true);
    }

  
}
