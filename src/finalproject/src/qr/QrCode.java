
package finalproject.src.qr;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import javax.imageio.IIOException;
import javax.imageio.ImageIO;

public class QrCode {
 
     public static void QrGenerator(String data, String path, int size) {
 
        try{

         Properties prop = new Properties();
         
         prop.load(new FileInputStream("config.properties"));
 
              
         String apiUrl = prop.getProperty("qr.api_url"); 
         String api = apiUrl + size + "x" + size + "&cht=qr&chl=" + data;
         BufferedImage image = ImageIO.read(new URL(api));
         File output = new File(path);

         ImageIO.write(image, "png", output);
 
          System.out.println("QR Code: " + path);
 
        }catch (IOException e){{
        System.out.println("Error generating QR Code: " + e.getMessage());
        e.printStackTrace();
    }
        }
     }
}
