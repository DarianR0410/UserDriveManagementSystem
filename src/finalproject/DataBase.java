
package finalproject;


import com.mysql.cj.protocol.Resultset;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;



public class DataBase{

    public void RegisterPassanger(String name, String lastName,String email,String password){
        
       
        Connection  conn= null;
        PreparedStatement prepStmt = null;
        
      
        try{
            
            
            String path = "jdbc:mysql://localhost:3306/SavePassager";
            String username = "root";
            String dbpassword = "Darian0110*";
            
           
            conn = DriverManager.getConnection(path, username, dbpassword);
            
            
            String sqlQuery = "insert into Usuario(nombre, apellido, correo, contraseña) values (?, ?, ?, ?)";
            
           
            prepStmt = conn.prepareStatement(sqlQuery);
            
            
            prepStmt.setString(1, name);
            prepStmt.setString(2, lastName);
            prepStmt.setString(3, email);
            prepStmt.setString(4, password);
            
            
            prepStmt.executeUpdate();
            
            
        } catch (SQLException e){
            
          
            System.out.println("ALGO HA SALIDO MAL!");
            System.out.println("Por favor revise su informacion");
            
            
            System.out.println("Error: " + e.getMessage());
            
        } finally {
            
            
            try {
                
                if(prepStmt != null){
                        prepStmt.close();
                    }
                
                if(conn != null){
                    conn.close();
                    
                }
                
            } catch (SQLException e){
                
                
                System.out.println("ERROR! Cerrando connexion con la base de datos");
            }
        }
        
    }
    
    public void RegisterDriver(String name, String lastName,String email, String licence, String password){
        
        Connection conn = null;
        PreparedStatement prepStmt = null;
        
        try{
            String path = "jdbc:mysql://localhost:3306/SavePassager";
            String username = "root";
            String dbpassword = "Darian0110*";
            
            conn = DriverManager.getConnection(path, username, dbpassword);
            
            String sqlQuery = "insert into conductor(nombre, apellido, correo, licencia, contraseña) values (?, ?, ?, ?, ?)";
            
            prepStmt = conn.prepareStatement(sqlQuery);
            
            prepStmt.setString(1, name);
            prepStmt.setString(2, lastName);
            prepStmt.setString(3, email);
            prepStmt.setString(4, licence);
            prepStmt.setString(5, password);
            
            prepStmt.executeUpdate();
            
            
        }catch(SQLException e){
        
            System.out.println("ALGO HA SALIDO MAL!");
            System.out.println("Por favor revise su informacion");
        } finally{
            try{
                
                if(prepStmt != null){
                    prepStmt.close();
                }
                
                if(conn != null){
                    conn.close();
                }
                
            }catch (SQLException e){
                
                System.out.println("ALGO HA SALIDO MAL! Cerrando conexion con la base de datos.");
            }
        }
        
    }
    
    
    
    public void RegisterCar(String licensePlate, String brand, String model, String year, String color){
        
        
        Connection conn = null;
        PreparedStatement prepStmt = null;
        
        try{
       String path = "jdbc:mysql://localhost:3306/SavePassager";
       String username = "root";
       String dbpassword = "Darian0110*";
       
       
       conn = DriverManager.getConnection(path, username, dbpassword);
       
       
      
      String sqlQuery = "insert into automovil (placa, marca, modelo, año, color) values (?, ?, ?, ?, ?)";
      
      
      prepStmt = conn.prepareStatement(sqlQuery);
      
      
      prepStmt.setString(1, licensePlate);
      prepStmt.setString(2, brand);
      prepStmt.setString(3, model);
      prepStmt.setString(4, year);
      prepStmt.setString(5, color);
      
      
       prepStmt.executeUpdate();
            
        
        }catch (SQLException e){
            System.out.println("ALGO HA SALIDO MAL! Favor revisar la informacion");
            
            
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
          
          
          System.out.println("Informacion invalida. Favor confirmar su email o contraseña.");
      }
      
       
   } catch(SQLException e){
       System.out.println("ALGO SALIO MAL! Favor revisar su informacion.");
   } finally {
       
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