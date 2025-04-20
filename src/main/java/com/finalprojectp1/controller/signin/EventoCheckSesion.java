package com.finalprojectp1.controller.signin;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 * @author Isaac M
 */
// Clase que implementa ItemListener para escuchar eventos del un checkbox
public class EventoCheckSesion implements ItemListener {

    // Método que se ejecuta cuando cambia el estado del checkbox (al marcar o desmarcar)
    @Override
    public void itemStateChanged(ItemEvent e) {
        // Si el estado del checkbox cambió a "seleccionado" (o sea, si se marcó el checkbox)
        if (e.getStateChange() == ItemEvent.SELECTED) {

            // Se usa invokeLater para ejecutar el código en el hilo de la interfaz gráfica (EDT)
            SwingUtilities.invokeLater(() -> {
                // Aquí va la funcionalidad del checkbox "Recuérdame"
                // Por ahora solo muestrara este mensaje
                JOptionPane.showMessageDialog(null, "Te recuerdo");
            });
        }
    }
}
