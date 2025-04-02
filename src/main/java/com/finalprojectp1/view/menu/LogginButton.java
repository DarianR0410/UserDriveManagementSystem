package com.finalprojectp1.view.menu;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Admin
 */
public class LogginButton extends JButton {

    public LogginButton() {

        // Dimensiones para el boton
        setPreferredSize(new Dimension(70, 70));
        // Anulando el borde del boton
        setBorder(null);
        // Opacando el boton para que no se vea su fondo por defecto
        setOpaque(true);
        // Quitando el foco de cuando lo clickeen
        setFocusPainted(false);

        // Creando la instancia para setear el icono
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("imgOne/icons8-login-30.png"));
        // Seteando el icono
        setIcon(icon);
    }
}
