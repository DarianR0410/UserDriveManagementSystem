package com.finalprojectp1.controller;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamException;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.RGBLuminanceSource;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import com.finalprojectp1.view.view3.WindowCamera;
import com.github.sarxos.webcam.WebcamPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

/**
 *
 * @author Admin
 */
public class ScanQRController implements ActionListener {

    private WindowCamera windowCamera = new WindowCamera();
    
    public ScanQRController() {}

    @Override
    public void actionPerformed(ActionEvent e) {
        
            new Thread(() -> {
        
            Webcam camera = initCamera(windowCamera);
            try {
                Thread.sleep(5000);
                BufferedImage image = getImage(camera);
                if (image == null) return;

                RGBLuminanceSource source = bufferedImageToLuminanceSource(image);
                if (source == null) return;

                String data = decodeQR(source);
                if (data != null) {
                    System.out.println("QR decodificado: " + data);
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
                
            }
        }).start();
       
    }

    private Webcam initCamera(WindowCamera windowCamera) {
        try {
            Webcam camera = Webcam.getDefault();
            if (camera != null) {
                camera.setViewSize(new Dimension(640, 480));
                WebcamPanel webcamPanel = new WebcamPanel(camera);
                webcamPanel.setFPSDisplayed(true);

                windowCamera.add(webcamPanel, BorderLayout.CENTER);
                windowCamera.pack();
                windowCamera.setVisible(true);

                camera.open();
                return camera;
            } else {
                System.out.println("No se accedió a la cámara");
            }
        } catch (WebcamException e) {
            System.out.println("Error al iniciar cámara: " + e.getMessage());
        }
        return null;
    }

    private BufferedImage getImage(Webcam camera) {
        try {
            if (camera != null) {
                BufferedImage image = camera.getImage();
                if (image != null) {
                    System.out.println("La cámara obtuvo la imagen");
                    camera.close();
                    return image;
                }
            }
        } catch (WebcamException e) {
            System.out.println("No se capturó la imagen: " + e.getMessage());
        }
        return null;
    }

    private RGBLuminanceSource bufferedImageToLuminanceSource(BufferedImage image) {
        try {
            int width = image.getWidth();
            int height = image.getHeight();
            int[] pixels = image.getRGB(0, 0, width, height, null, 0, width);
            RGBLuminanceSource source = new RGBLuminanceSource(width, height, pixels);

            System.out.println("Se binarizó la imagen");
            return source;
        } catch (Exception e) {
            System.out.println("No se hizo el cambio de formato: " + e.getMessage());
        }
        return null;
    }

    private String decodeQR(RGBLuminanceSource source) {
        try {
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            Result result = new MultiFormatReader().decode(bitmap);
            return result.getText();
        } catch (NotFoundException e) {
            System.out.println("No se decodificó el QR: " + e.getMessage());
        }
        return null;
    }
}

