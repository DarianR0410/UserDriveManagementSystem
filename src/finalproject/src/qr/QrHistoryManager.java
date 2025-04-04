
package finalproject.src.qr;


import com.mysql.cj.MysqlType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import jdk.jfr.Timestamp;

public class QrHistoryManager {
    
    private static final String DB_URL = "jdbc:mysql://localhost:3306/SavePassager";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "Darian0110*";
    private static final String SQL_QRCODE = "insert into scanner(placa, fecha, estado) values (?, ?, ?)";
    private static final String SQL_HISTORY = "select scanner(placa, fecha, estado) values (?, ? , ?)";
    
    public void saveQrCode(String licensePlate){
        
        try(Connection conn = GetConnection(); PreparedStatement prepStmt = conn.prepareStatement(SQL_QRCODE);){
            
            prepStmt.setString(1, licensePlate);
            prepStmt.executeUpdate();
        } catch(SQLException e){
            SQLException("No se ha podido guardar la informacion. Favor revisar e intentar nuevamente", e);
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
                    qrHistory.add(rs.getString("qr_data"));
            
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
