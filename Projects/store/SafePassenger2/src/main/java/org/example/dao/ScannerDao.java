package org.example.dao;

import org.example.model.QrCode;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ScannerDao {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/SafePassenger";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "Darian0110*";

    private static final String SQL_QRCODE = "call InsertScannerAndHistory(?, ?, ?, ?, ?, ?)";

    private QrCode qrCode;

    public ScannerDao() {
        qrCode = new QrCode();
    }

    public boolean insertQrAndHistory(QrCode qrCode){

        try(Connection conn = GetConnection(); CallableStatement callStmt = conn.prepareCall(SQL_QRCODE)){

            callStmt.setString(1, qrCode.getPassenger());
            callStmt.setString(2, qrCode.getDriver());
            callStmt.setString(3, qrCode.getModel());
            callStmt.setString(4, qrCode.getColor());
            callStmt.setString(5, qrCode.getLicensePlate());
            callStmt.setString(6, qrCode.getPhoneNumber());

            int affectedRows = callStmt.executeUpdate();
            return affectedRows > 0;

        }catch (SQLException e){

            SQLException("Error: No se ha podido guardar el QR en la base de datos. ", e);
            return false;

        }

    }

    private void SQLException(String message, SQLException e){
        System.out.println(message);
        System.out.println("ALGO SALIO MAL! Favor revisar su informacion.");
        System.out.println("Error: " + e.getMessage());
        e.printStackTrace();
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
    private Connection GetConnection() throws SQLException{
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }



}