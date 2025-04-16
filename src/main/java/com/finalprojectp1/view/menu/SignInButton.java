package com.finalprojectp1.view.menu;

import java.awt.Color;
import java.awt.Dimension;
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

       // Dimensiones para el boton
        setPreferredSize(new Dimension(70, 70));
        
       // Anulando el borde del boton
        setBorder(null);
        
        // Opacando el boton para que no se vea su fondo por defecto
        setOpaque(true);
        
        // Quitando el foco de cuando lo clickeen
        setFocusPainted(false);

        // Crea un JLabel para mostrar un icono de registro
        JLabel RegisterLogo;
        RegisterLogo = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("imgOne/icons8-register-30.png")));

        // Agrega el JLabel (con la imagen) al botón
        add(RegisterLogo);
    }

}
