package org.safepassenger.dao;

import org.safepassenger.model.User;

import java.sql.*;
import java.sql.SQLException;

public class SignInDao {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/SafePassenger";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "Darian0110*";

    private static final String SQL_LOGIN = "select * from usuario where correo = ? and contraseña = ?";

    public boolean SignIn(User user){

        try (Connection conn = GetConnection(); PreparedStatement prepStmt = conn.prepareStatement(SQL_LOGIN)){

            prepStmt.setString(1, user.getEmail());
            prepStmt.setString(2, user.getPassword());

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