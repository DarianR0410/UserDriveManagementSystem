package com.finalprojectp1.controller.signin;

/**
 * @author Isaac M
 */
import com.finalprojectp1.view.signin.VentanaRegistro;
import com.finalprojectp1.view.signin.panelLogin;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Pattern;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;

// Clase que extiende MouseAdapter para manejar clics de mouse
public class ObtenerInfoLogin extends MouseAdapter {

    // Atributos: el panel de login y la ventana principal
    private final panelLogin panel;
    private final VentanaRegistro ventana;

    // Constructor que recibe el panel y la ventana
    public ObtenerInfoLogin(panelLogin panel, VentanaRegistro ventana) {
        this.panel = panel;
        this.ventana = ventana;
    }

    // Evento que se ejecuta al hacer clic
    @Override
    public void mouseClicked(MouseEvent e) {

        // Obtener la contraseña del campo (como array de caracteres)
        char[] passArray = panel.getJpContrasena().getPassword();
        // Convertir el array a String y quitar espacios
        String contrasena = new String(passArray).trim();
        // Obtener el correo y quitar espacios
        String correo = panel.getJtCorreo().getText().trim();

        // Validar si algún campo está vacío
        if (correo.isEmpty() || contrasena.isEmpty()) {
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

        // Si todo está bien, muestra un mensaje de éxito
        JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso. Bienvenido.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        // Limpia los campos del formulario
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
        panel.getJtCorreo().setText("");
        panel.getJpContrasena().setText("");
        panel.getJtCorreo().requestFocus();
        mostrarMensajeConConteo();
    }

    public void mostrarMensajeConConteo() {
        final int[] contador = {5}; // Empieza desde 5 segundos
        final JOptionPane optionPane = new JOptionPane("Serás redirigido al inicio en " + contador[0], JOptionPane.INFORMATION_MESSAGE);
        final JDialog dialog = optionPane.createDialog("Redireccionando...");

        // Crea un temporizador que se ejecuta cada 1 segundo (1000 ms)
        Timer timer = new Timer(1000, (ActionEvent e) -> {
            if (contador[0] > 0) {
                contador[0]--;
                optionPane.setMessage("Serás redirigido al inicio en " + contador[0]);
            } else {
                ((Timer) e.getSource()).stop(); // Detiene el timer
                dialog.dispose();               // Cierra el cuadro de diálogo
                redireccionarAlInicio();        // Llama al método para cerrar la ventana
            }
        });
        timer.start();          // Inicia el temporizador
        dialog.setVisible(true); // Muestra el cuadro de diálogo
    }

    public void redireccionarAlInicio() {
        // Cerrar la ventana de registro
        if (ventana != null) {
            ventana.dispose();
        }
    }
}
