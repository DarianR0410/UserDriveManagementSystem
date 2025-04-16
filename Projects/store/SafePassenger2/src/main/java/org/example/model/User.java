package org.example.model;

public class User implements BasicData, PasswordHolder, PhoneNumberHolder, Account {

    private int idPassenger;
    private String name;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;

    public User() {

    }

    public User(int idPassenger, String name, String lastName, String email, String password, String phoneNumber) {

        this.idPassenger = idPassenger;
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    public int getIdPassenger(){
        return this.idPassenger;
    }

    public void setIdPassenger(int idPassenger){
        this.idPassenger = idPassenger;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String setPhoneNumber(String phoneNumber) {
        return this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void BasicInformation(String name, String lastName, String email) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public void SetNewPassword(String password) {
        this.password = password;
    }

    @Override
    public void SetNewPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}
