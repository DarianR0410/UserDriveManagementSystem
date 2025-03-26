package com.scanrd.finalprojectp1.controller;

/**
 * @author Isaac M
 */
import com.scanrd.finalprojectp1.view.VentanaRegistro;
import com.scanrd.finalprojectp1.view.panelRegistroConductor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

public class ObtenerInfoSignConductor extends MouseAdapter {
    private panelRegistroConductor conductor;

    public ObtenerInfoSignConductor(panelRegistroConductor conductor) {
        this.conductor = conductor;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Obtener los valores de los JTextField y JPasswordField
        // agregar mas validaciones
        String contra = "";
        for (int i = 0; i < conductor.getJpContrasena().getPassword().length; i++) {
            contra += conductor.getJpContrasena().getPassword() [i];
        }
        String contrasena = contra.trim();
        String apellido = conductor.getJtApellido().getText().trim();
        String correo = conductor.getJtCorreo().getText().trim();
        String nombre = conductor.getJtNombre().getText().trim();
        String numero = conductor.getJtNumero().getText().trim();
        String placa = conductor.getJtPlaca().getText().trim();
        String marca = conductor.getJtMarca().getText().trim();
        String modelo = conductor.getJtModelo().getText().trim();
        String ano = conductor.getJtAno().getText().trim();
        String color = conductor.getJtColor().getText().trim();
        // Validar que no estén vacíos
        if (contrasena.isEmpty() || apellido.isEmpty() || correo.isEmpty() || nombre.isEmpty() || numero.isEmpty() || placa.isEmpty() || marca.isEmpty() || modelo.isEmpty() || ano.isEmpty() || color.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos.");
        } else {
            // Mostrar el mensaje con la información ingresada
            String mensaje = nombre + "\n" + apellido + "\n" + correo + "\n" + numero + "\n" + contra + "\n" + placa + "\n" + marca + "\n" + modelo + "\n" + ano + "\n" + color +"\nEstás registrado. Por favor, inicia sesión.";
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }
}