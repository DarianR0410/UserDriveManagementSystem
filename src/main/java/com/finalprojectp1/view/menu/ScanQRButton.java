package com.finalprojectp1.view.menu;


import java.awt.Dimension;
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

        // Dimensiones para el boton
        setPreferredSize(new Dimension(70, 70));
        
        // Anulando el borde del boton
        setBorder(null);
        
        // Opacando el boton para que no se vea su fondo por defecto
        setOpaque(true);
        
        // Quitando el foco de cuando lo clickeen
        setFocusPainted(false);

        // Crea un JLabel para mostrar un icono de código QR
        JLabel scanLogo;
        scanLogo = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("imgOne/icons8-qr-code-30.png")));

        // Agrega el JLabel (con la imagen) al botón
        add(scanLogo);
    }

}
