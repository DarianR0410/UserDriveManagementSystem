package com.scanrd.finalprojectp1.view.swing;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
* Esta clase tiene un método para establecer una imagen en un JLabel,
* ajustando automáticamente su tamaño al de la etiqueta.
 */
/**
 * @author Isaac M
 */
public class ImagenUtils {

    public static void setImageLabel(JLabel name, String ruta) {
        URL imageUrl = ImagenUtils.class.getClassLoader().getResource(ruta);

        if (imageUrl != null) {
            ImageIcon imag = new ImageIcon(imageUrl);
            name.setIcon(new ImageIcon(imag.getImage().getScaledInstance(name.getWidth(), name.getHeight(), Image.SCALE_DEFAULT)));
            name.repaint();
        } else {
            System.err.println("Error al cargar la imagen: " + ruta);
        }
    }
}
