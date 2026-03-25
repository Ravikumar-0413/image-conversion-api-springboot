 package com.IC.image.converter.controller;

import com.IC.image.converter.service.ImageProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/process")
public class ImageProcessingController {

    @Autowired
    private ImageProcessingService service;

    // 🔥 RESIZE
    @PostMapping("/resize")
    public ResponseEntity<byte[]> resize(
            @RequestParam MultipartFile file,
            @RequestParam int width,
            @RequestParam int height
    ) throws IOException {

        byte[] result = service.resize(file, width, height);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
                .body(result);
    }

    // 🔥 CROP
    @PostMapping("/crop")
    public ResponseEntity<byte[]> crop(
            @RequestParam MultipartFile file,
            @RequestParam int x,
            @RequestParam int y,
            @RequestParam int width,
            @RequestParam int height
    ) throws IOException {

        byte[] result = service.crop(file, x, y, width, height);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
                .body(result);
    }

    // 🔥 ROTATE
    @PostMapping("/rotate")
    public ResponseEntity<byte[]> rotate(
            @RequestParam MultipartFile file,
            @RequestParam double angle
    ) throws IOException {

        byte[] result = service.rotate(file, angle);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
                .body(result);
    }
}