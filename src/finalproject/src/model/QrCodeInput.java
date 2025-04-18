package org.safepassenger.model;

import java.util.Scanner;

/*
 * QrCodeInput class is responsible for collecting user input to generate a QR code.
 * It prompts the user for various details such as passenger name, driver name, vehicle model, color, license plate, and driver's phone number.
 * The collected information is then set in the QrCode object.
 */

public class QrCodeInput {

    private Scanner scanner;
    private QrCode qrCode;
    private QrHistoryManager qrHistoryManager;


    QrCodeInput(){
        scanner = new Scanner(System.in);
        qrCode = new QrCode();
        qrHistoryManager = new QrHistoryManager();
    }

    public boolean  RequiredInformation(QrCode qrCode){
        System.out.println("Bienvenido! Para generar el codigo QR favor provea la siguiente informacion:");

        System.out.print("Ingrese su nombre y apellido: ");
        String passenger = scanner.nextLine();
        qrCode.setPassenger(passenger);
        System.out.print("Ingrese el nombre y apellido de su conductor: ");
        String driver = scanner.nextLine();
        qrCode.setDriver(driver);
        System.out.print("Ingrese el modelo del vehiculo: ");
        String model = scanner.nextLine();
        qrCode.setModel(model);
        System.out.print("Ingrese el color del vehiculo: ");
        String color = scanner.nextLine();
        qrCode.setColor(color);
        System.out.print("Ingrese la placa del vehiculo: ");
        String licensePlate = scanner.nextLine();
        qrCode.setLicensePlate(licensePlate);
        System.out.print("Ingrese el numero de telefono de su conductor: ");
        String phoneNumber = scanner.nextLine();
        qrCode.setPhoneNumber(phoneNumber);

        return true;


    }
}
