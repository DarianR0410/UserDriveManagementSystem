package com.finalprojectp1.view;

import com.finalprojectp1.view.ContentStatic.Footer.FooterPanel;
import com.finalprojectp1.view.ContentStatic.ParagraphPanel;
import com.finalprojectp1.view.ContentStatic.RedQrPanel;
import com.finalprojectp1.view.menu.MenuPanel;
import java.awt.Color;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Admin
 */
public class FatherPanel extends JPanel {

    public FatherPanel() {

        // Color de fondo para el FatherPanel
        setBackground(Color.WHITE);

        // Manager Layout para el FatherPanel
        setLayout(new MigLayout("fill"));

        // Instancia del JPanel vacio 1
        JPanel panelVacio1 = new JPanel();

        // Aplicandole un color al fondo del JPanel vacio 1
        panelVacio1.setBackground(Color.WHITE);

        // Agregando el JPanel vacio 1, haciendolo crecer y expandirse por todo el eje horizontal
        add(panelVacio1, "pushx, growx");

        //Instancia del panel que contendra la barra de navegacion
        MenuPanel menu = new MenuPanel();

        //Agregando el menu al FatherPanel, y diciendole que lo alinee a la derecha
        add(menu, "align right");

        //Otro panel vacio para separar la imagen QR del menu y que pase a otra fila
        JPanel panelVacio2 = new JPanel();

        //Agregandole un color al fondo del panel vacio 2
        panelVacio2.setBackground(Color.WHITE);

        //Agregando el panel vacio 2 con una restriccion para un salto de linea
        add(panelVacio2, "wrap");

        //Instancia del panel para colocar la parte de texto a la izquierda de la imagen
        ParagraphPanel LabelPanel = new ParagraphPanel();

        //Agregando el texto con restricciones para alinearlo al centro y 
        //con un margen de 55 pixeles en la parte inferior
        add(LabelPanel, "align center, gapbottom 55");

        //Instancia de la imagen del QR con sombreado rojo 
        RedQrPanel redQR = new RedQrPanel();

        //Agregando la imagen con un margen inferior de 30 pixeles
        //tambien margen a la derecha de 75 pixeeles y un salto de linea
        add(redQR, "gapbottom 30, gapright 75, wrap");

        //Instancia del panel del footer
        FooterPanel footer = new FooterPanel();

        //Agregando el panel del footer con una restriccion 
        // para posicionarlo en la zona sur de la ventana
        add(footer, "dock south");

    }

}
