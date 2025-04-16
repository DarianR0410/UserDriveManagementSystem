package org.safepassenger.dao;


import org.safepassenger.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class RegisterPassengerDao {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/SafePassenger";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "Darian0110*";

    private static final String SQL_PASSENGER = "insert into usuario(nombre, apellido, correo, telefono, contraseña) values (?, ?, ?, ?, ?)";
    private User user;

    public RegisterPassengerDao() {

        user = new User();
    }


    public boolean RegisterPassenger(User user){

        try(Connection conn = GetConnection(); PreparedStatement prepStmt = conn.prepareStatement(SQL_PASSENGER)){

            prepStmt.setString(1, user.getName());
            prepStmt.setString(2, user.getLastName());
            prepStmt.setString(3, user.getEmail());
            prepStmt.setString(4, user.getPhoneNumber());
            prepStmt.setString(5, user.getPassword());


            int affectedRows = prepStmt.executeUpdate();
            return affectedRows > 0;


        } catch (SQLException e){
            SQLException("Error al registrar al pasajero", e);
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
