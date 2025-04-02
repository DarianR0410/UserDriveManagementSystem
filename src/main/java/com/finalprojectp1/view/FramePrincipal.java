package com.finalprojectp1.view;

import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author Admin
 */
public class FramePrincipal extends JFrame {

    public FramePrincipal() {

        //Titulo de la ventana
        setTitle("Inicio");

        //Color del fondo de la ventana
        setBackground(Color.WHITE);

        //Especifica que el sistema debe terminar totalmente cuando se cierra
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Hace que la ventana se abra pantalla completa desde que inicia el sistema
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        //Instancia del panel que envuelve todos los componentes de la ventana
        FatherPanel panelCentral = new FatherPanel();

        //Agrega el panel que envuelve todos los componentes de la ventana
        add(panelCentral);

    }
}
