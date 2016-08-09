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
 * Created by Richard on 7/9/16.
 */
public class TextWaterMarker {

    public void waterMark(String imagePath, String text, String outputPath) {
        // logoPath --> /Users/Richard/Desktop/xxx.png
        // imagePath --> /Users/Richard/Desktop/xxx.jpg
        OutputStream outputStream = null;

        try {
            //1.Read the image file
            File imageFile = new File(imagePath);
            Image image = ImageIO.read(imageFile);
            int height = image.getHeight(null);
            int width = image.getWidth(null);

            //2.create buffered image object
            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            //3.load image object
            Graphics2D graphics2D = bufferedImage.createGraphics();
            graphics2D.drawImage(image, 0, 0, width, height, null);

            //4. create text font
            graphics2D.setFont(new Font(Constants.FONT_NAME, Constants.FONT_STYLE, Constants.FONT_SIZE));
            graphics2D.setColor(Constants.FONT_COLOR);

            //5. create text content
            int width1 = Constants.FONT_SIZE * text.length();
            int height1 = Constants.FONT_SIZE;

            //6. compute the diff
            int diffW = width - width1;
            int diffH = height - height1;

            int x = 0;
            int y = 0;

            if(x < diffW) {
                x = diffW;
            }

            if(y < diffH) {
                y = diffH;
            }

            //7. set transparent text
            graphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, Constants.ALPHA));
            graphics2D.drawString(text, x, y);
            graphics2D.dispose();

            //8. export as image
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
