package com.finalprojectp1.view.menu;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Admin
 */
public class ScanQRButton extends JButton {

    // Constructor de la clase ScanQRButton
    public ScanQRButton() {

        // Elimina el borde del botón
        setBorder(null);

        // Hace que el botón sea opaco (no transparente)
        setOpaque(true);

        // Establece el color del texto del botón en un tono gris (RGB: 96, 96, 96)
        setForeground(new Color(96, 96, 96));

        // Evita que el botón rellene su área de contenido (permite personalizar su apariencia)
        setContentAreaFilled(false);

        // Crea un JLabel para mostrar un icono de código QR
        JLabel scanLogo;
        scanLogo = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("imgOne/icons8-qr-code-30.png")));

        // Agrega el JLabel (con la imagen) al botón
        add(scanLogo);
    }

}
