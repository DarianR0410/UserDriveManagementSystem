package com.finalprojectp1.controller.signin;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 * @author Isaac M
 */
public class EventoCheckSesion implements ItemListener {

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            SwingUtilities.invokeLater(() -> {
                //agregar funcionalidad al check de recuerdame
                JOptionPane.showMessageDialog(null, "Te recuerdo");
            });
        }
    }
}
