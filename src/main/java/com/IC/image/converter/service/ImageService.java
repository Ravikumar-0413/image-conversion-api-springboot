 package com.IC.image.converter.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

@Service
public class ImageService {

    private final long MAX_SIZE = 5 * 1024 * 1024;

    private void validate(MultipartFile file, String expectedExt) throws IOException {

        if (file == null || file.isEmpty()) {
            throw new RuntimeException("File is empty");
        }

        if (file.getSize() > MAX_SIZE) {
            throw new RuntimeException("File size exceeds 5MB");
        }
//      ✔ Ensures file is actually an image
//      ❌ Prevents fake files (PDF renamed as PNG)
      String name = file.getOriginalFilename();
        BufferedImage image = ImageIO.read(file.getInputStream());
        if (image == null) {
            throw new RuntimeException("Invalid image file");
        }
//        Upload JPG to PNG API → rejected
        if (name == null || !name.toLowerCase().endsWith(expectedExt)) {
            throw new RuntimeException("Invalid file format. Expected " + expectedExt);
        }
    }

    // 🔁 PNG → JPG
    public byte[] pngToJpg(MultipartFile file) throws IOException {

        validate(file, ".png");

        BufferedImage input = ImageIO.read(file.getInputStream());

        BufferedImage output = new BufferedImage(
                input.getWidth(),
                input.getHeight(),
                BufferedImage.TYPE_INT_RGB
        );

        Graphics2D g = output.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, output.getWidth(), output.getHeight());
        g.drawImage(input, 0, 0, null);
        g.dispose();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(output, "jpg", baos);

        return baos.toByteArray();
    }

    // 🔁 JPG → PNG
    public byte[] jpgToPng(MultipartFile file) throws IOException {

        validate(file, ".jpg"); // later you can allow .jpg

        BufferedImage image = ImageIO.read(file.getInputStream());

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);

        return baos.toByteArray();
    }
}