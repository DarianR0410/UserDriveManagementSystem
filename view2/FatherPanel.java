/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinalp1.view2;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Admin
 */
public class FatherPanel extends JPanel{
    
    // Constructor de la clase FatherPanel
    public FatherPanel() {
    
    // Configura el fondo del panel en color blanco
    setBackground(Color.WHITE);
    
    // Establece un borde negro con grosor de 4 píxeles y bordes redondeados
    setBorder(new LineBorder(Color.BLACK, 4, true));
    
    // Usa MigLayout para organizar los elementos dentro del panel
    setLayout(new MigLayout());

    // Crea y agrega un título al panel, con "wrap" para que salte a la siguiente línea
    Title title = new Title();
    add(title, "wrap");

    // Crea y agrega la primera descripción con margen a la izquierda
    Description description = new Description();
    add(description, "gapleft 60");

    // Crea y agrega la segunda descripción, asegurando que esté en una nueva línea
    Descripction2 descripction2 = new Descripction2();
    add(descripction2, "wrap");

    // Crea y agrega la tercera descripción con margen a la izquierda
    Description3 description3 = new Description3();
    add(description3, "gapleft 60");

    // Crea y agrega la cuarta descripción con un pequeño margen a la derecha
    Description4 description4 = new Description4();
    add(description4, "gapright 10");
}

}
