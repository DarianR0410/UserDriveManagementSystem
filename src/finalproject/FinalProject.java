
package finalproject;

import java.util.Scanner;

public class FinalProject {

    public static void main(String[] args) {
        
        String name;
        String email = "";
        String password = "";
        String role;
        
        
        Scanner scanner = new Scanner(System.in);
        userManagement userManagement = new userManagement();
        
        System.out.println("Welcome to safe passager!");
        System.out.println("Our purpuse is to make sure you're safe while you move around.");
        System.out.println("Please select one of the following options: ");
        System.out.println("1- Register");
        System.out.println("2- Sign in");
        
        int option = scanner.nextInt();
        
        switch(option){
            case 1: userManagement.RegisterCliente();
            case 2: userManagement.SignIn(email, password);
        }
        
    }
    
}
