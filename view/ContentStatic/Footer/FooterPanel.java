/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinalp1.view.ContentStatic.Footer;

import com.proyectofinalp1.view.ContentStatic.Footer.ContactDetails.ContactDetailsPanel;
import java.awt.Color;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Admin
 */
public class FooterPanel extends JPanel{
    
    public FooterPanel(){
    
        //Estilos del panel que envuelve
        // el primer logo del pie de pagina
        
        setLayout(new MigLayout(new net.miginfocom.layout.LC().insets("0 0 40 0")));
        setBorder(null);
        setBackground(new Color(208, 208, 208));
        
   
        
      
        
       ContactDetailsPanel data = new ContactDetailsPanel();
        add(data, "gapright 80");
        
        NavigationPanel passenger = new NavigationPanel();
        add(passenger, "gapright 30");
        
       ServicesPanel services = new ServicesPanel();
        add(services, "gapleft 40");
    }
}
