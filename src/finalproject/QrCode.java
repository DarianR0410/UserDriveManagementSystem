
package finalproject;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import javax.imageio.IIOException;
import javax.imageio.ImageIO;

//I created a dedicated class to handle the QR Code.
public class QrCode {
    
    public static void QrGenerator(String data, String path, int size) {
        
       try{
        
        //I decided to work with consuming an API to generate the QR Code, but for reasons of security, maintainability, and usability is necessary to ocult the path.
        //I did this creating a properties object.
        
        //Create a properties object to read the configurations.
        Properties prop = new Properties();
        
        //Loads the configurations file with the API related properties.
        prop.load(new FileInputStream("config.properties"));
           
        //Retrieve the QR Code url from the file.
        String apiUrl = prop.getProperty("qr.api");
             
        //Construct the full API URL with the required parameters.
        String api = apiUrl + size + "x" + size + "&cht=qr&chl=" + data;
        //Read the QR code image from the generated URL.
        BufferedImage image = ImageIO.read(new URL(api));
        //Create a file at the specified path to save the QR code image.
        File output = new File(path);
        //Write the downloaded image to the specified file in PNG format.
        ImageIO.write(image, "png", output);
        //Confirm successful QR code generation.
         System.out.println("QR Code: " + path);
        
       }catch (IOException e){
        
           System.out.println("Unable to create the QR Code." + e.getMessage());
    }
        
    }
    
}
