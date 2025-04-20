package com.finalprojectp1.controller.signin;

/**
 * @author Isaac M
 */
import com.finalprojectp1.view.signin.panelRegistroConductor;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

// Clase que maneja el evento cuando se hace clic para registrar un conductor
public class ObtenerInfoSignConductor extends MouseAdapter {

    // Se declara una variable final para el panel de registro de conductor
    private final panelRegistroConductor conductor;

    // Constructor que recibe el panel para poder acceder a sus componentes
    public ObtenerInfoSignConductor(panelRegistroConductor conductor) {
        this.conductor = conductor;
    }

    // Método que se ejecuta cuando se hace clic
    @Override
    public void mouseClicked(MouseEvent e) {

        // Obtener la contraseña ingresada y convertirla a String
        char[] passArray = conductor.getJpContrasena().getPassword();
        String contrasena = new String(passArray).trim();

        // Obtener el resto de los datos del formulario y eliminar espacios sobrantes
        String apellido = conductor.getJtApellido().getText().trim();
        String correo = conductor.getJtCorreo().getText().trim();
        String nombre = conductor.getJtNombre().getText().trim();
        String numero = conductor.getJtNumero().getText().trim();
        String placa = conductor.getJtPlaca().getText().trim();
        String marca = conductor.getJcMarca().getSelectedItem().toString();
        String modelo = conductor.getJcModelo().getSelectedItem().toString();
        String ano = conductor.getJcAno().getSelectedItem().toString();
        String color = conductor.getJtColor().getText().trim();

        // Verifica que ningún campo esté vacío
        if (nombre.isEmpty() || apellido.isEmpty() || correo.isEmpty() || numero.isEmpty()
                || placa.isEmpty() || color.isEmpty() || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Verifica que los jcomboBox tengan una opción válida seleccionada
        if (!validarCombobx(marca, "Marca", "Por favor seleccione la marca de su vehiculo.")
                || !validarCombobx(modelo, "Modelo", "Por favor seleccione el modelo de su vehiculo.")
                || !validarCombobx(ano, "Año", "Por favor seleccione el año de su vehiculo.")) {
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

        // Validar placa (ejemplo: AAA-123 o ABC123)
        if (!placa.matches("^[A-Z]{3}-?\\d{3,4}$")) {
            JOptionPane.showMessageDialog(null, "Formato de placa no válido. Usa formato AAA-123 o ABC123.", "Error", JOptionPane.ERROR_MESSAGE);
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

    // Método para validar que un jcomboBox tenga un valor distinto al predeterminado
    private boolean validarCombobx(String valor, String valorPorDefecto, String mensaje) {
        if (valor.equals(valorPorDefecto)) {
            JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    // Limpia los campos de texto del formulario
    private void limpiarTextFields() {
        conductor.getJtNombre().setText("");
        conductor.getJtApellido().setText("");
        conductor.getJtNumero().setText("");
        conductor.getJtCorreo().setText("");
        conductor.getJpContrasena().setText("");
        conductor.getJtPlaca().setText("");
        conductor.getJtColor().setText("");
        conductor.getJtColor().setBackground(new Color(242, 242, 242)); // Restaura color de fondo
        // Reinicia los comboBox a su valor por defecto
        conductor.getJcMarca().insertItemAt("Marca", 0);
        conductor.getJcMarca().setSelectedItem("Marca");
        conductor.getJcModelo().insertItemAt("Modelo", 0);
        conductor.getJcModelo().setSelectedItem("Modelo");
        conductor.getJcAno().insertItemAt("Año", 0);
        conductor.getJcAno().setSelectedItem("Año");
        conductor.getJtNombre().requestFocus();
    }
}
