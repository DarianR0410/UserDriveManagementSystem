package com.finalprojectp1.controller.signin;

/**
 * @author Isaac M
 */
import com.finalprojectp1.view.signin.panelRegistroConductor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class ObtenerInfoSignConductor extends MouseAdapter {

    private final panelRegistroConductor conductor;

    public ObtenerInfoSignConductor(panelRegistroConductor conductor) {
        this.conductor = conductor;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Obtener valores de los campos
        char[] passArray = conductor.getJpContrasena().getPassword();
        String contrasena = new String(passArray).trim();
        String apellido = conductor.getJtApellido().getText().trim();
        String correo = conductor.getJtCorreo().getText().trim();
        String nombre = conductor.getJtNombre().getText().trim();
        String numero = conductor.getJtNumero().getText().trim();
        String placa = conductor.getJtPlaca().getText().trim();
        String marca = conductor.getJtMarca().getText().trim();
        String modelo = conductor.getJtModelo().getText().trim();
        String ano = conductor.getJtAno().getText().trim();
        String color = conductor.getJtColor().getText().trim();

        // Validar que los campos no estén vacíos
        if (nombre.isEmpty() || apellido.isEmpty() || correo.isEmpty() || numero.isEmpty()
                || placa.isEmpty() || marca.isEmpty() || modelo.isEmpty() || ano.isEmpty() || color.isEmpty() || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validar formato de correo
        if (!validarCorreo(correo)) {
            JOptionPane.showMessageDialog(null, "Correo electrónico no válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validar contraseña
        if (!validarContrasena(contrasena)) {
            JOptionPane.showMessageDialog(null, "La contraseña debe tener al menos 8 caracteres, incluir mayúsculas, minúsculas y un número.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validar número de teléfono (solo dígitos y longitud razonable)
        if (!numero.matches("\\d{8,15}")) {
            JOptionPane.showMessageDialog(null, "El número de teléfono debe contener entre 8 y 15 dígitos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validar placa (ejemplo: AAA-123 o ABC123)
        if (!placa.matches("^[A-Z]{3}-?\\d{3,4}$")) {
            JOptionPane.showMessageDialog(null, "Formato de placa no válido. Usa formato AAA-123 o ABC123.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validar año del vehículo (debe ser un número entre 1900 y el año actual)
        int anioActual = java.time.Year.now().getValue();
        if (!ano.matches("\\d{4}") || Integer.parseInt(ano) < 1900 || Integer.parseInt(ano) > anioActual) {
            JOptionPane.showMessageDialog(null, "El año del vehículo debe estar entre 1900 y " + anioActual + ".", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Mensaje de éxito (sin mostrar la contraseña)
        JOptionPane.showMessageDialog(null, "Registro exitoso. Ahora puedes iniciar sesión.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        limpiarTextFields();
    }

    private boolean validarCorreo(String correo) {
        String regex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        return Pattern.matches(regex, correo);
    }

    private boolean validarContrasena(String contrasena) {
        return contrasena.length() >= 8
                && contrasena.matches(".*[A-Z].*")
                && contrasena.matches(".*[a-z].*")
                && contrasena.matches(".*\\d.*");
    }

    private void limpiarTextFields() {
        conductor.getJtNombre().setText("");
        conductor.getJtApellido().setText("");
        conductor.getJtNumero().setText("");
        conductor.getJtCorreo().setText("");
        conductor.getJpContrasena().setText("");
        conductor.getJtPlaca().setText("");
        conductor.getJtMarca().setText("");
        conductor.getJtModelo().setText("");
        conductor.getJtAno().setText("");
        conductor.getJtColor().setText("");
        conductor.getJtNombre().requestFocus();
    }
}
