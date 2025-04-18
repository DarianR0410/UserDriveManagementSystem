package org.safepassenger;

import com.google.zxing.WriterException;
import org.safepassenger.model.*;

import java.io.IOException;
import java.util.Scanner;

/**
 * Main class to run the SafePassenger application.
 * It provides a menu for the user to interact with the system.
 * The user can register as a passenger or driver, sign in, generate a QR code, or exit the application.
 */

/**
 * @author Darian
 * @version 1.0
 * @since 2025-20-01
 */

/*
Last update with the testing process.
 */


public class Main {
    public static void main(String[] args) {

        User user = new User();
        user.setName("Darian");
        user.setEmail("Testing123@testing.com");
        user.setEmail("Test123*");
        Driver driver = new Driver();
        Car car = new Car();
        boolean isTrue = true;
        String email = "";
        String password = "";
        UserManagement userManagement = new UserManagement();
        SignIn signIn = new SignIn();
        QrCode qrCode = new QrCode();
        Scanner scanner = new Scanner(System.in);
        Account account;
        QrCodeGenerator qrCodeGenerator = new QrCodeGenerator();


        while(isTrue){

            System.out.println("**************************");
            System.out.println("Hi me, let's go ahead and test our code.");
            System.out.println("**************************");
            System.out.println("Elije una de las siguientes opciones:");
            System.out.println("1- Registrar pasajero.");
            System.out.println("2- Registrar conductor.");
            System.out.println("3- Iniciar session.");
            System.out.println("4- Generar codigo QR.");
            System.out.println("5- Salir.");
            int option = scanner.nextInt();

            switch (option) {
                case 1: userManagement.RegisterPassenger(user);
                    break;
                case 2: userManagement.RegisterDriver(driver, car);
                    break;
                case 3: signIn.SignIn(user);
                    break;
                case 4: {

                    String data = qrCodeGenerator.DisplayQrCodeInfo(qrCode);
                    String path = "src/main/java/org/safepassenger/qr_codes/testing.jpg";
                    int width = 300;
                    int heigh = 300;
                    try {
                        qrCodeGenerator.GenerateQRCode(data, path, width, heigh);
                    } catch (WriterException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                break;
                case 5: isTrue = false;
                default:
                    throw new AssertionError();
            }
        }
    }
}
