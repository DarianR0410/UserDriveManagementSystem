
package com.scanrd.finalprojectp1.controller;

import com.scanrd.finalprojectp1.view.VentanaRegistro;
import com.scanrd.finalprojectp1.view.panelLogin;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Isaac M
 */
public class EventoConductorLogin extends MouseAdapter{
    private VentanaRegistro ventana;

    public EventoConductorLogin(VentanaRegistro ventana) {
        this.ventana = ventana;
    }

    /**
     *
     * @param evt
     */
    @Override
    public void mouseClicked(MouseEvent evt) {
        panelLogin p4 = new panelLogin(ventana, ventana.getTglbRoll());
        ventana.cambiarPanel(p4);
        ventana.setTitle("Iniciar Sesión");
    }
}
