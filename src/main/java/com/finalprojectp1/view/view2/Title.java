package com.finalprojectp1.view.view2;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JTextPane;

/**
 *
 * @author Admin
 */
public class Title extends JPanel {

    // Constructor de la clase Title
    public Title() {

        // Establece el tamaño preferido del panel (400 píxeles de ancho, 100 de alto)
        setPreferredSize(new Dimension(400, 100));

        // Configura el fondo del panel en color blanco
        setBackground(Color.WHITE);

        // Asegura que el fondo del panel sea opaco
        setOpaque(true);

        // Crea un JTextPane para mostrar el título con formato HTML
        JTextPane label = new JTextPane();

        // Hace que el JTextPane no sea editable por el usuario
        label.setEditable(false);

        // Deshabilita el cursor dentro del JTextPane (evita selección del texto)
        label.setCaret(null);

        // Establece el fondo del JTextPane en color blanco
        label.setBackground(Color.WHITE);

        // Permite que el JTextPane interprete el contenido como HTML
        label.setContentType("text/html");

        // Define el texto con formato HTML para aplicar estilos
        label.setText("<html>"
                + "<p style='color: #000000; font-size: 48px; font-family: Impact; "
                + "line-height: 1.0; text-align: center;'>ABOUT US</p>"
                + "</html>");

        // Agrega el JTextPane al panel
        add(label);
    }

}
