package com.beauty1nside.bhf.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty1nside.bhf.mapper.BarcodeCreate;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

@Service
public class BarcodeCreateService {

    @Autowired
    private BarcodeCreate mapper;

    public byte[] generateBarcodeImage(String optionCode) throws WriterException, IOException {
        String barcodeNumber = mapper.getBarcodeNumber(optionCode);
        if (barcodeNumber == null) {
            throw new IllegalArgumentException("Invalid Option Code");
        }

        int width = 300;
        int height = 100;
        BitMatrix bitMatrix = new MultiFormatWriter().encode(barcodeNumber, BarcodeFormat.CODE_128, width, height);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);
        return outputStream.toByteArray();
    }
}
