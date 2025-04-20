package com.finalprojectp1.controller.signin;

import com.finalprojectp1.view.signin.swing.SwitchListener;
import com.finalprojectp1.view.signin.VentanaRegistro;
import com.finalprojectp1.view.signin.panelRegistroConductor;
import java.awt.BorderLayout;

/**
 * @author Isaac M
 */
//Manejador que cambia entre registro de pasajero y conductor cuando se activa/desactiva el switch.
public class SwitchRolHandler implements SwitchListener {

    private VentanaRegistro ventana; // Referencia a la ventana principal de registro

    // Constructor que recibe la ventana y la guarda para poder modificarla
    public SwitchRolHandler(VentanaRegistro ventana) {
        this.ventana = ventana;
    }

    // Este método se llama cuando cambia el estado del switch (on = true si está activado)
    @Override
    public void selectChange(boolean on) {
        if (on) {
            // Si el switch está on, mostrar el formulario de registro de pasajero
            ventana.mostrarRegistro();
        } else {
            // Si el switch está off, mostrar el formulario de conductor

            // Crear un nuevo panel de registro para conductor
            panelRegistroConductor p3 = new panelRegistroConductor(ventana);
            // Ajustar el tamaño del nuevo panel al tamaño del panel contenedor
            p3.setSize(ventana.getPanelMover().getWidth(), ventana.getPanelMover().getHeight());
            // Colocar el panel en la esquina superior izquierda
            p3.setLocation(0, 0);

            // Limpiar lo que tenga el panel contenedor actualmente
            ventana.getPanelMover().removeAll();
            // Agregar el nuevo panel en el centro usando BorderLayout
            ventana.getPanelMover().add(p3, BorderLayout.CENTER);
            // Validar nuevamente el layout para que se actualicen los cambios
            ventana.getPanelMover().revalidate();
            // Re-pintar el panel para reflejar visualmente el nuevo contenido
            ventana.getPanelMover().repaint();
        }
    }
}
