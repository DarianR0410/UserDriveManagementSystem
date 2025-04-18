package org.safepassenger.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.safepassenger.model.Car;
import org.safepassenger.model.Driver;

/**
 * RegisterDriverWithCarDao class is responsible for registering a driver with their car in the database.
 * It uses JDBC to connect to the MySQL database and execute a stored procedure.
 */

public class RegisterDriverWithCarDao {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/SafePassenger";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "Darian0110*";
    private static final String SQL_DRIVER_CARSP = "call RegistrarConductorYAuto (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final Driver driver = null;
    private final Car car = null;

    public RegisterDriverWithCarDao() {
    }

    public boolean RegisterDriverWithCar(Driver driver, Car car) {
        try {
            boolean var6;
            try (
                    Connection conn = this.GetConnection();
                    CallableStatement callableStmt = conn.prepareCall("call RegistrarConductorYAuto (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ) {
                callableStmt.setString(1, driver.getName());
                callableStmt.setString(2, driver.getLastName());
                callableStmt.setString(3, driver.getEmail());
                callableStmt.setString(4, driver.getPhoneNumber());
                callableStmt.setString(5, driver.getLicense());
                callableStmt.setString(6, driver.getPassword());
                callableStmt.setString(7, car.getLicensePlate());
                callableStmt.setString(8, car.getBrand());
                callableStmt.setString(9, car.getColor());
                callableStmt.setInt(10, car.getYear());
                callableStmt.setString(11, car.getModel());
                int affectedRows = callableStmt.executeUpdate();
                if (affectedRows > 0) {
                    System.out.println("Se ha actualizado la informacion en la base de datos. Columnas afectadas: " + affectedRows);
                }

                var6 = affectedRows > 0;
            }

            return var6;
        } catch (SQLException e) {
            this.SQLException("HA OCURRIDO UN ERROR! Favor revisar su informacion e intentar nuevamente. ", e);
            return false;
        }
    }

    private Connection GetConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/SafePassenger", "root", "Darian0110*");
    }

    private void CloseResources(PreparedStatement prepStmt, Connection conn) {
        try {
            if (prepStmt != null) {
                prepStmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException var4) {
            System.out.println("SE HA PRODUCIDO UN ERROR! Cerrando conexion con la base de datos.");
        }

    }

    private void SQLException(String message, SQLException e) {
        System.out.println(message);
        System.out.println("ALGO SALIO MAL! Favor revisar su informacion.");
        System.out.println("Error: " + e.getMessage());
        e.printStackTrace();
    }
}
