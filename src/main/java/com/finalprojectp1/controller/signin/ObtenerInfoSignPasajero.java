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

    // Atributo privado que guarda la ventana principal
    private final VentanaRegistro ventana;

    // Constructor que recibe la ventana como parámetr
    public ObtenerInfoSignPasajero(VentanaRegistro ventana) {
        this.ventana = ventana; // Asigna la ventana al atributo de la clase
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Obtener la contraseña ingresada y convertirla a String
        char[] passArray = ventana.getJpContrasena().getPassword();
        String contrasena = new String(passArray).trim();
        // Obtener el resto de los datos del formulario y eliminar espacios sobrantes
        String apellido = ventana.getJtApellido().getText().trim();
        String correo = ventana.getJtCorreo().getText().trim();
        String nombre = ventana.getJtNombre().getText().trim();
        String numero = ventana.getJtNumero().getText().trim();

        // Verifica que ningún campo esté vacío
        if (nombre.isEmpty() || apellido.isEmpty() || correo.isEmpty() || numero.isEmpty() || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Valida el formato del correo usando regex
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

        // Si todo está correcto, muestra mensaje de éxito
        JOptionPane.showMessageDialog(null, "Registro exitoso. Ahora puedes iniciar sesión.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        // Limpia todos los campos del formulario
        limpiarTextFields();
    }

    // Valida que el correo tenga un formato válido (usando regex)
    private boolean validarCorreo(String correo) {
        String regex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        return Pattern.matches(regex, correo);
    }

    // Valida que la contraseña tenga:
    // al menos 8 caracteres, una mayúscula, una minúscula y un número
    private boolean validarContrasena(String contrasena) {
        return contrasena.length() >= 8
                && contrasena.matches(".*[A-Z].*")
                && contrasena.matches(".*[a-z].*")
                && contrasena.matches(".*\\d.*");
    }

    // Limpia los campos de texto del formulario
    private void limpiarTextFields() {
        ventana.getJtNombre().setText("");
        ventana.getJtApellido().setText("");
        ventana.getJtNumero().setText("");
        ventana.getJtCorreo().setText("");
        ventana.getJpContrasena().setText("");
        ventana.getJtNombre().requestFocus();
    }
}
