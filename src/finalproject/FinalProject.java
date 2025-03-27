
package finalproject;

import java.util.Scanner;

public class FinalProject {

public static void main(String[] args) {
    Driver driver = new Driver("Joshua", "Almanzar", 25, "80912345678", "A12345");
    Car car = new Car("Toyota", "Corolla", "ABC-1234", "Rojo", 2020);
    
    String data = driver.driverInformation() + " || " + car.carInformation();
    String path = "output/conductor_auto_qr.png";
    int size = 300;
    
    QrCode.QrGenerator(data, path, size);
}
    
}
