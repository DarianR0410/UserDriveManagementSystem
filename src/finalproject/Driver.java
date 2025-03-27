
package finalproject;

public class Driver {
    
    private String name;
    private String lastName;
    private int age;
    private String email;
    private String license;
    private String phoneNumber;
    
    Driver(String name, String lastName, int age, String phoneNumber, String license){
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.license = license;
        this.phoneNumber = phoneNumber;
    }
    
    public String driverInformation(){
        return "Nombre: " + name + "Apellido: " + lastName + "Edad: " + age + "Numero de telefono: " + phoneNumber + "Licencia: " + license;
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
    
    public void setLastname(){
        this.lastName = lastName;
    }
    
    public int getAge(){
        return this.age;
    }
    
    public void setAge(){
        this.age = age;
    }
    
    public String getLicense(){
        return this.license;
    }
    
    public void setLicense(){
        this.license = license;
    }
    
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    
    public void setPhoneNumber(){
        this.phoneNumber = phoneNumber;
    }
}
