package org.safepassenger.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.safepassenger.model.QrCode;

/**
 * ScannerDao class is responsible for interacting with the database to insert QR code information and history.
 * It uses JDBC to connect to a MySQL database and execute stored procedures.
 *
 * @author Darian
 * @version 1.0
 */
public class ScannerDao {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/SafePassenger";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "Darian0110*";
    private static final String SQL_QRCODE = "call InsertScannerAndHistory(?, ?, ?, ?, ?, ?)";
    private QrCode qrCode = new QrCode();

    public ScannerDao() {
    }

    public boolean insertQrAndHistory(QrCode qrCode) {
        try {
            boolean var5;
            try (
                    Connection conn = this.GetConnection();
                    CallableStatement callStmt = conn.prepareCall("call InsertScannerAndHistory(?, ?, ?, ?, ?, ?)");
            ) {
                callStmt.setString(1, qrCode.getPassenger());
                callStmt.setString(2, qrCode.getDriver());
                callStmt.setString(3, qrCode.getModel());
                callStmt.setString(4, qrCode.getColor());
                callStmt.setString(5, qrCode.getLicensePlate());
                callStmt.setString(6, qrCode.getPhoneNumber());
                int affectedRows = callStmt.executeUpdate();
                var5 = affectedRows > 0;
            }

            return var5;
        } catch (SQLException e) {
            this.SQLException("Error: No se ha podido guardar el QR en la base de datos. ", e);
            return false;
        }
    }

    private void SQLException(String message, SQLException e) {
        System.out.println(message);
        System.out.println("ALGO SALIO MAL! Favor revisar su informacion.");
        System.out.println("Error: " + e.getMessage());
        e.printStackTrace();
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

    private Connection GetConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/SafePassenger", "root", "Darian0110*");
    }
}
