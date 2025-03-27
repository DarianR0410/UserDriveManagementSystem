
package finalproject;

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
    try {
        
        File outputDir = new File(path).getParentFile();
        if (outputDir != null && !outputDir.exists()) {
            outputDir.mkdirs();
        }
        System.out.println("Loading configuration file...");
        Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            prop.load(fis);
        }

        String apiUrl = prop.getProperty("qr.api_url");
        if (apiUrl == null || apiUrl.isEmpty()) {
            System.out.println("API URL not defined in configuration file.");
            return;
        }

        String encodedData = URLEncoder.encode(data, StandardCharsets.UTF_8.toString());

        String api = apiUrl + "?chs=" + size + "x" + size + "&cht=qr&chl=" + encodedData;
        System.out.println("Generating QR Code with URL: " + api);

        URL url = new URL(api);
        BufferedImage image = ImageIO.read(url);
        if (image == null) {
            System.out.println("Error: Could not generate QR Code image.");
            return;
        }

        File output = new File(path);
        ImageIO.write(image, "png", output);
        System.out.println("QR Code generated at: " + path);

    } catch (IOException e) {
        System.out.println("Error generating QR Code: " + e.getMessage());
        e.printStackTrace();
    }
}
    
}
