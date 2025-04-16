package org.safepassenger.model;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class QrHistoryManager {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/SafePassenger";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "Darian0110*";

    private static final String SQL_QRCODE = "call InsertScannerAndHistory(?, ?, ?, ?, ?, ?)";
    private static final String SQL_HISTORY = "select scanner(placa, fecha, estado) values (?, ? , ?)";

    private QrCode qrCode;

    public QrHistoryManager(){
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


    public List<String> getQrHistory(String licensePlate, String date, String status) {
        List<String> qrHistory = new ArrayList<>();

        try (Connection conn = GetConnection();
             PreparedStatement historyStmt = conn.prepareStatement(SQL_HISTORY)) {

            historyStmt.setString(1, licensePlate);
            historyStmt.setString(2, date);
            historyStmt.setString(3, status);
            ResultSet rs = historyStmt.executeQuery();

            while (rs.next()) {
                Timestamp scanTime = (Timestamp) rs.getTimestamp("scan_time");
                LocalDateTime scanDateTime = scanTime.toLocalDateTime();
                LocalDateTime now = LocalDateTime.now();

                long minutesPassed = ChronoUnit.MINUTES.between(scanDateTime, now);

                if (minutesPassed <= 30) {
                    qrHistory.add(rs.getString("qr_data")); // Store QR data in history
                }
            }
        }catch (SQLException e) {

            SQLException("Error: No se ha podido generar el historial. ", e);
        }

        return qrHistory;
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