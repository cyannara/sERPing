package com.beauty1nside.bhf.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beauty1nside.bhf.service.impl.BarcodeCreateService;
import com.google.zxing.WriterException;

@RestController
@RequestMapping("/barcode")
public class BarcodeCreateController {

    @Autowired
    private BarcodeCreateService barcodeService;

    @GetMapping("/{optionCode}")
    public ResponseEntity<byte[]> getBarcode(@PathVariable String optionCode) {
        try {
            byte[] barcodeImage = barcodeService.generateBarcodeImage(optionCode);

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=barcode.png")
                    .contentType(MediaType.IMAGE_PNG)
                    .body(barcodeImage);
        } catch (WriterException | IOException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}