
package finalproject.src.model;

import finalproject.src.qr.QrHistoryManager;
import finalproject.src.session.SessionManager;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;
import java.sql.ResultSet;


public class PassengerSession {
    
private String licensePlate;
private String date;
private String status;
SessionManager sessionManager = new SessionManager();
QrHistoryManager qrHistory = new QrHistoryManager();


public void passengerSession(int userId){
    sessionManager.createSession(userId);
}

public void viewQrHistory(String sessionId){
    if(!sessionManager.isValidSession(sessionId)){
        System.out.println("Su sesion ha expirado");
        return;
    }
    
 List<String> history = qrHistory.getQrHistory(licensePlate, date, status);

    if (history.isEmpty()) {
        System.out.println("No se han generado viajes en los últimos 30 minutos.");
    } else {
        System.out.println("Historial de QR escaneados:");
        for (String record : history) {
            System.out.println(record);
        }
}

}
}
