package com.scanrd.finalprojectp1.controller;

/**
 * @author Isaac M
 */
import com.scanrd.finalprojectp1.view.panelLogin;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

public class ObtenerInfoLogin extends MouseAdapter {

    private final panelLogin panel;

    public ObtenerInfoLogin(panelLogin panel) {
        this.panel = panel;
    }

    /**
     *
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        // Obtener los valores de los JTextField y JPasswordField
        // agregar mas validaciones
        String contra = "";
        for (int i = 0; i < panel.getJpContrasena().getPassword().length; i++) {
            contra += panel.getJpContrasena().getPassword()[i];
        }
        String contrasena = contra.trim();
        String correo = panel.getJtCorreo().getText().trim();

        // Validar que no estén vacíos
        if (contrasena.isEmpty() || correo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos.");
        } else {
            // Mostrar el mensaje con la información ingresada
            String mensaje = correo + "\n" + contra + "\nEstás Dentro. Disfruta.";
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }
}
