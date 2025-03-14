
package finalproject;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.IIOException;
import javax.imageio.ImageIO;

public class QrCode {
    
    public static void QrGenerator(String data, String path, int size) {
        
       try{
        String api = "https://chart.googleapis.com/chart?chs=" + size + "x" + size + "&cht=qr&chl=" + data;
        BufferedImage image = ImageIO.read(new URL(api));
        
        File output = new File(path);
        ImageIO.write(image, "png", output);
        
           System.out.println("QR Code: " + path);
        
       }catch (IOException e){
        
           System.out.println("Unable to create the QR Code." + e.getMessage());
    }
        
    }
    
}
