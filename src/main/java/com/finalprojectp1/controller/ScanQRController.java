package com.finalprojectp1.controller;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.HybridBinarizer;
import java.awt.image.BufferedImage;
import com.google.zxing.Result;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.bytedeco.javacv.OpenCVFrameGrabber;
import org.bytedeco.opencv.opencv_core.Mat;
import com.google.zxing.LuminanceSource;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;

/**
 *
 * @author Admin
 */
public class ScanQRController {

    Frame frame;

    public ScanQRController() {

    }

    private void CaptureFrame() {

        OpenCVFrameGrabber camera = new OpenCVFrameGrabber(0);

        try {

            camera.start();
            frame = camera.grab();

            if (frame != null) {
                System.out.println("Tu QR fue capturado con exito!!");
            } else {
                System.out.println("Tu QR no fue capturado");
            }

            camera.release();
            camera.close();

        } catch (FrameGrabber.Exception e) {
        }

    }

    private Mat IntoMat(Frame qrframe) {
        // Convertir el Frame a Mat (OpenCV)
        OpenCVFrameConverter.ToMat converter = new OpenCVFrameConverter.ToMat();
        Mat mat = converter.convert(qrframe);

        // Convertir el Mat a BufferedImage
        BufferedImage bufferedImage = matToBufferedImage(mat);

        // Decodificar el QR usando ZXing
        String decodedText = decodeQRCode(bufferedImage);

        if (decodedText != null) {
            System.out.println("Código QR decodificado: " + decodedText);
        } else {
            System.out.println("No se pudo decodificar el QR.");
        }
        return null;
    }

    private BufferedImage matToBufferedImage(Mat mat) {
        // Asegúrate de que el tipo de mat sea BGR (ya que OpenCV usa este formato por defecto)
        int width = mat.cols();
        int height = mat.rows();
        int channels = mat.channels();

        // Crear un BufferedImage vacío
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);

        // Obtener los datos del Mat
        byte[] data = new byte[width * height * channels];
        mat.data().get(data);  // Copiar los datos del BytePointer al arreglo de bytes

        // Llenar el BufferedImage con los datos
        image.getRaster().setDataElements(0, 0, width, height, data);
        return image;
    }

    private String decodeQRCode(BufferedImage bufferedImage) {
        try {
            // Convertir BufferedImage a LuminanceSource
            LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);

            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            // Crear el lector de ZXing
            Result result = new MultiFormatReader().decode(bitmap);

            // Devolver el texto decodificado
            return result.getText();

        } catch (NotFoundException e) {

            // No se encontró un código QR
            return null;
        }
    }
}
