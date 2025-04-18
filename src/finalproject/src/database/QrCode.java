package org.safepassenger.model;

/**
 * QrCode class represents a QR code containing information about a passenger, driver, vehicle model, color, license plate, date, and phone number.
 * It provides getters and setters for each field to allow access and modification of the data.
 */

public class QrCode {

    private String passenger;
    private String driver;
    private String model;
    private String color;
    private String licensePlate;
    private String date;
    private String phoneNumber;

    public QrCode() {

    }

    public QrCode(String passenger, String driver, String model, String color, String licensePlate, String date, String phoneNumber) {
        this.passenger = passenger;
        this.driver = driver;
        this.model = model;
        this.color = color;
        this.licensePlate = licensePlate;
        this.date = date;
        this.phoneNumber = phoneNumber;
    }

    public String getPassenger() {
        return passenger;
    }

    public void setPassenger(String passenger) {
        this.passenger = passenger;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}
