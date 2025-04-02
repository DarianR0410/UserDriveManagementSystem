package com.finalprojectp1.view.menu;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Admin
 */
public class SignInButton extends JButton {

    // Constructor de la clase SignInButton
    public SignInButton() {

        // Elimina el borde del botón
        setBorder(null);

        // Establece el color del texto en un tono gris oscuro (RGB: 96, 96, 96)
        setForeground(new Color(96, 96, 96));

        // Establece el fondo como nulo (transparente)
        setBackground(null);

        // Evita que el botón rellene su área de contenido (permite personalizar su apariencia)
        setContentAreaFilled(false);

        // Crea un JLabel para mostrar un icono de registro
        JLabel RegisterLogo;
        RegisterLogo = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("imgOne/icons8-register-30.png")));

        // Agrega el JLabel (con la imagen) al botón
        add(RegisterLogo);
    }

}
