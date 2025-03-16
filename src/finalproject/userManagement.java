
package finalproject;

import java.util.Scanner;

public class userManagement {
    
    //Begin with declaring some variables.
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
    String hashedPassword;
    boolean isValid = true;
    boolean isPasswordValid = true;
    
    
    // Create an scanner object, a userValidation object (to apply the validations) and a database object (to send the data to the database after it's validated).
    Scanner scanner = new Scanner(System.in);
    UserValidation userValidation = new UserValidation();
    DataBase db = new DataBase();
    
    //create a method to register a passanger and a driver.
    public void RegisterCliente(){
        
        // Inside a while loop the passanger/driver input their information.
        while(isValid){
            System.out.print("Nombre: ");
            name = scanner.nextLine();
            System.out.print("Apellido: ");
            lastName = scanner.nextLine();
            
            System.out.print("Correo: ");
            email = scanner.nextLine();
            
            //Inside the try and catch block, the email is validated and prints a message before moving into the next step.
            try{
                userValidation.emailValidation(email);
                System.out.println("El correo se ha validado de forma exitosa."); 
            }catch (IllegalArgumentException e){
                // if it doesn't meet the requirements, prints this error message + stops the loop.
                System.out.println("El correo no cumple los requerimientos, inserte un formato valido.");
                break;
            }
            
            boolean isValidPhone = true;
            
            while(isValidPhone){
            //Request the phone number of the passanger/driver.
            System.out.print("Numero de telefono: ");
            phoneNumb = scanner.nextLine();
            
            //Inside the try-catch block makes the validation.
            try {
                userValidation.PhoneNumbValidation(phoneNumb);
                System.out.println("Numero de telefono validado.");
                isValidPhone = false; //Breaks the loop and continue with the next step if the phone number is valid.
                
            } catch (IllegalArgumentException e){
                System.out.println("El numero de telefono no es valido.");
            }
            
            }
            
            
            //The user chooses the rol here.
                System.out.println("Rol:");
                System.out.println("1- Pasajero.");
                System.out.println("2- Conductor");
                int option = scanner.nextInt();
                scanner.nextLine();
                
                String role = "";
            
                // If option is 1 then we asign the string variable role with the "Pasajero" and move to create the password.
            if(option == 1){
                role = "Pasajero";
            } else if(option == 2){
                //If the user selects the option 2, a code display to input the information of the car.
                role = "Conductor";
            
            try {
            
            System.out.print("Licencia: ");
            license = scanner.nextLine();
            
            
            userValidation.LicenseValidation(license);
   
                // A while loop to validte the information of the car before sending it into the database.
                while(true){
                    
                    System.out.println("Ingrese los datos del automovil.");
                    
                    try{
                    System.out.print("Placa: ");
                    licensePlate = scanner.nextLine();
                    //Validates the license plate before going to the next step.
                    userValidation.LicensePlValidator(licensePlate);
                    System.out.print("Marca: ");
                    brand = scanner.nextLine();
                    System.out.print("Modelo: ");
                    model = scanner.nextLine();
                    System.out.print("Color: ");
                    color = scanner.nextLine();
                    System.out.print("Año: ");
                    year = scanner.nextLine();
                        break; //If all the information is true, breaks the loop and moves to the next step.
                    } catch(IllegalArgumentException e){
                        System.out.println("Algo ha salido mal! La informacion proporcionada no cumple los requerimientos.");
                    }
                   
                    
                    
                }
               
                //Sends the information into the database after exhausting the validation process.
                db.RegisterCar(licensePlate, brand, model, color, year);
                
                } catch(IllegalArgumentException e){
                System.out.println("ALGO HA SALIDO MAL. Favor revisar la informacion.");
                continue;
          } 
            
            } else {
                System.out.println("Opción inválida. Intente nuevamente.");
                break;
            }
            
            
            //while loop to validate the user's input as a password.
            while(isPasswordValid){
         
                //Request the password from the passanger/driver.
                System.out.print("Contraseña: ");
                password = scanner.nextLine();
                
                //inside a try and catch block calls two objects to send the parameter and evaluate and then proceed with hashing the password before storage this one into the database.
                try{
                    userValidation.PasswordValidation(password);
                    hashedPassword = userValidation.HashPassword(password);
                    isPasswordValid = false;
                    System.out.println("Contraseña validada correctamente.");
                }catch(IllegalArgumentException e) {
                    System.out.println("Su contraseña no cumple los requerimientos minimos.");
                }
                
            }
            
            //After all the validations are applied, and the password is hashed, the information is saved into the database.
            db.Register(name, lastName, email, password, license, phoneNumb, role);
            //A message to let the driver/passanger that their registration process has been successfull.
            System.out.println("Usted se ha registrado de forma exitosa.");
            System.out.println("Bienvenido!");
            
            //The boolean variable becomes false ending the loop.
            isValid = false;
        }
        
    };
    
    //A method for the driver/passanger to sign in.
    public void SignIn(String email, String password){
        
        Boolean isValid = true;
        
        System.out.print("Correo Electronico: ");
        email = scanner.nextLine();
        System.out.print("Contraseña");
        password = scanner.nextLine();
        
        //Calls the login method of the db object, sending the parameters, makes a select if the information is found in one of the rows.
        db.LogIn(email, password);
        
        //Hases the provided password and compares them. 
        hashedPassword = userValidation.HashPassword(password);
        System.out.println("Usted ha iniciado sesion, bienvenido" + " " + name);
                     
        
    };
}
 