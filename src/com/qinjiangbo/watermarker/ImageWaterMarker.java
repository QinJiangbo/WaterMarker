package com.qinjiangbo.watermarker;

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
 * Created by Richard on 7/7/16.
 */
public class ImageWaterMarker {

    public void waterMark(String imagePath, String logoPath, String outputPath) {
        // logoPath --> /Users/Richard/Desktop/xxx.png
        // imagePath --> /Users/Richard/Desktop/xxx.jpg
        OutputStream outputStream = null;

        try {
            //1.read the image file
            File imageFile = new File(imagePath);
            Image image = ImageIO.read(imageFile);

            //2.create image buffer object
            int height = image.getHeight(null);
            int width = image.getWidth(null);
            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            //3.add image to buffered image object
            Graphics2D graphics2D = bufferedImage.createGraphics();
            graphics2D.drawImage(image, 0, 0, width, height, null);

            //4.read logo image file
            File logoFile = new File(logoPath);
            Image logo = ImageIO.read(logoFile);
            int width1 = logo.getWidth(null);
            int height1 = logo.getHeight(null);

            //5.get the gap of width, height between image and logo
            int diffW = width - width1;
            int diffH = height - height1;
            int x = Constants.X;
            int y = Constants.Y;

            //6.compare x, y and diffW , diffH
            if(x < diffW) {
                x = diffW - 100;
            }

            if(y < diffH) {
                y = diffH - 100;
            }

            //7.add logo to buffered image object
            graphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, Constants.ALPHA));
            graphics2D.drawImage(logo, x, y, null);
            graphics2D.dispose();

            //8.export as jpg image
            outputStream = new FileOutputStream(outputPath);
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
