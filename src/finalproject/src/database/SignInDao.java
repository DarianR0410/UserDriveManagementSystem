package org.safepassenger.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.safepassenger.model.Account;
import org.safepassenger.model.User;

/**
 * SignInDao class handles the sign-in process for users.
 * It interacts with the database to validate user credentials.
 */

public class SignInDao {

    private static final String SQL_LOGIN = "select * from usuario where correo = ? and contraseña = ?";
    private final Account account;


    public SignInDao() {
        account = new Account() {
            @Override
            public String setEmail(String email) {
                return null;
            }

            @Override
            public String setPassword(String password) {
                return null;
            }

            @Override
            public String getEmail() {
                return null;
            }

            @Override
            public String getPassword() {
                return null;
            }
        };
    }

    public boolean SignIn(User user) {
        try {
            boolean var5;
            try (
                    Connection conn = this.GetConnection();
                    PreparedStatement prepStmt = conn.prepareStatement("select * from usuario where correo = ? and contraseña = ?");
            ) {
                prepStmt.setString(1, user.getEmail());
                prepStmt.setString(2, user.getPassword());


                try (ResultSet rs = prepStmt.executeQuery()) {
                    if (rs.next()) {
                        System.out.println("Log in exitoso");
                        return true;
                    }

                    System.out.println("Informacion invalida. Favor confirmar su email o contraseña.");
                    var5 = false;
                }
            }

            return var5;
        } catch (SQLException e) {
            this.SQLException("Error al realizar el inicio de sesion.", e);
            return true;
        }
    }

    public String getHashedPasswordByEmail(String email) {
        String hashedPassword = null;

        try (Connection conn = GetConnection();
             PreparedStatement prepStmt = conn.prepareStatement(SQL_LOGIN)) {

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

    private Connection GetConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/SafePassenger", "root", "Darian0110*");
    }

    public Account getAccountDetailsByEmail(String email) {
        Account account = null;

        try (Connection conn = GetConnection();
             PreparedStatement prepStmt = conn.prepareStatement(SQL_LOGIN)) {

            prepStmt.setString(1, email);
            ResultSet rs = prepStmt.executeQuery();

            if (rs.next()) {
                account.setEmail(rs.getString("correo"));
                account.setPassword(rs.getString("contraseña"));
            }

        } catch (SQLException e) {
            SQLException("Error al obtener los detalles de la cuenta por correo.", e);
        }

        return account;
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
