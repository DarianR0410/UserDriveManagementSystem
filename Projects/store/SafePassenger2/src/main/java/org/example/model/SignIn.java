package org.example.model;

import org.example.dao.SignInDao;

import java.util.Scanner;

public class SignIn {

    private String email;
    private String password;

    private final User user;
    private final Scanner scanner;
    private final UserValidation userValidation;
    private final SignInDao signInDao;
    private final Redirect redirect;
    private final Account account;

    public SignIn(){
        account = new Account() {
            @Override
            public String getEmail() {
                return "";
            }

            @Override
            public String getPassword() {
                return "";
            }
        };
        user = new User();
        signInDao = new SignInDao();
        scanner = new Scanner(System.in);
        userValidation = new UserValidation();
        redirect = new Redirect(account);
    }

    public void SignIn(User user){


        System.out.print("Correo Electronico: ");
        email = scanner.nextLine();
        System.out.print("Contraseña: ");
        password = scanner.nextLine();

        String hashedPassword = userValidation.HashPassword(password);
        Boolean isSignedIn = signInDao.SignIn(user);
        redirect.SignInRedirect(user);

        if(isSignedIn){
            System.out.println("Se ha iniciado sesion de forma exitosa");
        } else if(!isSignedIn){
            System.out.println("Credenciales incorrectas, favor intentar nuevamente");
        }



    }


}
