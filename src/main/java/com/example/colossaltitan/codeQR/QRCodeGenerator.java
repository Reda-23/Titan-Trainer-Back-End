package com.example.colossaltitan.codeQR;



import com.example.colossaltitan.exception.ClientNotFoundException;
import com.example.colossaltitan.model.Client;
import com.example.colossaltitan.repository.ClientRepository;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;

@Service
@AllArgsConstructor
@Slf4j
public class QRCodeGenerator {


    private ClientRepository  clientRepository;



    public BufferedImage generateQrCodeForClient(Long clientId) throws ClientNotFoundException, WriterException {

        Client client = clientRepository.getClientByClientId(clientId)
                .orElseThrow(()-> new ClientNotFoundException("client is not found with this id "+ clientId ));

        String clientData = "client name :  " + client.getClientName() + "\n"+
                "client email : " + client.getClientEmail() + "\n" +
                "client phone number : " + client.getPhoneNumber();
        log.info("generating the QR-code for the client {}",client.getClientName());
        QRCodeWriter codeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = codeWriter.encode(clientData, BarcodeFormat.QR_CODE,200,200);
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }




}
