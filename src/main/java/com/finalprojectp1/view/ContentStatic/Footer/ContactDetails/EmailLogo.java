package com.finalprojectp1.view.ContentStatic.Footer.ContactDetails;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Admin
 */
public class EmailLogo extends JButton {

    // Constructor de la clase EmailLogo
    public EmailLogo() {

        // Elimina el borde del botón
        setBorder(null);

        // Hace que el botón sea opaco (no transparente)
        setOpaque(true);

        // Evita que el botón rellene su área de contenido (permite personalizar su apariencia)
        setContentAreaFilled(false);

        // Declaración de un JLabel para mostrar un icono
        JLabel Email;

        // Inicializa el JLabel con una imagen obtenida desde los recursos del proyecto
        Email = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("imgOne/icons8-email-24.png")));

        // Agrega el JLabel (con la imagen) al botón
        add(Email);
    }

}
