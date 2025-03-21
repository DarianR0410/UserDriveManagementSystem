
package finalproject;

import com.sun.source.tree.BreakTree;
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
    String year;

    
   private final Scanner scanner;
   private final UserValidation userValidation;
   private final DataBase db;
   
   //Constructor to initialize dependencies.
   
   public UserManagement(){
       scanner = new Scanner(System.in);
       userValidation = new UserValidation();
       db = new DataBase();
       
   };
   
    // Register method for passangers
    
    public void RegisterCliente(){
    GetBasicInformation();
    
    
    try{
        userValidation.emailValidation(email);
    } catch(IllegalArgumentException e){
        System.out.println("El correo no cumple con los requerimientos. Intente nuevamente.");
        return;
    }
      
    if(!GetValidPhoneNumber()){
        return;
    }
    
    if(!GetValidPassword()){
        return;
    }
        
    db.RegisterPassanger(name, lastName, email, password);
    
            
        System.out.println("Usted se ha registrado como pasajero de forma exitosa.");
        System.out.println("Bienvenido!");
    }

   //Method to Register the driver.    
    
    public void RegisterDriver(){
        
        GetBasicInformation();
        
        if(!GetValidPhoneNumber()){
            return;
        }
        
        if (!GetValidPassword()){
            return;
        }
        
        if(!CarInformation()){
            return;
        }
        
        db.RegisterDriver(name, lastName, email, license, password);
        db.RegisterCar(licensePlate, brand, model, year, color);
        
        System.out.println("Usted se ha registrado como conductor de forma exitosa.");
        System.out.println("Bienvenido!");
    }

    //Method for the sign in both passanger and driver.
    public void SignIn(String email, String password){
        
        
        System.out.print("Correo Electronico: ");
        email = scanner.nextLine();
        System.out.print("Contraseña");
        password = scanner.nextLine();

        Boolean isSignedIn = db.LogIn(email, password);

        if(isSignedIn){
            System.out.println("Se ha iniciado sesion de forma exitosa");
        } else if(!isSignedIn){
            System.out.println("Credenciales incorrectas, favor intentar nuevamente");
        }
        
    }
    
    
   private void GetBasicInformation(){
       System.out.print("Nombre: ");
       name = scanner.nextLine();
       
       System.out.print("Apellido:");
       lastName = scanner.nextLine();
       
       System.out.print("Email:");
       email = scanner.nextLine();
       
       
   }
   
   private boolean GetValidPhoneNumber(){
       System.out.print("Numero de telefono: ");
       phoneNumb = scanner.nextLine();
       
       try {
           userValidation.PhoneNumbValidation(phoneNumb);
           
       }catch(IllegalArgumentException e){
           System.out.println("El numero telefonico no cumple los requerimientos.");
       }
       
       return true;
   }
   
   private boolean GetValidPassword(){
       
        System.out.print("Contraseña:");
        password = scanner.nextLine();
        
        try {
            userValidation.PasswordValidation(password);
            userValidation.HashPassword(password);
            
        } catch(IllegalArgumentException e){
            System.out.println("La contraseña no cumple los requisitos. Favor intentar nuevamente");
        }
        
        return true;
   }
   
   private boolean CarInformation(){
       
       int maxAttempts = 3;
       int attempts = 0;
       
       System.out.print("");
       brand = scanner.nextLine();
       
       System.out.print("Modelo: ");
       model = scanner.nextLine();
       
       System.out.print("Color: ");
       color = scanner.nextLine();
       
       System.out.print("Año: ");
       year = scanner.nextLine();
       
       while(attempts < maxAttempts){
           System.out.print("Licencia:");
           license = scanner.nextLine();
           
          try{
              userValidation.LicenseValidation(license);
              System.out.println("Su licencia ha sido validada.");
              break;
          } catch (IllegalArgumentException e){
              attempts++;
              System.out.println("Licencia invalida, favor revise e intente nuevamente.");
              System.out.println("Intento: "+ attempts);
              
              if (attempts == maxAttempts){
                  System.out.println("Usted ha excedido el numero de atentos.");
                  return false;
              }
          }
       }
       
       attempts = 0;
       
       while (attempts < maxAttempts){
           
           System.out.print("Placa: ");
           licensePlate = scanner.nextLine();
           
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
           
           attempts = 0;
           
           
       }
       
       return true;
   };
};
 