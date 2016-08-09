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
public class MergeImage {

    /**
     * 拼接图片
     * @param imagePaths
     * @param outputPath
     * @param style
     */
    public void mergeImages(String[] imagePaths, Style style, String outputPath) {
        int size = imagePaths.length;
        OutputStream outputStream = null;
        if(style == Style.LEFT1RIGHT2) {
            if(size != 3) {
                throw new RuntimeException(String.format("the number of images is not 3, [%d]", size));
            }
            File imageFile0 = new File(imagePaths[0]);
            File imageFile1 = new File(imagePaths[1]);
            File imageFile2 = new File(imagePaths[2]);
            try {
                Image image0 = ImageIO.read(imageFile0);
                Image image1 = ImageIO.read(imageFile1);
                Image image2 = ImageIO.read(imageFile2);
                int height = image0.getHeight(null);
                int width = image0.getWidth(null);

                BufferedImage bufferedImage = new BufferedImage(width * 2, height, BufferedImage.TYPE_INT_RGB);
                Graphics2D graphics2D = bufferedImage.createGraphics();
                graphics2D.drawImage(image0, 0, 0, null);
                graphics2D.drawImage(image1, width, 0, width, height / 2, null);
                graphics2D.drawImage(image2, width, height / 2, width, height / 2, null);

                outputStream = new FileOutputStream(new File(outputPath));
                JPEGImageEncoder jpegImageEncoder = JPEGCodec.createJPEGEncoder(outputStream);
                jpegImageEncoder.encode(bufferedImage);

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
}