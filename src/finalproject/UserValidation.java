
package finalproject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.mindrot.jbcrypt.BCrypt;

//Created the UserValidation class. In this one I'll be handling all the required validations for both register and log-in processes.
public class UserValidation {
    
   //First method handles the validation of the email.
    public void emailValidation(String email){
        
        //This variable contains the typical structure of an email address.
        String emailFormat = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        
        // Defined the pattern object to evaluate if the user input matches the email address format.
        Pattern pattern = Pattern.compile(emailFormat, Pattern.CASE_INSENSITIVE);
        
        //The matcher object performs a matching operation using pattern.
        Matcher matcher = pattern.matcher(email);
        
        //declared a variable to check the condition.
        boolean isValid =  matcher.matches();
        
        // Check if the email is valid and print the corresponding message
        if(!isValid){
            throw new IllegalArgumentException("El correo electronico no cumple los requerimientos suficientes.");
        } else {
            System.out.println("Correo electronico exitosamente validado.");
        }
        
    }
    
    //This method handles the validation of the phone number.
    public void PhoneNumbValidation(String phoneNumb){
        
        //Regex con los diferentes formatos de numb de telefono en RD.
        String phoneFormat = "^(\\+1[-.\\s]?)?(809|829|849)[-.\\s]?\\d{3}[-.\\s]?\\d{4}$"; 
        
        //Excecutes the same process as in the previous method.
        Pattern pattern = Pattern.compile(phoneFormat);
        Matcher matcher = pattern.matcher(phoneNumb);
       boolean itMatches = matcher.matches();
       
       //Same as before.
       if(!itMatches){
           System.out.println("El numero de telefono no cumple los requerimientos.");
       } else {
           System.out.println("Numero telefonico validado.");
       }
    }
    
    //This method validates the password, it should meet some basic requirements to be considered a password such as A capital letter, a number, an special char, etc.
    public void PasswordValidation(String password){
        
        //String variable with the basic structure of a Password.
        String passwordFormat = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*()_+]).{8,}$";
        
        //Same as in the other methods.
        Pattern pattern = Pattern.compile(passwordFormat);
        Matcher matcher = pattern.matcher(password);
        boolean validPassword = matcher.matches();
        
        //In this case, it prints a message letting the user knows what the password must contain to be valid.
        if(!validPassword){
            throw new IllegalArgumentException("La contraseña no cumple los requerimientos minimos"
                    + "La contraseña requiere de: " 
                    + "- Al menos una letra mayuscula"
                    + "- Al menos una letra minuscula"
                    + "- Al menos un numero"
                    + "- Al menos un caracter especial"
                    + "- Debe ser de 8 caracteres como minimo" );
        } else if (validPassword){
            System.out.println("Contraseña validada exitosamente.");
        }
        
    }
    
    //Here I decided to hash the password, since it's considered bad practice to send the password without hashing. I applied the jBcrypt to hash it before sending it to the database.
    //Createad a method to hash the password.
    public String HashPassword(String password){
        //Used the jBcrypt library and passed the required parameters to hash the password.
        return BCrypt.hashpw(password, BCrypt.gensalt()); // The BCrypt.gensalt() generates a random salt string, this is necessary to hash the password.
        
    }
    
    //With this method I can verify if the password (in plain text) matches the previously hashed password.
    public void viewPassword(String password, String hashedPassword){
        //inside the if statement I'm implementing the jBcrypt library method to check on the password. It requires two parameters: 1- The plain text password to evaluate and 2- the hashedPassword.
        if(BCrypt.checkpw(password, hashedPassword)){
            System.out.println("Contraseña validada.");
        } else {
            System.out.println("Contraseña no concuerda, favor revisar los datos.");
        }
    }
    
    //Those last two methods are dedicated to the driver.
    //With this method I can validate the licence of the user, this one uses the DR format of a licence.
    public void LicenseValidation(String driversLicense){
        
        //The variable contains the DR licence's format.
        String licence = "^\\d{9}$";
        
        //Evaluates if it matches with the pattern and matcher objects.
        Pattern pattern = Pattern.compile(licence);
        Matcher matcher = pattern.matcher(driversLicense);
        boolean isValidLicence = true;
        
        //If it doesn't meet the requirements, throws an exception and let's the user knows what to check.
        if(!isValidLicence){
            throw new IllegalArgumentException("La licencia no es valida"
                    + "Revisar: "
                    + "- Que no contenga letras."
                    + "- Que sean exactamente 9 digitos."
            );
            
            
   
        } else if (isValidLicence){
            System.out.println("Licencia validada de forma exitosa.");
        }
    }
    
    // Inside this method I validate the License plate of the driver.
    public void LicensePlValidator(String licensePlate){
        
        //Variable that handles the lic. Plate format of DR.
        String licensePl = "^[A-Z]{2,3}-\\d{4,6}$";
        
        //I apply the same objets as in the other methods.
        Pattern pattern = Pattern.compile(licensePl);
        Matcher matcher = pattern.matcher(licensePlate);
        boolean isValidPlate = true;
        
        //Inside the if-statement, if the user input doesn' match the format it throws an error and, if it does, prints a message about the plate being valid.
        if(!isValidPlate){
            throw new IllegalArgumentException("Revisar los datos de la matricula");
        } else {
            System.out.println("Placa validada exitosamente.");
        }
        
    }

}


