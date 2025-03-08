
package finalproject;

import java.util.Scanner;

public class userManagement {
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
    boolean isValid = true;
    boolean isPasswordValid = true;
    
    
    Scanner scanner = new Scanner(System.in);
    DataBase db = new DataBase();
    
    public void RegisterCliente(){
        UserValidation userValidation = new UserValidation();
        
        
        while(isValid){
            System.out.print("Nombre: ");
            name = scanner.nextLine();
            System.out.print("Apellido: ");
            lastName = scanner.nextLine();
            
            System.out.print("Correo: ");
            email = scanner.nextLine();
            try{
                userValidation.emailValidation(email);
                System.out.println("El correo se ha validado de forma exitosa.");
            }catch (IllegalArgumentException e){
                System.out.println("El correo no cumple los requerimientos, inserte un formato valido.");
                continue;
            }
            
            System.out.print("Numero de telefono: ");
            phoneNumb = scanner.nextLine();
            
            try {
                userValidation.PhoneNumbValidation(phoneNumb);
                System.out.println("Numero de telefono validado.");
            } catch (IllegalArgumentException e){
                System.out.println("El numero de telefono no es valido.");
            }
           
            
                System.out.println("Rol:");
                System.out.println("1- Pasajero.");
                System.out.println("2- Conductor");
                int option = scanner.nextInt();
                
            scanner.nextLine();
            String role = "";
            
            if(option == 1){
                role = "Pasajero";
            } else if(option == 2){
                role = "Conductor";
            
            try {
                
            System.out.print("Licencia: ");
            license = scanner.nextLine();
            
            
            userValidation.LicenceValidation(license);
                boolean isValidCar = false;
                
                while(!isValidCar){
                    System.out.println("Ingrese los datos del automovil.");
                    System.out.print("Placa: ");
                    licensePlate = scanner.nextLine();
                    System.out.print("Marca: ");
                    brand = scanner.nextLine();
                    System.out.print("Modelo: ");
                    model = scanner.nextLine();
                    System.out.print("Color: ");
                    color = scanner.nextLine();
                    System.out.print("Año: ");
                    year = scanner.nextInt();
                    isValidCar = true;
                    scanner.nextLine();
                }
                
                } catch(IllegalArgumentException e){
                System.out.println("ALGO HA SALIDO MAL. Favor revisar la informacion.");
                continue;
          } 
            } else {
                System.out.println("Opción inválida. Intente nuevamente.");
                continue;
            }
            
            
            
            while(isPasswordValid){
         
                System.out.print("Contraseña: ");
                password = scanner.nextLine();
                
                try{
                    userValidation.PasswordValidation(password);
                    String hashedPassword = userValidation.HashPassword(password);
                    isPasswordValid = false;
                    System.out.println("Contraseña validada correctamente.");
                }catch(IllegalArgumentException e) {
                    System.out.println("Su contraseña no cumple los requerimientos minimos.");
                }
                
            }
            
            db.Register(name, lastName, email, password, license, phoneNumb, role);
            System.out.println("Usted se ha registrado de forma exitosa.");
            System.out.println("Bienvenido!");
        }
        
    };
    
    public void SignIn(String email, String password){
        
        System.err.print("Correo Electronico: ");
        email = scanner.nextLine();
        System.err.print("Contraseña");
        password = scanner.nextLine();
        
        
    };
}
