/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Darian Ramos
 */
public class Coche {
    
        private String modelo;
    private int velocidadMaxima;
    private int potenciaMotor;
    private boolean enMarcha;
    
    public Coche(String modelo, int velocidadMaxima, int potenciaMotor){
        
        this.modelo = modelo;
        this.velocidadMaxima = velocidadMaxima;
        this.potenciaMotor = potenciaMotor;
        this.enMarcha = false;
        
        
    }
    
    public void acelerar(){
        if (enMarcha){
            System.out.println("El coche: "+ modelo + " esta acelerando");
    } else {
            System.out.println("Debes encender primero el coche");
        }
    }
    
    public void frenar(){
        
        if(enMarcha){
            System.out.println("El coche "+ modelo + " esta frenando.");
        } else {
            System.out.println("El coche esta apagado, no se puede frenar.");
        }
    }
    
    public void encender(){
        if(enMarcha){
            System.out.println("El coche "+ modelo + "se ha encendido");
        } else if(enMarcha == false){
            System.out.println("El coche " + modelo + " se ha apagado");
        }
    }
    
}
