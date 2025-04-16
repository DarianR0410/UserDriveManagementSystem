package org.safepassenger.model;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;
import org.safepassenger.dao.ScannerDao;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Scanner;

public class QrCodeGenerator {

    private static QrCodeGenerator qrCodeGenerator;
    private static Scanner scanner;
    private QrCode qrCode;
    private QrCodeInput qrCodeInput;
    private QrHistoryManager qrHistoryManager;
    private ScannerDao scannerDao;

    public QrCodeGenerator(){
        scanner = new Scanner(System.in);
        qrCode = new QrCode();
        qrCodeInput = new QrCodeInput();
        scannerDao = new ScannerDao();

    }

    public void GenerateQRCode(String data, String path, int width, int height) throws WriterException, IOException {
        QRCodeWriter writer = new QRCodeWriter();
        BitMatrix matrix = writer.encode(data, BarcodeFormat.QR_CODE, width, height);
        Path filePath = FileSystems.getDefault().getPath(path);
        MatrixToImageWriter.writeToPath(matrix, "JPG", filePath);
    }


    public class QrReader {
        public static String readQRCode(String filePath) throws IOException, NotFoundException {
            BufferedImage image = ImageIO.read(new File(filePath));
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            Result result = new MultiFormatReader().decode(bitmap);
            return result.getText();
        }
    }

    public String DisplayQrCodeInfo(QrCode qrCode) {

        qrCodeInput.RequiredInformation(qrCode);

        scannerDao.insertQrAndHistory(qrCode);

        return "Nombre del pasajero: " + qrCode.getPassenger() + "\n" +
                "Nombre del conductor: " + qrCode.getDriver() + "\n" +
                "Modelo del vehiculo: " + qrCode.getModel() + "\n" +
                "Color del vehiculo: "  + qrCode.getColor() + "\n" +
                "Placa del vehiculo: " + qrCode.getLicensePlate() + "\n" +
                "Fecha de hoy: " + qrCode.getDate() + "\n" +
                "Numero de telefono del conductor: " + qrCode.getPhoneNumber();


    }

}