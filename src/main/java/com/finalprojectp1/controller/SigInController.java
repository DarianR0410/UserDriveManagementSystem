package com.finalprojectp1.controller;

import com.finalprojectp1.view.menu.SignInButton;
import com.finalprojectp1.view.signin.VentanaRegistro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Isaac M
 */
public class SigInController implements ActionListener {

    // Botón "Sign In" al que se le asignará el controlador
    private final SignInButton signInButton;
    // Instancia de la ventana o panel "AboutUs" que se mostrará cuando se haga clic en el botón
    private final VentanaRegistro sign;

    // Constructor que recibe el botón y lo asigna al atributo de la clase
    public SigInController(SignInButton signInButton) {
        this.signInButton = signInButton;
        sign = new VentanaRegistro();
    }

    // Método que se ejecuta cuando se detecta un evento de acción (clic en el botón)
    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Muestra la ventana o panel de "About Us"
        sign.setVisible(true);
    }

}
