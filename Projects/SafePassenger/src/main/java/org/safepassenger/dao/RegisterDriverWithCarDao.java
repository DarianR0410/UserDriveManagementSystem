package org.safepassenger.dao;
import org.safepassenger.model.Car;
import org.safepassenger.model.Driver;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDriverWithCarDao {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/SafePassenger";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "Darian0110*";

    private static final String SQL_DRIVER_CARSP = "call RegistrarConductorYAuto (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private final Driver driver;
    private final Car car;

    public RegisterDriverWithCarDao() {
        this.driver = null;
        this.car = null;
    }

    public boolean RegisterDriverWithCar(Driver driver, Car car){

        try(Connection conn = GetConnection(); CallableStatement callableStmt = conn.prepareCall(SQL_DRIVER_CARSP)){

            //Driver information
            callableStmt.setString(1, driver.getName());
            callableStmt.setString(2, driver.getLastName());
            callableStmt.setString(3, driver.getEmail());
            callableStmt.setString(4, driver.getPhoneNumber());
            callableStmt.setString(5, driver.getLicense());
            callableStmt.setString(6, driver.getPassword());

            //Car information
            callableStmt.setString(7, car.getLicensePlate());
            callableStmt.setString(8, car.getBrand());
            callableStmt.setString(9, car.getColor());
            callableStmt.setInt(10, car.getYear());
            callableStmt.setString(11, car.getModel());

            int affectedRows = callableStmt.executeUpdate();

            if (affectedRows > 0){
                System.out.println("Se ha actualizado la informacion en la base de datos. Columnas afectadas: "+ affectedRows);
            }
            return affectedRows > 0;

        }catch (SQLException e){
            SQLException("HA OCURRIDO UN ERROR! Favor revisar su informacion e intentar nuevamente. ", e);
            return false;
        }
    }

    private Connection GetConnection() throws SQLException{
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }

    private void CloseResources(PreparedStatement prepStmt, Connection conn){
        try {
            if(prepStmt != null){
                prepStmt.close();
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
