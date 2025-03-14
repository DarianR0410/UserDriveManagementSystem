
package finalproject;

//Created the user object responsible of handling the user's details.
public class User {
    
    //Firstly, I declared the required variables of the general users both driver and passanger.
    String name;
    String lastName;
    String phoneNumb;
    String email;
    String password;
    
    //Pass the values to the constructor.

    public User(String name, String lastName, String email, String password, String phoneNumb) {
        
        this.name = name;
        this.lastName = lastName;
        this.phoneNumb = phoneNumb;
        this.email = email;
        this.password = password;
    }
     
    
}
