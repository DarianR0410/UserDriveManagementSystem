
package finalproject.src.session;

import java.util.HashMap;
import java.util.UUID;

public class SessionManager {
    
    private static final long SESSION_TIMEOUT = 30 * 60 * 1000;
    private static final HashMap<String, Long> activeSessions = new HashMap<>();
    
    public static String createSession(int userId){
        String sessionId = UUID.randomUUID().toString();
        activeSessions.put(sessionId, System.currentTimeMillis());
        
        return sessionId;
        
    }
    
    public static boolean isValidSession(String sessionId){
        Long sessionBegins = activeSessions.get(sessionId);
        
        if(sessionBegins == null){
            return false;
        }
        
        Long currentTime = System.currentTimeMillis();
        if(currentTime - sessionBegins > SESSION_TIMEOUT){
            activeSessions.remove(sessionId);
            return false;
        }
        
        return true;
    }
    
    public static void logOut(String sessionId){
        activeSessions.remove(sessionId);
    }
        
    
}
