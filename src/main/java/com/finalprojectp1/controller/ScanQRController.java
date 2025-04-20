package com.finalprojectp1.controller;

import com.finalprojectp1.view.profile.VentanaDriverProfile;
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
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class ScanQRController implements ActionListener {

    // Ventana que muestra la vista previa de la cámara
    private WindowCamera windowCamera = new WindowCamera();

    // Constructor vacío
    public ScanQRController() {
    }

    // Método que se ejecuta cuando se dispara una acción (ej. clic en un botón)
    @Override
    public void actionPerformed(ActionEvent e) {
        // Se ejecuta en un hilo separado para no bloquear la interfaz gráfica
        new Thread(() -> {
            Webcam camera = initCamera(windowCamera); // Inicializa la cámara y muestra vista previa
            try {
                Thread.sleep(5000); // Espera 5 segundos para que el usuario enfoque el QR
                BufferedImage image = getImage(camera); // Captura la imagen
                if (image == null) {
                    return; // Si no hay imagen, termina
                }

                RGBLuminanceSource source = bufferedImageToLuminanceSource(image); // Convierte la imagen para ZXing
                if (source == null) {
                    return; // Si falla la conversión, termina
                }

                String data = decodeQR(source); // Intenta decodificar el QR
                if (data != null) {

                    windowCamera.dispose();
                    System.out.println("\nQR decodificado:\n" + data); // Muestra el contenido del QR
                    JOptionPane.showMessageDialog(null, "QR detectado\n", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    redireccionarPerfil(); // Abre otra ventana (perfil del conductor)

                }
            } catch (InterruptedException ex) {
                ex.printStackTrace(); // Captura errores del hilo
            }
        }).start();
    }

    // Inicializa la cámara, configura la resolución, y muestra la vista previa
    private Webcam initCamera(WindowCamera windowCamera) {
        try {
            Webcam camera = Webcam.getDefault(); // Obtiene la cámara predeterminada
            if (camera != null) {
                camera.setViewSize(new Dimension(640, 480)); // Establece resolución
                WebcamPanel webcamPanel = new WebcamPanel(camera); // Panel con vista previa
                webcamPanel.setFPSDisplayed(true); // Muestra FPS

                // Agrega el panel a la ventana y la muestra
                windowCamera.add(webcamPanel, BorderLayout.CENTER);
                windowCamera.pack();
                windowCamera.setVisible(true);

                camera.open(); // Abre la cámara
                return camera;
            } else {
                System.out.println("No se accedió a la cámara");
            }
        } catch (WebcamException e) {
            System.out.println("Error al iniciar cámara: " + e.getMessage());
        }
        return null;
    }

    // Captura una imagen desde la cámara
    private BufferedImage getImage(Webcam camera) {
        try {
            if (camera != null) {
                BufferedImage image = camera.getImage(); // Obtiene imagen actual
                if (image != null) {
                    windowCamera.dispose(); // Cierra ventana de cámara
                    System.out.println("La cámara obtuvo la imagen");
                    camera.close(); // Cierra cámara
                    return image;
                }
            }
        } catch (WebcamException e) {
            System.out.println("No se capturó la imagen: " + e.getMessage());
        }
        return null;
    }

    // Convierte la imagen en una fuente de luminancia compatible con ZXing
    private RGBLuminanceSource bufferedImageToLuminanceSource(BufferedImage image) {
        try {
            int width = image.getWidth();
            int height = image.getHeight();
            int[] pixels = image.getRGB(0, 0, width, height, null, 0, width); // Extrae píxeles RGB
            RGBLuminanceSource source = new RGBLuminanceSource(width, height, pixels);

            System.out.println("Se binarizó la imagen");
            return source;
        } catch (Exception e) {
            System.out.println("No se hizo el cambio de formato: " + e.getMessage());
        }
        return null;
    }

    // Intenta decodificar el código QR usando ZXing
    private String decodeQR(RGBLuminanceSource source) {
        try {
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source)); // Binariza la imagen
            Result result = new MultiFormatReader().decode(bitmap); // Intenta leer el QR
            return result.getText(); // Retorna el texto del QR
        } catch (NotFoundException e) {
            System.out.println("No se decodificó el QR: " + e.getMessage());
        }
        return null;
    }

    // Abre la ventana del perfil del conductor y cierra la ventana de la cámara
    private void redireccionarPerfil() {
        VentanaDriverProfile p1 = new VentanaDriverProfile();
        p1.setVisible(true);
        if (windowCamera != null) {
            windowCamera.dispose();
        }
    }
}
