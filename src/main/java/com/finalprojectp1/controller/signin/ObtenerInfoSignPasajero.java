package com.finalprojectp1.controller.signin;

/**
 * @author Isaac M
 */
import com.finalprojectp1.view.signin.VentanaRegistro;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class ObtenerInfoSignPasajero extends MouseAdapter {

    private final VentanaRegistro ventana;

    public ObtenerInfoSignPasajero(VentanaRegistro ventana) {
        this.ventana = ventana;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Obtener valores de los campos
        char[] passArray = ventana.getJpContrasena().getPassword();
        String contrasena = new String(passArray).trim();
        String apellido = ventana.getJtApellido().getText().trim();
        String correo = ventana.getJtCorreo().getText().trim();
        String nombre = ventana.getJtNombre().getText().trim();
        String numero = ventana.getJtNumero().getText().trim();

        // Validar que los campos no estén vacíos
        if (nombre.isEmpty() || apellido.isEmpty() || correo.isEmpty() || numero.isEmpty() || contrasena.isEmpty()) {
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
        ventana.getJtNombre().setText("");
        ventana.getJtApellido().setText("");
        ventana.getJtNumero().setText("");
        ventana.getJtCorreo().setText("");
        ventana.getJpContrasena().setText("");
        ventana.getJtNombre().requestFocus();
    }
}
