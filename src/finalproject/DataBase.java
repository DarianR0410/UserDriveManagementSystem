
package finalproject;


import com.mysql.cj.protocol.Resultset;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;



public class DataBase{
    
                
            private static final String DB_URL = "jdbc:mysql://localhost:3306/SavePassager";
            private static final String DB_USERNAME = "root";
            private static final String DB_PASSWORD = "Darian0110*";
            
            private static final String SQL_PASSANGER = "insert into usuario(nombre, apellido, correo, contraseña) values (?, ?, ?, ?)";
            private static final String SQL_DRIVER = "insert into conductor(nombre, apellido, correo, licencia, contraseña) values (?, ?, ?, ?, ?)";
            private static final String SQL_CAR = "insert into automovil (placa, marca, modelo, año, color) values (?, ?, ?, ?, ?)";
            private static final String SQL_LOGIN = "Select * from usuario where correo = ? and contraseña = ?";
            private static final String SQL_QRCODE = "";

    public boolean RegisterPassanger(String name, String lastName,String email,String password){
        
            
        try(Connection conn = GetConnection(); PreparedStatement prepStmt = conn.prepareStatement(SQL_PASSANGER)){
       
            prepStmt.setString(1, name);
            prepStmt.setString(2, lastName);
            prepStmt.setString(3, email);
            prepStmt.setString(4, password);
            
            
            int affectedRows = prepStmt.executeUpdate();
            return affectedRows > 0;
            
            
        } catch (SQLException e){
            SQLException("Error al registrar al pasajero", e);
            return false;
            
        }
    }
    
    public boolean RegisterDriver(String name, String lastName,String email, String licence, String password){
        
        Connection conn = null;
        PreparedStatement driverStmt = null;
        boolean success = false;
        
        try{
            
            conn = GetConnection();
            conn.setAutoCommit(false);
            
            driverStmt.setString(1, name);
            driverStmt.setString(2, lastName);
            driverStmt.setString(3, email);
            driverStmt.setString(4, licence);
            driverStmt.setString(5, password);
            driverStmt.executeUpdate();
            
            conn.commit();
            success = true;
            
            
        }catch(SQLException e){
        
            SQLException("Error al registrar al conductor", e);
        } finally {
            CloseResources(driverStmt, conn);
        }
        
        return success;
    }
    
    
    
    public boolean RegisterCar(String licensePlate, String brand, String model, String year, String color){
        
        
        try(Connection conn = GetConnection(); PreparedStatement prepStmt = conn.prepareStatement(SQL_CAR)){

      prepStmt.setString(1, licensePlate);
      prepStmt.setString(2, brand);
      prepStmt.setString(3, model);
      prepStmt.setString(4, year);
      prepStmt.setString(5, color);
      
      
      int affectedRows = prepStmt.executeUpdate();
      return affectedRows > 0;
            
        
        }catch (SQLException e){
            SQLException("Error al registrar el vehiculo", e);
            return false;
        }
    }
    
 
public boolean LogIn(String email, String password){

   try (Connection conn = GetConnection(); PreparedStatement prepStmt = conn.prepareStatement(SQL_LOGIN)){
       
       
       prepStmt.setString(1, email);
       prepStmt.setString(2, password);
       

       try(ResultSet rs = prepStmt.executeQuery()){
      
      if(rs.next()){
          
          System.out.println("Log in exitoso");
      } else {
          
          System.out.println("Informacion invalida. Favor confirmar su email o contraseña.");
          return false;
      }
      
       }
   } catch(SQLException e){
       SQLException("Error al realizar el inicio de sesion.", e);
   } 
   return true;
}

public void QrStorage(){
    
}

private Connection GetConnection() throws SQLException{
    return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
}

private void CloseResources(PreparedStatement prepStmt, Connection conn){
    try {
        if(prepStmt != null){
            prepStmt.close();;
        }
        
        if(conn != null){
            conn.close();
        }
    } catch (SQLException e){
        System.out.println("SE HA PRODUCIDO UN ERROR! Cerrando conexion con la base de datos.");
    }
    
    
}

private void SQLException(String message, SQLException e){
    System.out.println(message);
    System.out.println("ALGO SALIO MAL! Favor revisar su informacion.");
    System.out.println("Error: " + e.getMessage());
    e.printStackTrace();
}
    
}