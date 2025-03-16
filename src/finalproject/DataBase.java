
package finalproject;


import com.mysql.cj.protocol.Resultset;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;



public class DataBase{
   
    //I started with creating the main method, which is the one that handles the registration process of both users and drivers.
    public void Register(String name, String lastName,String email,String password, String license, String phoneNumb, String rol){
        
       //Since I'll be working with passing values to a database I created a connection object and a preparedStatement one.
       //Declare the connection and prepared statement inside each method is considered good practice, with this I limit its scoopability instead and the autoclosure of the resources.
        Connection  conn= null;
        PreparedStatement prepStmt = null;
        
        //Inside a try and catch block I began to work with the database.
        try{
            
            //Created some variables to make the connection with the database.
            String path = "jdbc:mysql://localhost:3306/SavePassager";
            String username = "root";
            String dbpassword = "Darian0110*";
            
           
            conn = DriverManager.getConnection(path, username, dbpassword);
            
            //This variable is the query, where ? is equal to the values that the user will send to the database.
            String sqlQuery = "insert into Usuario(nombre, apellido, correo, rol, numeroTelefono, licencia, contraseña) values (?, ?, ?, ?, ?, ?,?)";
            
           // Use a prepared statement to excecute the query.
            prepStmt = conn.prepareStatement(sqlQuery);
            
            //Set the value with the parameters.
            prepStmt.setString(1, name);
            prepStmt.setString(2, lastName);
            prepStmt.setString(3, email);
            prepStmt.setString(4, rol);
            prepStmt.setString(5, phoneNumb);
            prepStmt.setString(6, license);
            prepStmt.setString(7, password);
            
            //Excecute the update and send the values to the database.
            prepStmt.executeUpdate();
            
            
        } catch (SQLException e){
            
          //Inside this block, it prints a message is something doesn't meet the requirements. 
            System.out.println("ALGO HA SALIDO MAL!");
            System.out.println("Por favor revise su informacion");
            
            //This one is used to check which type of error is occuring during the excecution of the code. After the process of run and debug is done, it'll be deleted.
            System.out.println("Error: " + e.getMessage());
            
        } finally {
            
            //Inside the finally, I close the resources with the implementation of a try-catch block.
            try {
                
                if(prepStmt != null){
                        prepStmt.close();
                    }
                
                if(conn != null){
                    conn.close();
                    
                }
                
            } catch (SQLException e){
                
                //This messages educates the user about an error and because of it the connection with the database will be closed.
                System.out.println("ERROR! Cerrando connexion con la base de datos");
            }
        }
        
    }
    
    
    //This method will handle the insertion of the information into the automovil table.
    public void RegisterCar(String licensePlate, String brand, String model, String year, String color){
        
        //Same case as the Register method.
        Connection conn = null;
        PreparedStatement prepStmt = null;
        
        try{
       String path = "jdbc:mysql://localhost:3306/SavePassager";
       String username = "root";
       String dbpassword = "Darian0110*";
       
       //Stablished the connection with the database.
       conn = DriverManager.getConnection(path, username, dbpassword);
       
       
       //Query to handle the insertion of the information.
      String sqlQuery = "insert into automovil (placa, marca, modelo, año, color) values (?, ?, ?, ?, ?)";
      
      //Pprepared statement to handle the query.
      prepStmt = conn.prepareStatement(sqlQuery);
      
      //Set the values with each parameter.
      prepStmt.setString(1, licensePlate);
      prepStmt.setString(2, brand);
      prepStmt.setString(3, model);
      prepStmt.setString(4, year);
      prepStmt.setString(5, color);
      
      //Execute the update.
       prepStmt.executeUpdate();
            
       //Inside the catch block, I print a message for the user to know something is wrong with their information.    
        }catch (SQLException e){
            System.out.println("ALGO HA SALIDO MAL! Favor revisar la informacion");
            
            //Same as the previous method, I close the resources on the finally block.
        } finally{
            try {
                if(prepStmt != null){
                    prepStmt.close();
                }
                
                if (conn != null) {
                    conn.close();
                    
                }
            } catch (SQLException e){
                System.out.println("ERROR! Cerrando conexion con la base de datos.");
            }
        }
    }
    
 //The log in method, basically calls the information from the data base to be evaluated and, if it's correct, makes a log in.
public void LogIn(String email, String password){
    
    //Same case as the others.
   Connection conn = null;
   PreparedStatement prepStmt = null;
   
   try {
       String path = "jdbc:mysql://localhost:3306/SavePassager";
       String username = "root";
       String dbpassword = "Darian0110*";
       
       conn = DriverManager.getConnection(path, username, dbpassword);
       
       //This variable makes the select from the Usuarios table.
       String sqlQuery = "Select * from Usuarios where correo = ? and password = ?";
       
       prepStmt = conn.prepareStatement(sqlQuery);
       
       //Set the values.
       prepStmt.setString(1, email);
       prepStmt.setString(2, password);
       
       //Declare a result set to retrive and process the data provided by the database.
      ResultSet rs = prepStmt.executeQuery();
      
      //I check the result of the query inside the if block.
      if(rs.next()){
          //if the rs.next is true it means it found a row of data that matches the record. Then the log-in is successful.
          System.out.println("Log in exitoso");
      } else {
          
          //Otherwise, when it doesn't find any match result, it gives a message letting the user knows there's no information that matches the record.
          System.out.println("Informacion invalida. Favor confirmar su email o contraseña.");
      }
      
       //Message if something fails during the excecution.
   } catch(SQLException e){
       System.out.println("ALGO SALIO MAL! Favor revisar su informacion.");
   } finally {
       //Close resources using in the same way I did in the previous methods.
       try{
           
       if(prepStmt != null){
           prepStmt.close();
       }

       if(conn != null){
           conn.close();
       }
       
   }catch (SQLException e){
       
       //If something doesn't go as expected, it prints a message to close the connection with the database.
           System.out.println("ERROR! Cerrando los recursos.");
   } 
   
   }
}

public void QrStorage(){
    
}
    
    
}