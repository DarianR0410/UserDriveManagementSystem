package org.safepassenger.dao;


import org.safepassenger.model.User;

import java.sql.*;

/*
    * UserDao class handles the user-related database operations.
 */

public class UserDao {


    private static final String SQL_USER = "SELECT u.id_usuario, u.nombre, u.apellido, u.telefono, u.correo, u.contraseña, c.licencia " +
            "FROM usuario " +
            "WHERE u.correo = ? LIMIT 1";

    private final User user;

    public UserDao(User user) {
        this.user = user;
    }

    public boolean findPassengerUsingEmail(){

        try(Connection connection = GetConnection(); PreparedStatement userStmt = connection.prepareStatement(SQL_USER)){

            userStmt.setInt(1, user.getIdPassenger());
            userStmt.setString(2, user.getName());
            userStmt.setString(3, user.getLastName());
            userStmt.setString(4, user.getPhoneNumber());
            userStmt.setString(5, user.getEmail());
            userStmt.setString(6, user.getPassword());

            int affectedRows = userStmt.executeUpdate();
            if(affectedRows > 0){
                System.out.println("Usuario encontrado");
                return true;
            }else{
                System.out.println("Usuario no encontrado");
                return false;
            }

        }catch(SQLException e) {
            SQLException("No se ha podido encontrar la informacion en la base de datos,", e);
        }

        return true;
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

    public String getHashedPasswordByEmail(String email) {

        String hashedPassword = null;

        try (Connection conn = GetConnection();
             PreparedStatement prepStmt = conn.prepareStatement(SQL_USER)) {

            prepStmt.setString(1, email);
            ResultSet rs = prepStmt.executeQuery();

            if (rs.next()) {
                hashedPassword = rs.getString("contraseña");
            }

        } catch (SQLException e) {
            SQLException("Error al obtener la contraseña hasheada por correo.", e);
        }

        return hashedPassword;

    }
}
