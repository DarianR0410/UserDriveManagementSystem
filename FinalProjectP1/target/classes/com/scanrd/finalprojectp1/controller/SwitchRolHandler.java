package com.scanrd.finalprojectp1.controller;

import com.scanrd.finalprojectp1.view.swing.SwitchListener;
import com.scanrd.finalprojectp1.view.VentanaRegistro;
import com.scanrd.finalprojectp1.view.panelRegistroConductor;
import java.awt.BorderLayout;

/**
 * @author Isaac M
 */
public class SwitchRolHandler implements SwitchListener {

    private VentanaRegistro ventana;

    public SwitchRolHandler(VentanaRegistro ventana) {
        this.ventana = ventana;
    }

    @Override
    public void selectChange(boolean on) {
        if (on) {
            // Mostrar el registro para pasajero
            ventana.mostrarRegistro();
        } else {
            // Mostrar el registro para conductor
            panelRegistroConductor p3 = new panelRegistroConductor(ventana);
            p3.setSize(ventana.getPanelMover().getWidth(), ventana.getPanelMover().getHeight());
            p3.setLocation(0, 0);

            ventana.getPanelMover().removeAll();
            ventana.getPanelMover().add(p3, BorderLayout.CENTER);
            ventana.getPanelMover().revalidate();
            ventana.getPanelMover().repaint();
        }
    }
}
