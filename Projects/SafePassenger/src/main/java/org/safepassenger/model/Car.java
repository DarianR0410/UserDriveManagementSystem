package org.safepassenger.model;

public class Car {

    private String brand;
    private String model;
    private String color;
    private int year;
    private String licensePlate;


    public Car(){

    }

    public Car(String brand, String model, String color, String licensePlate, int year) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.year = year;
        this.licensePlate = licensePlate;
    }

    public String carInformation(){
        return "Modelo: " + model + "Marca: " + brand + "Color: " + color + "Placa: " + licensePlate;
    }

    public String getBrand(){
        return this.brand;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public String getModel(){
        return this.model;
    }

    public void setModel(String model){
        this.model = model;
    }

    public String getColor(){
        return this.color;
    }

    public void setColor(String color){
        this.color = color;
    }

    public int getYear(){
        return this.year;
    }

    public void setYear(int year){
        this.year = year;
    }

    public String getLicensePlate(){
        return this.licensePlate;
    }

    public void setLicensePlate(String licensePlate){
        this.licensePlate = licensePlate;
    }

}
