package com.finalprojectp1.view.signin.swing;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * @author Isaac M
 */
// Clase que extiende JPanel para poder mostrar una imagen de fondo.
public class PanelConImagen extends JPanel {

    // Objeto de tipo Image que contendrá la imagen a mostrar
    private Image imagen;

    // Constructor que recibe el nombre del archivo de la imagen
    public PanelConImagen(String nombreArchivo) {
        cargarImagenDesdeResources(nombreArchivo); // Carga la imagen al inicializar

    }

    // Método privado que busca la imagen en la carpeta de recursos del proyecto
    private void cargarImagenDesdeResources(String nombreArchivo) {
        // Obtiene la URL del archivo dentro del classpath (src/main/resources por ejemplo)
        URL url = getClass().getClassLoader().getResource(nombreArchivo);
        // Si encuentra la imagen, la carga en el atributo 'imagen'
        if (url != null) {
            imagen = new ImageIcon(url).getImage();
        } else {
            // Si no la encuentra, muestra un mensaje de error en consola
            System.err.println("No se encontró la imagen: " + nombreArchivo);
        }
    }

    // Método que se ejecuta automáticamente cuando se repinta el panel
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Llama al método original para dibujar componentes normales
        // Si hay una imagen cargada, la dibuja ocupando todo el tamaño del panel
        if (imagen != null) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
