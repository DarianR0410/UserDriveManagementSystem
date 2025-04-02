
package com.finalprojectp1.controller.signin;

import com.finalprojectp1.view.signin.VentanaRegistro;
import com.finalprojectp1.view.signin.panelLogin;
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
