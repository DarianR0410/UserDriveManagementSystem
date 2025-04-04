
package finalproject.src.model;

public class SignIn {
    
    private String username;
    private String password;
    private UserType userType;

    public SignIn(String username, String password, UserType userType) {
        this.username = username;
        this.password = password;
        this.userType = userType;
    }
    
    public void Authenticate(){
        
        if(userType == userType.PASAJERO){
            System.out.println("Iniciando sesion como pasajero...");
        } else {
            System.out.println("Iniciando sesion como conductor...");
        }
        
    }
    
    enum UserType{
        CONDUCTOR, PASAJERO
    }
    
}
