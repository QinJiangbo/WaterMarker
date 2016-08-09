package com.qinjiangbo.image;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Richard on 7/17/16.
 */
public class ScaleImage {

    /**
     * 缩放图片
     * @param imagePath
     * @param width
     * @param height
     * @param outputPath
     */
    public void scaleImage(String imagePath, int width, int height, String outputPath) {
        File imageFile = new File(imagePath);
        OutputStream outputStream = null;
        try {
            Image image = ImageIO.read(imageFile);
            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            Graphics2D graphics2D = bufferedImage.createGraphics();
            graphics2D.drawImage(image, 0, 0, width, height, null);

            outputStream = new FileOutputStream(new File(outputPath));
            JPEGImageEncoder jpegImageEncoder = JPEGCodec.createJPEGEncoder(outputStream);
            jpegImageEncoder.encode(bufferedImage);

            graphics2D.dispose();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 缩放图片
     * @param imagePath
     * @param rate
     * @param outputPath
     */
    public void scaleImage(String imagePath, float rate, String outputPath) {
        File imageFile = new File(imagePath);
        OutputStream outputStream = null;
        try {
            Image image = ImageIO.read(imageFile);
            int height = image.getHeight(null);
            int width = image.getWidth(null);

            int height2 = (int) (height * rate);
            int width2 = (int) (width * rate);

            BufferedImage bufferedImage = new BufferedImage(width2, height2, BufferedImage.TYPE_INT_RGB);

            Graphics2D graphics2D = bufferedImage.createGraphics();
            graphics2D.drawImage(image, 0, 0, width2, height2, null);

            outputStream = new FileOutputStream(new File(outputPath));
            JPEGImageEncoder jpegImageEncoder = JPEGCodec.createJPEGEncoder(outputStream);
            jpegImageEncoder.encode(bufferedImage);

            graphics2D.dispose();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
