
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
    
    public void RegisterCliente(){
        UserValidation userValidation = new UserValidation();
        
        
        while(isValid){
            System.out.print("Nombre: ");
            name = scanner.nextLine();
            System.out.print("Apellido: ");
            lastName = scanner.nextLine();
            
            System.out.print("Correo: ");
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
           
            
            System.out.print("Rol:");
            System.out.println("1- Pasajero.");
            System.out.println("2- Conductor");
            int option = scanner.nextInt();
            scanner.hasNextLine();
            String role = "";
            
            if(option == 1){
                role = "Pasajero";
            } else if(option == 2){
                role = "Conductor";
            System.out.print("Licencia: ");
            license = scanner.nextLine();
            
            try {
                
                userValidation.LicenceValidation(license);
                
                boolean isValidCar = false;
                
                while(!isValidCar){
                    System.out.println("Ingrese los datos del automovil.");
                    System.out.print("Placa: ");
                    licensePlate = scanner.nextLine();
                    isValidCar = true;
                }
                
                } catch(IllegalArgumentException e){
                System.out.println("La licencia es invalida.");
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
                    isPasswordValid = true;
                    System.out.println("Contraseña validada correctamente.");
                }catch(IllegalArgumentException e) {
                    System.out.println("Su contraseña no cumple los requerimientos minimos.");
                }
                
            }
        }
        
    };
    
    public void SignIn(String email, String password){
        
        System.err.print("Correo Electronico: ");
        email = scanner.nextLine();
        System.err.print("Contraseña");
        password = scanner.nextLine();
        
        
    };
    
    public void SignOut(String email, String password){
        
        System.err.print("Correo Electronico: ");
        email = scanner.nextLine();
        System.err.print("Contraseña");
        password = scanner.nextLine();
    };
}
