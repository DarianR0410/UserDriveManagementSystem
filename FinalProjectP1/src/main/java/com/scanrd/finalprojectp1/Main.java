package com.scanrd.finalprojectp1;

import com.formdev.flatlaf.FlatLightLaf;
import com.scanrd.finalprojectp1.view.VentanaRegistro;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * @author Isaac M
 */
public class Main {

    public static void main(String[] args) {
        // Aplicando look and feel 
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
            // Redondeando al maximo todos los bordes de los componentes de texto
            UIManager.put("TextComponent.arc", 999);
            // Subiendo el color del borde de enfoque a los textfields 
            UIManager.put("Component.focusWidth", 2);
        } catch (UnsupportedLookAndFeelException ex) {
            System.err.println("No se pudo aplicar FlatLaf.");
        }

        // Llamando al jframe
        VentanaRegistro ventana = new VentanaRegistro();
        ventana.setVisible(true);

        System.out.println("Hello");
    }
}
