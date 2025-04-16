package org.safepassenger.model;


import org.safepassenger.dao.RegisterDriverWithCarDao;
import org.safepassenger.dao.RegisterPassengerDao;

import java.util.Scanner;

public class UserManagement {

    String name;
    String lastName;
    String phoneNumb;
    String email;
    String password;
    String license;
    String licensePlate;
    String model;
    String brand;
    String color;
    int year;


    private final User user;
    private final Driver driver;
    private final Car car;
    private final Scanner scanner;
    private final UserValidation userValidation;
    private final RegisterPassengerDao registerPassengerDao;
    private final PasswordHolder passwordHolder;
    private final RegisterDriverWithCarDao registerDriverWithCarDao;
    private final BasicData basicData;
    private final PhoneNumberHolder phoneNumberHolder;

    public UserManagement(){
        scanner = new Scanner(System.in);
        userValidation = new UserValidation();
        user = new User();
        driver = new Driver();
        car = new Car();
        registerPassengerDao = new RegisterPassengerDao();
        registerDriverWithCarDao = new RegisterDriverWithCarDao();
        passwordHolder = new PasswordHolder() {
            @Override
            public void SetNewPassword(String password) {

            }
        };
        basicData = new BasicData() {
            @Override
            public void BasicInformation(String name, String lastName, String email) {

            }
        };
        phoneNumberHolder = new PhoneNumberHolder() {
            @Override
            public void SetNewPhoneNumber(String phoneNumber) {

            }
        };

    };


    public void RegisterPassenger(User user){

        GetBasicInformation(user);

        try{
            userValidation.emailValidation(email);
        } catch(IllegalArgumentException e){
            System.out.println("El correo no cumple con los requerimientos. Intente nuevamente.");
            return;
        }

        if(!GetValidPhoneNumber(user)){

            return;

        }

        if(!GetValidPassword(user)){
            return;
        }

        registerPassengerDao.RegisterPassenger(user);

        System.out.println("Usted se ha registrado como pasajero de forma exitosa.");
        System.out.println("Bienvenido!");
    }


    public void RegisterDriver(Driver driver, Car car){

        GetBasicInformation(driver);
        int maxAttempts = 3;
        int attempts = 0;

        if (!GetValidPhoneNumber(driver)){
            return;
        }

        if(!GetValidPassword(driver)){
            return;
        }

        while(attempts < maxAttempts){
            System.out.print("Licencia:");
            license = scanner.nextLine();

            try{
                userValidation.LicenseValidation(license);
                driver.setLicense(license);
                System.out.println("Su licencia ha sido validada.");
                break;
            } catch (IllegalArgumentException e){
                attempts++;
                System.out.println("Licencia invalida, favor revise e intente nuevamente.");
                System.out.println("Intento: "+ attempts);

                if (attempts == maxAttempts){
                    System.out.println("Usted ha excedido el numero de atentos.");
                }
            }
        }

        if(!CarInformation(car)){
            return;
        }

        registerDriverWithCarDao.RegisterDriverWithCar(driver, car);
        System.out.println("Usted se ha registrado como conductor de forma exitosa.");
        System.out.println("Bienvenido!");
    }


    private void GetBasicInformation(BasicData basicData){
        System.out.print("Nombre: ");
        name = scanner.nextLine();

        System.out.print("Apellido:");
        lastName = scanner.nextLine();

        System.out.print("Email:");
        email = scanner.nextLine();

        basicData.BasicInformation(name, lastName, email);


    }

    private boolean GetValidPhoneNumber(PhoneNumberHolder phoneNumberHolder){
        System.out.print("Numero de telefono: ");
        phoneNumb = scanner.nextLine();

        try {
            userValidation.PhoneNumbValidation(phoneNumb);
            phoneNumberHolder.SetNewPhoneNumber(phoneNumb);

        }catch(IllegalArgumentException e){
            System.out.println("El numero telefonico no cumple los requerimientos.");
        }

        return true;
    }

    private boolean GetValidPassword(PasswordHolder passwordHolder){

        System.out.print("Contraseña:");
        password = scanner.nextLine();

        try {
            userValidation.PasswordValidation(password);
            password = userValidation.HashPassword(password);
            passwordHolder.SetNewPassword(password);

        } catch(IllegalArgumentException e){
            System.out.println("La contraseña no cumple los requisitos. Favor intentar nuevamente");
        }

        return true;
    }

    private boolean CarInformation(Car car){

        int maxAttempts = 3;
        int attempts = 0;

        System.out.print("Marca: ");
        brand = scanner.nextLine();
        car.setBrand(brand);

        System.out.print("Modelo: ");
        model = scanner.nextLine();
        car.setModel(model);

        System.out.print("Color: ");
        color = scanner.nextLine();
        car.setModel(color);

        System.out.print("Año: ");
        year = scanner.nextInt();
        car.setYear(year);


        while (attempts < maxAttempts){

            System.out.print("Placa: ");
            licensePlate = scanner.nextLine();
            car.setLicensePlate(licensePlate);

            try {
                userValidation.LicensePlValidator(licensePlate);
                System.out.println("Placa validada.");
                break;
            } catch (IllegalArgumentException e){
                attempts++;
                System.out.println("La placa no es valida, favor intentar nuevamente");
                if(attempts == maxAttempts){
                    System.out.println("Usted ha excedido el numero de intentos.");
                    System.out.println("Intento: "+ attempts);
                    return false;
                }
            }

        }
        return true;
    };
}