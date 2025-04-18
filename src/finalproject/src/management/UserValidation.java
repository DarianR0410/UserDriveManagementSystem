package org.safepassenger.model;


import org.mindrot.jbcrypt.BCrypt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * UserValidation class provides methods to validate user input such as email, phone number, password, license, and license plate.
 * It uses regular expressions to check the validity of the input.
 */

public class UserValidation {

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final String PHONE_PATTERN = "^(\\+1[-.\\s]?)?(809|829|849)[-.\\s]?\\d{3}[-.\\s]?\\d{4}$";
    private static final String PASSWORD_PATTERN = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*()_+]).{8,}$";
    private static final String LICENSE_PATTEN = "^\\d{9}$";
    private static final String LICENSE_PLATE_PATTERN = "^[A-Z]{2,3}-\\d{4,6}$";

    public String emailValidation(String email){
        if(isValidPattern(email, EMAIL_PATTERN, Pattern.CASE_INSENSITIVE)){
            System.out.println("Correo validado.");
            return "Valid email";
        } else {
            throw new IllegalArgumentException("El correo electronico no cumple los requerimientos");
        }
    }

    public String PhoneNumbValidation(String phoneNumb){

        if(isPatternValid(phoneNumb, PHONE_PATTERN)){
            System.out.println("Numero telefonico validado.");
            return "Valid phone number";
        } else {
            throw new IllegalArgumentException("El numero de telefono no cumple los requerimientos. Favor intentar nuevamente.");
        }
    }


    public String PasswordValidation(String password){
        if(isPatternValid(password, PASSWORD_PATTERN)){
            System.out.println("Contraseña validada exitosamente");
            return "Valid password";
        } else {
            throw new IllegalArgumentException("La contraseña no cumple los requerimientos minimos. " +
                    "La contraseña requiere de: " +
                    "- Al menos una letra mayuscula. " +
                    "- Al menos una letra minuscula. " +
                    "- Al menos un numero. " +
                    "- Al menos un caracter especial. " +
                    "- Debe ser de 8 caracteres como minimo.");
        }
    }


    public String HashPassword(String password){

        return BCrypt.hashpw(password, BCrypt.gensalt());

    }


    public void verifyPassword(String password, String hashedPassword){

        if(BCrypt.checkpw(password, hashedPassword)){
            System.out.println("Contraseña validada.");
        } else {
            System.out.println("Contraseña no concuerda, favor revisar los datos.");
        }
    }


    public String LicenseValidation(String driversLicense){
        if(isPatternValid(driversLicense, LICENSE_PATTEN)){
            System.out.println("Licencia validada de forma exitosa.");
            return "Valida license";
        } else {
            throw new IllegalArgumentException("La licencia no es valida. " +
                    "Revisar: " +
                    "- Que no contenga letras. " +
                    "- Que sean exactamente 9 digitos.");
        }
    }


    public String LicensePlValidator(String licensePlate){

        if(isPatternValid(licensePlate, LICENSE_PLATE_PATTERN)){
            System.out.println("Matricula validada exitosamente");
            return "Valid Lic. Plate";
        } else {
            throw new IllegalArgumentException("Favor revisar los datos de su matricula");
        }
    }


    private boolean isValidPattern(String input, String patternString, int flags){
        Pattern pattern = Pattern.compile(patternString, flags);
        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }

    private boolean isPatternValid(String input, String patternString){
        return isValidPattern(input, patternString, 0);
    }

}

