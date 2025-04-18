package com.finalprojectp1.view.view3;

import javax.swing.JFrame;
import java.awt.BorderLayout;

/**
 *
 * @author Admin
 */

public class WindowCamera extends JFrame {

    // Constructor de la clase WindowCamera
    public WindowCamera() {

        // Establece el título de la ventana como "Escáner QR"
        setTitle("Escáner QR");
        
        // Define el tamaño de la ventana con 640 píxeles de ancho y 480 de alto
        setSize(640, 480);
        
        // Centra la ventana en la pantalla
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        
        // Define la acción de cierre de la ventana: la ventana se cierra, pero la aplicación sigue en ejecución si hay otras ventanas abiertas
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // Establece un layout BorderLayout para la ventana, lo que permite organizar los componentes en cinco áreas (Norte, Sur, Este, Oeste, Centro)
        setLayout(new BorderLayout());

    }

}
