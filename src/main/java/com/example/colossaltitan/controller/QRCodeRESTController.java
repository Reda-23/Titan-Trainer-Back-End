package com.example.colossaltitan.controller;


import com.example.colossaltitan.codeQR.QRCodeGenerator;
import com.example.colossaltitan.exception.ClientNotFoundException;
import com.google.zxing.WriterException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@AllArgsConstructor
@RestController
@RequestMapping("/api/QRCode")
@CrossOrigin(origins = "*")
public class QRCodeRESTController {

    private QRCodeGenerator qrCodeGenerator;


    @GetMapping(value = "/generate/{clientId}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> generateQRCodeImage(@PathVariable Long clientId) throws ClientNotFoundException, WriterException, IOException {

        BufferedImage image = qrCodeGenerator.generateQrCodeForClient(clientId);
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(image,"png",arrayOutputStream);
        byte[] imageData = arrayOutputStream.toByteArray();

        return new ResponseEntity<>(imageData, HttpStatus.OK);

    }
}
