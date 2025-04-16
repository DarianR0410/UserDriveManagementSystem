package org.safepassenger.model;

public class Driver implements PasswordHolder, PhoneNumberHolder, BasicData, Account {

    private int idDriver;
    private String name;
    private String lastName;
    private int age;
    private String email;
    private String license;
    private String phoneNumber;
    private String password;

    public Driver() {

    }

    public Driver (int idDriver , String name , String lastName , int age, String email, String license , String phoneNumber, String password){
        this.idDriver = idDriver;
        this.name = name;
        this.lastName = lastName;
        this.age  = age;
        this.email = email;
        this.license =  license;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }


    public String getPassword(){
        return  password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public int getId_conductor() {
        return idDriver;
    }

    public void setId_conductor(int idDriver) {
        this.idDriver = idDriver;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String setPhoneNumber(String phoneNumber) {
        return this.phoneNumber = phoneNumber;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public void setAge(int age) {
        this.age = age;

    }

    @Override
    public void SetNewPassword(String password) {
        this.password = password;
    }

    @Override
    public void BasicInformation(String name, String lastName, String email) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public void SetNewPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
