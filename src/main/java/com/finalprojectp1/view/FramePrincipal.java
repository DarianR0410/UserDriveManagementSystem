<<<<<<< HEAD:src/main/java/com/finalprojectp1/view/FramePrincipal.java
package com.finalprojectp1.view;
=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
>>>>>>> 25195a2e1292ae314e769a9b6eb4366aef6903e3:view/FramePrincipal.java

import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author Admin
 */
<<<<<<< HEAD:src/main/java/com/finalprojectp1/view/FramePrincipal.java
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

=======
public class FramePrincipal extends JFrame{
    
     
    public FramePrincipal(){
    
        //Titulo de la ventana
        setTitle("Frame Principal");
        
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
        
      
       
>>>>>>> 25195a2e1292ae314e769a9b6eb4366aef6903e3:view/FramePrincipal.java
    }
}
