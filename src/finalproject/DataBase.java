
package finalproject;


import com.mysql.cj.protocol.Resultset;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;



public class DataBase{
 
    String name;
    String lastName;
    String phoneNumb;
    String email;
    String password;
    String license;
    String licensePlate;
    String model;
    String brand;
    String color;
    int year;
        
    public void Register(String name, String lastName,String email,String password, String license, String phoneNumb, String rol){
        
        Connection  conn= null;
        PreparedStatement prepStmt = null;
        
        try{
            
            String path = "jdbc:mysql://localhost:3306/SavePassager";
            String username = "root";
            String dbpassword = "Darian0110*";
            
            conn = DriverManager.getConnection(path, username, dbpassword);
            
            String sqlQuery = "insert into Usuario(nombre, apellido, correo, rol, numeroTelefono, licencia, contraseña) values (?, ?, ?, ?, ?, ?,?)";
            
            prepStmt = conn.prepareStatement(sqlQuery);
            
            prepStmt.setString(1, name);
            prepStmt.setString(2, lastName);
            prepStmt.setString(3, email);
            prepStmt.setString(4, rol);
            prepStmt.setString(5, phoneNumb);
            prepStmt.setString(6, license);
            prepStmt.setString(7, password);
            
            
            prepStmt.executeUpdate();
            
            
        } catch (SQLException e){
            
            System.out.println("ALGO HA SALIDO MAL!");
            System.out.println("Por favor revise su informacion");
            System.out.println("Error: " + e.getMessage());
            
        } finally {
            
            try {
                
                if(conn != null){
                    conn.close();
                    
                    if(prepStmt != null){
                        prepStmt.close();
                    }
                }
                
            } catch (SQLException e){
                System.out.println("ERROR! Cerrando connexion con la base de datos");
            }
        }
        
    }
    
public void LogIn(String email, String password){
   Connection conn = null;
   PreparedStatement prepStmt = null;
   
   try {
       String path = "jdbc:mysql://localhost:3306/SavePassager";
       String username = "root";
       String dbpassword = "Darian0110*";
       
       conn = DriverManager.getConnection(path, username, dbpassword);
       
       String sqlQuery = "Select * from Usuarios where correo = ? and password = ?";
       
       prepStmt = conn.prepareStatement(sqlQuery);
       
       prepStmt.setString(1, email);
       prepStmt.setString(2, password);
       
      ResultSet rs = prepStmt.executeQuery();
      
      if(rs.next()){
          System.out.println("Log in exitoso");
      } else {
          System.out.println("Informacion invalida.");
      }
      
       
   } catch(SQLException e){
       System.out.println("ALGO SALIO MAL! Favor revisar su informacion.");
   } finally {
       
       try{
       if(conn != null){
           conn.close();
       }
       
       if(prepStmt != null){
           prepStmt.close();
       }
       
   }catch (SQLException e){
           System.out.println("ERROR! Cerrando los recursos.");
   } 
   
   }
} 
    
    
}