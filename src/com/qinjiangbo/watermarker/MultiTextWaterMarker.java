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
 * Created by Richard on 7/10/16.
 */
public class MultiTextWaterMarker {

    public void waterMark(String imagePath, String text, String outputPath) {
        File imageFile = new File(imagePath);
        OutputStream outputStream = null;
        try {
            Image image = ImageIO.read(imageFile);
            int height = image.getHeight(null);
            int width = image.getWidth(null);

            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            Graphics2D graphics2D = bufferedImage.createGraphics();
            graphics2D.drawImage(image, 0, 0, width, height, null);

            graphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, Constants.ALPHA));
            graphics2D.rotate(Math.toRadians(30), width / 2, height / 2);

            graphics2D.setFont(new Font(Constants.FONT_NAME, Constants.FONT_STYLE, Constants.FONT_SIZE));
            graphics2D.setColor(Constants.FONT_COLOR);

            int width1 = Constants.FONT_SIZE * text.length();
            int height1 = Constants.FONT_SIZE;

            int x= -width / 2;
            int y = -height / 2;

            while (x < 1.5 * width) {
                while (y < 1.5 * height) {
                    graphics2D.drawString(text, x, y);
                    y += height1 + 100;
                }
                y = -height / 2;
                x += width1;
            }
            graphics2D.dispose();

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
