
package finalproject.src.database;

//Created the user object responsible of handling the user's details.
public class User {
    
    //Firstly, I declared the required variables of the general users both driver and passanger.
    private String name;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;
    
    //Pass the values to the constructor.

    public User(String name, String lastName, String email, String password, String phoneNumber) {
        
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    public String getName(){
        return this.name;
    }    
    
    public void setName(){
        this.name = name;
    }
    
    public String getLastName(){
        return this.lastName;
    }
    
    public void setLastName(){
        this.lastName = lastName;
    }
    
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    
    public void setPhoneNumber(){
        this.phoneNumber = phoneNumber;
    }
     
    public String getEmail(){
        return this.email;
    }
    
    public void setEmail(){
        this.email  = email;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public void setPassword(){
        this.password = password;
    }
}
