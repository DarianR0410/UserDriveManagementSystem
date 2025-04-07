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

public class ObtenerInfoLogin extends MouseAdapter {

    private final panelLogin panel;
    private final VentanaRegistro ventana;

    public ObtenerInfoLogin(panelLogin panel, VentanaRegistro ventana) {
        this.panel = panel;
        this.ventana = ventana;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Obtener valores de los campos
        char[] passArray = panel.getJpContrasena().getPassword();
        String contrasena = new String(passArray).trim();
        String correo = panel.getJtCorreo().getText().trim();

        // Validar que los campos no estén vacíos
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

        // Mensaje de éxito (evita mostrar la contraseña en el mensaje)
        JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso. Bienvenido.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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
        panel.getJtCorreo().setText("");
        panel.getJpContrasena().setText("");
        panel.getJtCorreo().requestFocus();
        mostrarMensajeConConteo();
    }

    public void mostrarMensajeConConteo() {
        final int[] contador = {5};
        final JOptionPane optionPane = new JOptionPane("Serás redirigido al inicio en " + contador[0], JOptionPane.INFORMATION_MESSAGE);
        final JDialog dialog = optionPane.createDialog("Redireccionando...");

        Timer timer = new Timer(1000, (ActionEvent e) -> {
            if (contador[0] > 0) {
                contador[0]--;
                optionPane.setMessage("Serás redirigido al inicio en " + contador[0]);
            } else {
                ((Timer) e.getSource()).stop();
                dialog.dispose();
                redireccionarAlInicio();
            }
        });
        timer.start();
        dialog.setVisible(true);
    }

    public void redireccionarAlInicio() {
        // Cerrar la ventana de registro
        if (ventana != null) {
            ventana.dispose();
        }
    }
}
