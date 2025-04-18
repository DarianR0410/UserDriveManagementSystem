package org.safepassenger.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.safepassenger.model.User;

/*
    * @author Darian
    * @version 1.0
    * This class is responsible for registering a passenger in the database.
 */

public class RegisterPassengerDao {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/SafePassenger";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "Darian0110*";
    private static final String SQL_PASSENGER = "insert into usuario(nombre, apellido, correo, telefono, contraseña) values (?, ?, ?, ?, ?)";
    private User user = new User();

    public RegisterPassengerDao() {
    }

    public boolean RegisterPassenger(User user) {
        try {
            boolean var5;
            try (
                    Connection conn = this.GetConnection();
                    PreparedStatement prepStmt = conn.prepareStatement("insert into usuario(nombre, apellido, correo, telefono, contraseña) values (?, ?, ?, ?, ?)");
            ) {
                prepStmt.setString(1, user.getName());
                prepStmt.setString(2, user.getLastName());
                prepStmt.setString(3, user.getEmail());
                prepStmt.setString(4, user.getPhoneNumber());
                prepStmt.setString(5, user.getPassword());
                int affectedRows = prepStmt.executeUpdate();
                var5 = affectedRows > 0;
            }

            return var5;
        } catch (SQLException e) {
            this.SQLException("Error al registrar al pasajero", e);
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

