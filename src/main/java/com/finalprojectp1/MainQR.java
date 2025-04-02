package com.finalprojectp1;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.SwingUtilities;
import com.finalprojectp1.view.FramePrincipal;
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
            // Redondeando al maximo todos los bordes de los componentes de texto
            UIManager.put("TextComponent.arc", 999);
            // Subiendo el color del borde de enfoque a los textfields 
            UIManager.put("Component.focusWidth", 2);
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
