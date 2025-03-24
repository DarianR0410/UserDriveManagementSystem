/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.proyectofinalp1.SoftwareQR;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.SwingUtilities;
import view.FramePrincipal; 
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.proyectofinalp1.view2.AboutUs;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
/**
 *
 * @author Admin
 */
public class MainQR {

   public static void main(String[] args) {
    
    try {
        // Establece el tema "FlatLightLaf" para la interfaz gráfica
        UIManager.setLookAndFeel(new FlatLightLaf());
    } catch (UnsupportedLookAndFeelException ex) {
        // Si ocurre un error al aplicar el tema, muestra un mensaje en la consola
        System.err.println("Error al inicializar FlatLaf");
    }

    // Asegura que la creación de la interfaz gráfica ocurra en el hilo de eventos de Swing
    SwingUtilities.invokeLater(() -> {
        // Crea y muestra la ventana principal de la aplicación
        new FramePrincipal().setVisible(true);
    });
}

}
