package com.finalprojectp1.controller.signin;

import com.finalprojectp1.view.signin.VentanaRegistro;
import com.finalprojectp1.view.signin.panelLogin;
import com.finalprojectp1.view.signin.panelRegistroConductor;
import com.finalprojectp1.view.signin.swing.SwitchButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

/**
 * @author Isaac M
 */
public class ManejadorEventos {

    // Se declara una variable final para la ventana principal del registro
    private final VentanaRegistro ventana;
    // Se declara una variable final para el panel de login
    private final panelLogin panel;

    // Constructor que recibe la ventana y el panel como parámetros
    public ManejadorEventos(VentanaRegistro ventana, panelLogin panel) {
        this.ventana = ventana; // Se asigna la ventana pasada al atributo
        this.panel = panel;     // Se asigna el panel pasado al atributo
        initEventHandlers();    // Se llama al método para iniciar los eventos
    }

    // Método que inicializa todos los manejadores de eventos
    private void initEventHandlers() {
        eventoContra();                 // Evento para el cambio de contraseña
        eventoMandarPasajeroLogin();    // Evento para ir al login desde el registro
        eventoMandarUsuarioRegistro();  // Evento para ir al registro desde el login
    }

    // Método que define el evento para cambiar al panel de login
    private void eventoMandarPasajeroLogin() {
        // Verifica que el label no sea null
        if (ventana.getLblMandarLogin() != null) {
            // Añade un listener para detectar clics en el label
            ventana.getLblMandarLogin().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent evt) {
                    // Cuando se hace clic, se crea un nuevo panel de login
                    panelLogin p2 = new panelLogin(ventana, ventana.getTglbRoll());
                    // Se cambia el panel actual al panel de login
                    ventana.cambiarPanel(p2);
                    // Se cambia el título de la ventana
                    ventana.setTitle("Iniciar Sesión");
                }
            });
        } else {
            // Si el label es null, se muestra un error en consola
            System.err.println("Error: lblMandarLogin es null en ManejadorEventos");
        }
    }

    // Método que define el evento para cambiar al panel de registro
    private void eventoMandarUsuarioRegistro() {
        // Verifica que el label no sea null
        if (panel.getJlMandarSign() != null) {
            // Añade un listener para detectar clics
            panel.getJlMandarSign().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent evt) {
                    // Se obtiene el switch de rol (Pasajero o Conductor)
                    SwitchButton switchButton = ventana.getTglbRoll();
                    // Se activa el switch
                    ventana.getTglbRoll().setEnabled(true);
                    // Se cambia el título de la ventana
                    ventana.setTitle("Registro");
                    if (switchButton.isOn()) {
                        // Si el switch está on (Pasajero), se muestra el registro normal
                        ventana.mostrarRegistro();
                    } else {
                        // Si está off (Conductor), se cambia al panel de registro conductor
                        panelRegistroConductor p5 = new panelRegistroConductor(ventana);
                        ventana.cambiarPanel(p5);
                    }
                }
            });
        } else {
            // Si el label es null, se muestra un error en consola
            System.err.println("Error: JlMandarSign es null en ManejadorEventos");
        }
    }

    // Método que define el evento para "cambiar contraseña"
    private void eventoContra() {
        // Verifica que el label no sea null
        if (panel.getJlCambiarContra() != null) {
            // Añade un listener para detectar clics
            panel.getJlCambiarContra().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // Muestra un mensaje cuando se hace clic (por ahora)
                    JOptionPane.showMessageDialog(panel,
                            "Debiste anotarla, Mala tuya.",
                            "Informacion",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            });
        } else {
            // Si el label es null, se muestra un error en consola
            System.err.println("Error: jlCambiarContra es null en ManejadorEventos");
        }
    }
}
