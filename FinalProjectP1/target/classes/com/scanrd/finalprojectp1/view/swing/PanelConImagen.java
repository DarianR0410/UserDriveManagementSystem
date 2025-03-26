package com.scanrd.finalprojectp1.view.swing;

import javax.swing.*;
import java.awt.*;

/**
 * @author Isaac M
 */
public class PanelConImagen extends JPanel {

    private Image imagen;

    public PanelConImagen(String nombreArchivo) {
        cargarImagenDesdeResources(nombreArchivo);
    }

    private void cargarImagenDesdeResources(String nombreArchivo) {
        var url = getClass().getClassLoader().getResource(nombreArchivo);
        if (url != null) {
            imagen = new ImageIcon(url).getImage();
        } else {
            System.err.println("No se encontró la imagen: " + nombreArchivo);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagen != null) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
