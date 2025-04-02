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

    private final VentanaRegistro ventana;
    private final panelLogin panel;

    public ManejadorEventos(VentanaRegistro ventana, panelLogin panel) {
        this.ventana = ventana;
        this.panel = panel;
        initEventHandlers();
    }

    private void initEventHandlers() {
        eventoContra();
        eventoMandarPasajeroLogin();
        eventoMandarUsuarioRegistro();
    }

    private void eventoMandarPasajeroLogin() {
        if (ventana.getLblMandarLogin() != null) { // Asegurarse de que el label no es null
            ventana.getLblMandarLogin().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent evt) {
                    /* Evento MouseClicked para cuando se le de click a ese texto del
                    registro de pasajeros, cambie hacia el panel del login */
                    panelLogin p2 = new panelLogin(ventana, ventana.getTglbRoll());
                    ventana.cambiarPanel(p2);
                    ventana.setTitle("Iniciar Sesión");
                }
            });
        } else {
            System.err.println("Error: lblMandarLogin es null en ManejadorEventos");
        }
    }

    private void eventoMandarUsuarioRegistro() {
        if (panel.getJlMandarSign() != null) { // Asegurarse de que el label no es null
            panel.getJlMandarSign().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent evt) {
                    /* Evento MouseClicked para cuando se le de click a ese texto del
                    login, cambie hacia al panel del registro */
                    SwitchButton switchButton = ventana.getTglbRoll(); // Obtener el rol actual
                    ventana.getTglbRoll().setEnabled(true); // Activar interruptor
                    ventana.setTitle("Registro"); // Titulo de ventana
                    if (switchButton.isOn()) {
                        // Si está "on" (Pasajero), vuelve al registro
                        ventana.mostrarRegistro();
                    } else {
                        // Si está "off" (Conductor), vuelve al panel de registro conductor
                        panelRegistroConductor p5 = new panelRegistroConductor(ventana);
                        ventana.cambiarPanel(p5);
                    }
                }
            });
        } else {
            System.err.println("Error: JlMandarSign es null en ManejadorEventos");
        }
    }

    private void eventoContra() {
        if (panel.getJlCambiarContra() != null) { // Verifica que no sea null
            panel.getJlCambiarContra().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //Darle funcionalidad a cambiar contraseña en este espacio
                    JOptionPane.showMessageDialog(panel,
                            "Debiste anotarla, Mala tuya.",
                            "Informacion",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            });
        } else {
            System.err.println("Error: jlCambiarContra es null en ManejadorEventos");
        }
    }

    // Otros eventos
}
