
package finalproject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.mindrot.jbcrypt.BCrypt;


public class UserValidation {
    

    public String emailValidation(String email){
        

        String emailFormat = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        

        Pattern pattern = Pattern.compile(emailFormat, Pattern.CASE_INSENSITIVE);
        

        Matcher matcher = pattern.matcher(email);

        boolean isValid =  matcher.matches();

        if(!isValid){
            throw new IllegalArgumentException("El correo electronico no cumple los requerimientos suficientes.");
        } else {
            System.out.println("Correo electronico exitosamente validado.");
        }
        
        return "Valid email";
    }

    public String PhoneNumbValidation(String phoneNumb){
        
        String phoneFormat = "^(\\+1[-.\\s]?)?(809|829|849)[-.\\s]?\\d{3}[-.\\s]?\\d{4}$"; 

        Pattern pattern = Pattern.compile(phoneFormat);
        Matcher matcher = pattern.matcher(phoneNumb);
       boolean itMatches = matcher.matches();
       
       if(!itMatches){
           System.out.println("El numero de telefono no cumple los requerimientos.");
       } else {
           System.out.println("Numero telefonico validado.");
       }
       return "";
    }
    
 
    public String PasswordValidation(String password){
        

        String passwordFormat = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*()_+]).{8,}$";
        

        Pattern pattern = Pattern.compile(passwordFormat);
        Matcher matcher = pattern.matcher(password);
        boolean validPassword = matcher.matches();

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
        
        return "";
    }
    
 
    public String HashPassword(String password){

        return BCrypt.hashpw(password, BCrypt.gensalt()); 
        
    }
    
 
    public void viewPassword(String password, String hashedPassword){
 
        if(BCrypt.checkpw(password, hashedPassword)){
            System.out.println("Contraseña validada.");
        } else {
            System.out.println("Contraseña no concuerda, favor revisar los datos.");
        }
    }
    
 
    public String LicenseValidation(String driversLicense){
        

        String licence = "^\\d{9}$";
 
        Pattern pattern = Pattern.compile(licence);
        Matcher matcher = pattern.matcher(driversLicense);
        boolean isValidLicence = true;
        

        if(!isValidLicence){
            throw new IllegalArgumentException("La licencia no es valida"
                    + "Revisar: "
                    + "- Que no contenga letras."
                    + "- Que sean exactamente 9 digitos."
            );
            
            
   
        } else if (isValidLicence){
            System.out.println("Licencia validada de forma exitosa.");
        }
        
        return "";
    }
    

    public String LicensePlValidator(String licensePlate){
        

        String licensePl = "^[A-Z]{2,3}-\\d{4,6}$";
        

        Pattern pattern = Pattern.compile(licensePl);
        Matcher matcher = pattern.matcher(licensePlate);
        boolean isValidPlate = true;

        if(!isValidPlate){
            throw new IllegalArgumentException("Revisar los datos de la matricula");
        } else {
            System.out.println("Placa validada exitosamente.");
        }
        
        return "";
    }

}


