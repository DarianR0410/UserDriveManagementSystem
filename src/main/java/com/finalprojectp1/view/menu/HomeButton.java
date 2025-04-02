package com.finalprojectp1.view.menu;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Admin
 */
public class HomeButton extends JButton {

    public HomeButton() {

        // Anulando el borde del boton
        setBorder(null);
        // Opacando el boton para que no se vea su fondo por defecto
        setOpaque(true);
        // Quitando el foco de cuando lo clickeen
        setFocusPainted(false);
        // Creando la instancia para setear el icono
        ImageIcon IconHome = new ImageIcon(getClass().getClassLoader().getResource("imgOne/icons8-house-30.png"));
        // Seteando el icono
        setIcon(IconHome);
    }
}
