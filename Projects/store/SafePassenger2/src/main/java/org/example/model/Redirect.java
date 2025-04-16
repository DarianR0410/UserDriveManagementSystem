package org.example.model;

public class Redirect {
    private final Account account;

    public Redirect(Account account) {
        this.account = account;
    }

    public void Authenticate(){

        if (account instanceof User user){
            System.out.println("Iniciando sesion como pasajero... " + user.getEmail());
        } else if (account instanceof Driver driver){
            System.out.println("Iniciando sesion como conductor... "+ driver.getEmail());
        }

    }

    public void SignInRedirect(Account account){
        Redirect redirect = new Redirect(account);
        redirect.Authenticate();
    }

}
