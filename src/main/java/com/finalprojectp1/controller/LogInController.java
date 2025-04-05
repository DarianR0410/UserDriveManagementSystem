package com.finalprojectp1.controller;

import com.finalprojectp1.view.menu.LogginButton;
import com.finalprojectp1.view.signin.VentanaRegistro;
import com.finalprojectp1.view.signin.panelLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Isaac M
 */
public class LogInController implements ActionListener {

    private final LogginButton logginButton;
    private final VentanaRegistro sign;
    private final panelLogin p2;

    public LogInController(LogginButton logginButton) {
        this.logginButton = logginButton;

        // Crear ventana y panel
        sign = new VentanaRegistro();
        p2 = new panelLogin(sign, sign.getTglbRoll());

        // Cambiar el panel por panelLogin
        sign.cambiarPanel(p2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        sign.setTitle("Iniciar sesión");
        // Mostrar la ventana con el panel ya cambiado
        sign.setVisible(true);
    }
}
