
package com.scanrd.finalprojectp1.controller;

/**
 * @author Isaac M
 */
import com.scanrd.finalprojectp1.view.VentanaRegistro;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

public class ObtenerInfoSignPasajero extends MouseAdapter {
    private VentanaRegistro ventana;

    public ObtenerInfoSignPasajero(VentanaRegistro ventana) {
        this.ventana = ventana;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Obtener los valores de los JTextField y JPasswordField
        // agregar mas validaciones
        String contra = "";
        for (int i = 0; i < ventana.getJpContrasena().getPassword().length; i++) {
            contra += ventana.getJpContrasena().getPassword() [i];
        }
        String contrasena = contra.trim();
        String apellido = ventana.getJtApellido().getText().trim();
        String correo = ventana.getJtCorreo().getText().trim();
        String nombre = ventana.getJtNombre().getText().trim();
        String numero = ventana.getJtNumero().getText().trim();

        // Validar que no estén vacíos
        if (contrasena.isEmpty() || apellido.isEmpty() || correo.isEmpty() || nombre.isEmpty() || numero.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos.");
        } else {
            // Mostrar el mensaje con la información ingresada
            String mensaje = nombre + "\n" + apellido + "\n" + correo + "\n" + numero + "\n" + contra + "\nEstás registrado. Por favor, inicia sesión.";
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }
}

