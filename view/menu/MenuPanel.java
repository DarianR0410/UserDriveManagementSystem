/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinalp1.view.menu;

import com.proyectofinalp1.controller.AboutUsController;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Admin
 */
public class MenuPanel extends JPanel {
    
    // Constructor de la clase MenuPanel
    public MenuPanel() {
    
    // Establece el tamaño preferido del panel (100 píxeles de ancho, 50 de alto)
    setPreferredSize(new Dimension(100, 50));
    
    // Configura el fondo del panel como blanco
    setBackground(Color.WHITE);
    
    // Establece el diseño del panel usando MigLayout con márgenes personalizados
    setLayout(new MigLayout("insets 20 20 20 70"));

    // Crea y agrega un botón "Home" con un espacio de 30 píxeles a la derecha
    HomeButton home = new HomeButton();
    add(home, "gapright 30");
    
    // Crea y agrega un botón "Scan QR" con un espacio de 30 píxeles a la derecha
    ScanQRButton scan = new ScanQRButton();
    add(scan, "gapright 30");
    
    // Crea y agrega un botón "Loggin" (posiblemente para iniciar sesión) con espacio a la derecha
    LogginButton contact = new LogginButton();
    add(contact, "gapright 30");
    
    // Crea y agrega un botón "Sign In" (registro de usuario) con espacio a la derecha
    SignInButton register = new SignInButton();
    add(register, "gapright 30");

    // Crea y agrega un botón "About Us" (sobre nosotros)
    AboutUsButton aboutUs = new AboutUsButton();
    add(aboutUs);
    
    // Crea un controlador para el botón "About Us" y lo asigna como ActionListener
    AboutUsController Controller = new AboutUsController(aboutUs);
    aboutUs.addActionListener(Controller);
    }

}
