 package com.IC.image.converter.controller;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.IC.image.converter.service.ImageService;

import java.io.IOException;

@RestController
@RequestMapping("/image")
public class ImageConversionController {

    @Autowired
    private ImageService service;

    @PostMapping("/png-to-jpg")
    public ResponseEntity<byte[]> pngToJpg(@RequestParam MultipartFile file) throws IOException {

        byte[] result = service.pngToJpg(file);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=converted.jpg")
                .body(result);
    }

    @PostMapping("/jpg-to-png")
    public ResponseEntity<byte[]> jpgToPng(@RequestParam MultipartFile file) throws IOException {

        byte[] result = service.jpgToPng(file);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, "image/png")
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=converted.png")
                .body(result);
    }
}