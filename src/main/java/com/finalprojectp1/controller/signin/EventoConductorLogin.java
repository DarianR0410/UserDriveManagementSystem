package com.finalprojectp1.controller.signin;

import com.finalprojectp1.view.signin.VentanaRegistro;
import com.finalprojectp1.view.signin.panelLogin;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Isaac M
 */
public class EventoConductorLogin extends MouseAdapter {

    // Atributo privado que guarda la ventana principal
    private VentanaRegistro ventana;

    // Constructor que recibe la ventana como parámetro
    public EventoConductorLogin(VentanaRegistro ventana) {
        this.ventana = ventana; // Asigna la ventana al atributo de la clase
    }

    /**
     *
     * @param evt
     */
    @Override
    public void mouseClicked(MouseEvent evt) {
        // Crea un nuevo panel de login, usando la ventana y el estado del SwitchButton
        panelLogin p4 = new panelLogin(ventana, ventana.getTglbRoll());
        // Cambia el panel actual al nuevo panel de login
        ventana.cambiarPanel(p4);
        // Cambia el título de la ventana a "Iniciar Sesión"
        ventana.setTitle("Iniciar Sesión");
    }
}
