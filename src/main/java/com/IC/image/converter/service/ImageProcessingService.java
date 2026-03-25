package com.IC.image.converter.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

@Service
public class ImageProcessingService {

    private BufferedImage readImage(MultipartFile file) throws IOException {
        BufferedImage image = ImageIO.read(file.getInputStream());
        if (image == null) {
            throw new RuntimeException("Invalid image file");
        }
        return image;
    }

    // 🔥 RESIZE
    public byte[] resize(MultipartFile file, int width, int height) throws IOException {

        if (width <= 0 || height <= 0) {
            throw new RuntimeException("Width and Height must be > 0");
        }

        BufferedImage input = readImage(file);

        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = resized.createGraphics();

        g.drawImage(input, 0, 0, width, height, null);
        g.dispose();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(resized, "jpg", baos);

        return baos.toByteArray();
    }

    // 🔥 CROP
    public byte[] crop(MultipartFile file, int x, int y, int w, int h) throws IOException {

        BufferedImage input = readImage(file);

        if (x < 0 || y < 0 || w <= 0 || h <= 0 ||
                x + w > input.getWidth() || y + h > input.getHeight()) {
            throw new RuntimeException("Invalid crop dimensions");
        }

        BufferedImage cropped = input.getSubimage(x, y, w, h);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(cropped, "jpg", baos);

        return baos.toByteArray();
    }

    // 🔥 ROTATE
    public byte[] rotate(MultipartFile file, double angle) throws IOException {

        BufferedImage input = readImage(file);

        int width = input.getWidth();
        int height = input.getHeight();

        BufferedImage rotated = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics2D g = rotated.createGraphics();
        g.rotate(Math.toRadians(angle), width / 2.0, height / 2.0);
        g.drawImage(input, 0, 0, null);
        g.dispose();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(rotated, "jpg", baos);

        return baos.toByteArray();
    }
}